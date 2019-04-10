package com.book.ream;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.book.exception.EnemyUserException;
import com.book.pojo.Role_permission;
import com.book.pojo.User;
import com.book.pojo.User_role;
import com.book.service.Role_permissionService;
import com.book.service.UserService;
import com.book.service.User_roleService;


public class DatabaseRealm extends AuthorizingRealm{

	@Autowired
	private User_roleService user_roleService;
	@Autowired
	private Role_permissionService role_permissionService;
	@Autowired
	private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		Set<String> permissions = new HashSet<>();
		Set<String> roles = new HashSet<>();
		String username = (String) principalCollection.getPrimaryPrincipal();
		List<User_role> user_roles = user_roleService.get_UserNameUser_role(username);
		Iterator<User_role> iterator =  user_roles.iterator();
		while (iterator.hasNext()) {
			User_role user_role = (User_role) iterator.next();
			roles.add(user_role.getRole().getName());

			List<Role_permission> rplist = 
					role_permissionService.get_RoleNameRole_permission
					(user_role.getRole().getName());
			Iterator<Role_permission> rpiterator = rplist.iterator();
			while (rpiterator.hasNext()) {
				Role_permission role_permission = (Role_permission) rpiterator.next();
				permissions.add(role_permission.getPermission().getName());
			}
		}

		// 授权对象
		SimpleAuthorizationInfo s = new SimpleAuthorizationInfo();
		// 把通过service获取到的角色和权限放进去
		s.setStringPermissions(permissions);
		s.setRoles(roles);
		return s;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 获取账号密码
		UsernamePasswordToken t = (UsernamePasswordToken) token;
		String userName = token.getPrincipal().toString();
		System.out.println(userName);
		User user = userService.get_nameUser(userName);
		String passwordInDB = "43e28304197b9216e45ab1ce8dac831b";
		String salt = "e5ykFiNwShfCXvBRPr3wXg==";
		if (user == null) {
			 try {
				throw new EnemyUserException("没有查到当前用户");
			} catch (EnemyUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			 passwordInDB = user.getPassword();
			 salt = user.getSalt();
		}
	
		// 认证信息里存放账号密码, getName() 是当前Realm的继承方法,通常返回当前类名 :databaseRealm
		// 盐也放进去
		// 这样通过applicationContext-shiro.xml里配置的 HashedCredentialsMatcher 进行自动校验
		SimpleAuthenticationInfo a = new SimpleAuthenticationInfo(userName, passwordInDB, ByteSource.Util.bytes(salt),
				getName());
		return a;
	}

}
