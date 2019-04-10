package com.book.controller;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.book.pojo.Author;
import com.book.pojo.Book;
import com.book.pojo.Category;
import com.book.pojo.Permission;
import com.book.pojo.Reader;
import com.book.pojo.Reader_book;
import com.book.pojo.Role;
import com.book.pojo.Role_permission;
import com.book.pojo.State;
import com.book.pojo.User;
import com.book.pojo.User_role;
import com.book.service.AuthorService;
import com.book.service.BookService;
import com.book.service.CategoryService;
import com.book.service.PermissionService;
import com.book.service.ReaderService;
import com.book.service.Reader_bookService;
import com.book.service.RoleService;
import com.book.service.Role_permissionService;
import com.book.service.StateService;
import com.book.service.UserService;
import com.book.service.User_roleService;

@Controller
@RequestMapping("")
public class PageController {

	@Autowired
	BookService bookService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	AuthorService authorService;
	@Autowired
	ReaderService readerService;
	@Autowired
	Reader_bookService reader_bookService;
	@Autowired
	StateService stateService;
	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;
	@Autowired
	PermissionService permissionService;
	@Autowired
	User_roleService urservice;
	@Autowired
	Role_permissionService rpservice;

	//获取登录和首页的页面路径
	@RequestMapping("/getIndex")
	public String getIndex() {
		return "index";
	}

	@RequestMapping("/getLoginPage")
	public String getLoginPage() {
		return "login";
	}


	//获取图书管理的相关页面
	@RequestMapping("/getBookViewPage")
	public String getBookViewPage(Model m) {
		List<Book> books = bookService.getAllBook();
		m.addAttribute("b", books);
		return "bookView";
	}

	@RequestMapping("/getAddBookPage")
	public String getAddBookPage(Model m) {
		List<Category> categories = categoryService.getAllCategory();
		m.addAttribute("c", categories);
		return "addbook";
	}

	@RequestMapping("/getUpdateBookPage")
	public String getUpdateBookPage(Model m,int id) {
		List<Category> categories = categoryService.getAllCategory();
		m.addAttribute("c", categories);
		Book book = bookService.getBook(id);
		m.addAttribute("b", book);
		return "updateBook";
	}


	//获取图书分类管理的相关页面
	@RequestMapping("/getCategoryPage")
	public String getCategoryViewPage(Model m) {
		List<Category> categories = categoryService.getAllCategory();
		m.addAttribute("c", categories);
		return "categoryView";
	}

	@RequestMapping("/getAddCategoryPage")
	public String getAddCategoryPage() {
		return "addCategory";
	}

	@RequestMapping("/getUpdateCategoryPage")
	public String getUpdateCategoryPage(Model m,int id) {
		Category category = categoryService.getCategory(id);
		m.addAttribute("c", category);
		return "updateCategory";
	}


	//获取图书作者管理的相关页面
	@RequestMapping("/getAuthorViewPage")
	public String getAuthorViewPage(Model m) {
		List<Author> authors = authorService.getAllAuthor();
		m.addAttribute("a", authors);
		return "authorView";
	}

	@RequestMapping("/getAddAuthorPage")
	public String getAddAuthorPage() {
		return "addAuthor";
	}

	@RequestMapping("/getUpdateAuthorPage")
	public String getUpdateAuthoryPage(Model m,int id) {
		Author author = authorService.getAuthor(id);
		m.addAttribute("a", author);
		return "updateAuthor";
	}


	//获取读者管理的相关页面
	@RequestMapping("/getReaderViewPage")
	public String getReaderViewPage(Model m) {
		List<Reader> readers = readerService.getAllReader();
		m.addAttribute("r", readers);
		return "readerView";
	}

	@RequestMapping("/getAddReaderPage")
	public String getAddReaderPage() {
		return "addReader";
	}

	@RequestMapping("/getUpdateReaderPage")
	public String getUpdateReaderPage(Model m,int id) {
		Reader reader = readerService.getReader(id);
		m.addAttribute("r", reader);
		return "updateReader";
	}

	//获取借书管理的相关页面
	@RequestMapping("/getReader_bookViewPage")
	public String getReader_bookViewPage(Model m) {
		List<Reader_book> rBooks = reader_bookService.getAllReader_book();
		m.addAttribute("rb", rBooks);
		return "reader_bookView";
	}

	@RequestMapping("/getAddReader_bookPage")
	public String getAddReader_bookPage(Model model) {
		List<State> list = stateService.getAllState();
		model.addAttribute("s", list);
		return "addReader_book";
	}

