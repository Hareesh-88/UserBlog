package com.userblog.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.hibernate.jpa.criteria.expression.function.CurrentDateFunction;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.userblog.dao.UserDao;
import com.userblog.dto.UserBlogDto;
import com.userblog.dto.UserDto;
import com.userblog.entity.UserBlog;
import com.userblog.entity.UserDetails;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;
	

	public UserDto getUserDetails(UserDto userDto){
		UserDto userDt = null;
		try{
			UserDetails user=userDao.getUserDetails(userDto);	
			if(user!=null){
				userDt = new UserDto();
				userDt.setUserName(userDt.getUserName());
				userDt.setUserId(userDt.getUserId());
			}else{
				userDt = null;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return userDt;
	}
	
	
	
	@Override
	public boolean saveUserDetails(UserDto userDto) {
		boolean status=false;
		UserDetails user= new UserDetails();
		try{
			user.setUserName(userDto.getUserName());
			user.setEmail(userDto.getEmail());
			user.setPassword(userDto.getPassword());
 			status = userDao.saveUserDetails(user);	
			System.out.println("");
		}catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}
	
	

	@Override
	public boolean saveUserBlog(UserBlogDto userBlogDto,String userId) {
		boolean status=false;
		UserBlog userBlog= new UserBlog();
		try{
			userBlog.setBlogName(userBlogDto.getBlogName());
			userBlog.setTiltleHeader(userBlogDto.getTiltleHeader());
			userBlog.setTitleDescription(userBlogDto.getTitleDescription());
			userBlog.setMainContent(userBlogDto.getMainContent());
			userBlog.setFooter(userBlogDto.getFooter());
			Calendar date = Calendar.getInstance();
			DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			userBlog.setCreateDate(sdf.format(date));
			userBlog.setCreatedBy(userId);
			status = userDao.saveUserBlog(userBlog);	
		}catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}
	
	

	@Override
	public String getUserBlogById(String userId) {
		boolean status=false;
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = null;
		try{
			List<UserBlog> userBlogList  = userDao.getUserBlogById(userId);
			if(userBlogList!=null){
			for (UserBlog userBlog : userBlogList) {
				jsonObject = new JSONObject();
				jsonObject.put("blogName",
						userBlog.getBlogName());
				jsonObject.put("header",
						userBlog.getTiltleHeader());
				jsonObject.put("description",
						userBlog.getTitleDescription());
				jsonObject.put("footer",
						userBlog.getFooter());
				jsonObject.put("content",
						userBlog.getFooter());
				jsonArray.put(jsonObject);
			 }
			}	
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return jsonArray.toString();
	}
	
	
	
	
	
	
	
	
	
}
