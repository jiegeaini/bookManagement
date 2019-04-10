package com.book.filter;


import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.book.pojo.Permission;
import com.book.pojo.Role_permission;
import com.book.pojo.User_role;
import com.book.service.PermissionService;
import com.book.service.Role_permissionService;
import com.book.service.User_roleService;
import com.book.util.SpringContextUtils;


public class URLFilter extends PathMatchingFilter {
	@Autowired
	PermissionService permissionService;
	@Autowired
	private User_roleService user_roleService;
	@Autowired
	private Role_permissionService role_permissionService;
	
	
	@Override
	protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		if(null==permissionService) 
			permissionService = SpringContextUtils.getContext().getBean(PermissionService.class);
		if(null==user_roleService) 
			user_roleService = SpringContextUtils.getContext().getBean(User_roleService.class);
		if(null==role_permissionService) 
			role_permissionService = SpringContextUtils.getContext().getBean(Role_permissionService.class);
		
		String requestURI = getPathWithinApplication(request);
		System.out.println("requestURI:" + requestURI);

		Subject subject = SecurityUtils.getSubject();
		// 如果没有登录，就跳转到登录页面
		if (!subject.isAuthenticated()) {
			WebUtils.issueRedirect(request, response, "/getLoginPage");
			return false;
		}

		// 看看这个路径权限里有没有维护，如果没有维护，一律放行
		System.out.println("permissionService:"+permissionService);
		boolean needInterceptor = false; 
		//开始获取所有权限url
		List<Permission> permissions = permissionService.getAllPermission();
		Iterator<Permission> piterator =  permissions.iterator();
		while (piterator.hasNext()) {
			Permission permission = (Permission) piterator.next();
			if (permission.getUrl().equals(requestURI)) {
				needInterceptor = true;
			}
		}
		
		//如果没有维护放行，维护过再进行权限验证
		if (!needInterceptor) {
			return true;
		} else {
			boolean hasPermission = false;
			String userName = subject.getPrincipal().toString();
			System.out.println(userName);
			List<User_role> user_roles = user_roleService.get_UserNameUser_role(userName);
			Iterator<User_role> iterator =  user_roles.iterator();
			fist:while (iterator.hasNext()) {
				User_role user_role = (User_role) iterator.next();
				List<Role_permission> rplist = 
						role_permissionService.get_RoleNameRole_permission
						(user_role.getRole().getName());
				Iterator<Role_permission> rpiterator = rplist.iterator();
				while (rpiterator.hasNext()) {
					Role_permission role_permission = (Role_permission) rpiterator.next();
					if (role_permission.getPermission().getUrl().equals(requestURI)) {
						hasPermission = true;
						break fist;
					}
				}
			}
			

			if (hasPermission)
				return true;
			else {
				UnauthorizedException ex = new UnauthorizedException("当前用户没有访问路径 " + requestURI + " 的权限");

				subject.getSession().setAttribute("ex", ex);

				WebUtils.issueRedirect(request, response, "/unauthorized");
				return false;
			}

		}

	}
}