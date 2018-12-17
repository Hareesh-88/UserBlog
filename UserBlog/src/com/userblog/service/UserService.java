package com.userblog.service;

import com.userblog.dto.UserBlogDto;
import com.userblog.dto.UserDto;

public interface UserService {
	
	
	boolean saveUserDetails(UserDto userDto);
	UserDto getUserDetails(UserDto userDto);
	boolean saveUserBlog(UserBlogDto userBlogDto,String userId);
	public  String getUserBlogById(String userId);
	

}
