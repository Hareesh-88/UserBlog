package com.userblog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.userblog.dto.UserBlogDto;
import com.userblog.dto.UserDto;
import com.userblog.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
    UserService userService;
	
	@RequestMapping(value = "/userLogin")
	public @ResponseBody String getUserDetails(UserDto userDto) {
		String status="fail";
		JSONArray  jsonArr = new JSONArray();
		try {
			JSONObject json = new JSONObject();
			UserDto user = userService.getUserDetails(userDto);
			JSONObject jsonObj = new JSONObject();	
            jsonObj.put("userid",user.getUserId());
		    jsonObj.put("username", user.getUserName());
		    jsonObj.put("emailId", user.getEmail());
		    jsonArr.put(jsonObj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonArr.toString();
	}
	
	
	@RequestMapping(value = "/userSignUp")
	public @ResponseBody String saveUserDetails(UserDto userDto) {
		String status="fail";
		try {
			JSONObject json = new JSONObject();
			if (userService.saveUserDetails(userDto)) {
				status="success";
			}
			return status;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	@RequestMapping(value = "/saveUserBlog")
	public @ResponseBody String saveUserBlog(UserBlogDto userBlogDto,String userId) {
		String status="fail";
		try {
			JSONObject json = new JSONObject();
			if (userService.saveUserBlog(userBlogDto,userId)) {
				status="success";
			}
			return status;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value = "/getUserBlogById")
	public @ResponseBody String getAllUserDetails(String userId) {
		try {
			return userService.getUserBlogById(userId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	

}