	@RequestMapping("/getUpdateReader_bookPage")
	public String getUpdateReader_bookPage(Model m,int id) {
		Reader_book rb = reader_bookService.getReader_book(id);
		m.addAttribute("rb", rb);
		List<State> list = stateService.getAllState();
		m.addAttribute("s", list);
		return "updateReader_book";
	}

	//获取借书状态管理的相关页面
	@RequestMapping("/getStateViewPage")
	public String getStateViewPage(Model m) {
		List<State> states = stateService.getAllState();
		m.addAttribute("s", states);
		return "stateView";
	}

	@RequestMapping("/getAddStatePage")
	public String getAddStatePage() {
		return "addState";
	}

	@RequestMapping("/getUpdateStatePage")
	public String getUpdateStatePage(Model m,int id) {
		State state = stateService.getState(id);
		m.addAttribute("s", state);
		return "updateState";
	}

	//获取后台管理用户的相关页面
	@RequestMapping("/getUserViewPage")
	public String getUserViewPage(Model m) {
		Map<String, List<String>> urMap = new HashMap<>();
		List<User> users = userService.getAllUser();
		for (User user : users) {
			List<String> roleList = new ArrayList<>();
			List<User_role> list = 
					urservice.get_UserNameUser_role(user.getUsername());
			for (User_role user_role : list) {
				roleList.add(user_role.getRole().getDesc_());
			}
			urMap.put(user.getUsername(), roleList);
		}
		m.addAttribute("r",urMap);
		m.addAttribute("u", users);
		return "userView";
	}

	@RequestMapping("/getAddUserPage")
	public String getAddUserPage(Model m) {
		List<Role> list = roleService.getAllRole();
		m.addAttribute("r", list);
		return "addUser";
	}

	@RequestMapping("/getUpdateUserPage")
	public String getUpdateUserPage(Model m,int id) {
		User user = userService.getUser(id);
		m.addAttribute("u", user);
		List<Role> list = roleService.getAllRole();
		m.addAttribute("r", list);
		
		List<String> roleList = new ArrayList<>();
		List<User_role> list1 = 
				urservice.get_UserNameUser_role(user.getUsername());
		for (User_role user_role : list1) {
			roleList.add(user_role.getRole().getDesc_());
		}
		m.addAttribute("ur", roleList);
		return "updateUser";
	}

	//获取后台管理角色的相关页面
	@RequestMapping("/getRoleViewPage")
	public String getRoleViewPage(Model m) {
		Map<String, List<String>> rpMap = new HashMap<>();
		List<Role> roles = roleService.getAllRole();
		m.addAttribute("r", roles);
		for (Role role : roles) {
			List<String> pList = new ArrayList<>();
			List<Role_permission> list = 
					rpservice.get_RoleNameRole_permission(role.getName());
			for (Role_permission role_permission : list) {
				pList.add(role_permission.getPermission().getDesc_());
			}
			rpMap.put(role.getName(), pList);
		}
		m.addAttribute("rp", rpMap);
		return "roleView";
	}

	@RequestMapping("/getAddRolePage")
	public String getAddRolePage(Model m) {
		List<Permission> permissions = permissionService.getAllPermission();
		m.addAttribute("p", permissions);
		return "addRole";
	}

	@RequestMapping("/getUpdateRolePage")
	public String getUpdateRolePage(Model m,int id) {
		Role role = roleService.getRole(id);
		m.addAttribute("r", role);
		List<String> pList = new ArrayList<>();
		List<Role_permission> list = 
				rpservice.get_RoleNameRole_permission(role.getName());
		
		for (Role_permission role_permission : list) {
			pList.add(role_permission.getPermission().getDesc_());
		}
		m.addAttribute("rp", pList);
		List<Permission> permissions = permissionService.getAllPermission();
		m.addAttribute("p", permissions);
		return "updateRole";
	}

	//获取后台管理权限的相关页面
	@RequestMapping("/getPermissionViewPage")
	public String getPermissionViewPage(Model m) {
		List<Permission> permissions = permissionService.getAllPermission();
		m.addAttribute("p", permissions);
		return "permissionView";
	}

	@RequestMapping("/getAddPermissionPage")
	public String getAddPermissionPage() {
		return "addPermission";
	}

	@RequestMapping("/getUpdatePermissionPage")
	public String getUpdatePermissionPage(Model m,int id) {
		Permission permission = permissionService.getPermission(id);
		m.addAttribute("p", permission);
		return "updatePermission";
	}
	
	//未授权页面
	@RequestMapping("/unauthorized")
	public String getUnauthorized(Model m) {
		m.addAttribute("error", "你没有这个操作的权限");
		return "error";
	} 
}
