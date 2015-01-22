package com.crudweb.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.crudweb.Dao.UserDao;
import com.crudweb.model.User;
import com.crudweb.service.UserServ;

@Controller
public class HmoeController {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserServ userSerice;
	
	@RequestMapping(value="/")
	public ModelAndView home() {
		List<User> listUsers = userDao.list();
		ModelAndView model = new ModelAndView("home");
		model.addObject("userList", listUsers);
		return model;
	}
	@RequestMapping("/index")
	public String setupForm(Map<String,Object> map){
		User user = new User();
		map.put("user", user);
		map.put("userList",userSerice.list());
		return "user";
	}
	
	@RequestMapping(value="user.do",method=RequestMethod.POST)
	public String doAction(@ModelAttribute User user,BindingResult result, @RequestParam String action,Map<String,Object> map){
		User userResult = new User();
		switch(action.toLowerCase()){
		case "add":
			userSerice.add(user);
			userResult = user;
			break;
		case "edit":
			userSerice.edit(user);
			userResult = user;
			break;
		case "delete":
			userSerice.delete(user.getId());
			userResult = new User();
			break;
		case "search":
			User searchUser = userSerice.findUser(user.getId());
			userResult = searchUser != null ? searchUser : new User();
			break;
		}
		map.put("user",userResult);
		map.put("userList",userSerice.list());
		return "user";
		
	}
}
