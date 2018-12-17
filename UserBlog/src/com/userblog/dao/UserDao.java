package com.userblog.dao;

import java.util.List;

import com.userblog.dto.UserDto;
import com.userblog.entity.UserBlog;
import com.userblog.entity.UserDetails;

public interface UserDao {
	
	boolean saveUserDetails(UserDetails user);
	UserDetails getUserDetails(UserDto userDto);
	boolean saveUserBlog(UserBlog userBlog);
	List<UserBlog> getUserBlogById(String userId);
}
