package com.userblog.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

    @Entity
	@Table(name="user_reg")
	public class UserDetails implements Serializable{
		@Id
		@Column(name = "USE_ID")
		private String userId;
		@Column(name = "USER_NAME")
		private String userName;
		@Column(name = "EMAIL")
		private String email;
		@Column(name = "PASSWORD")
		private char password;
		
		public UserDetails(String userId, String userName, String email, char password) {
			super();
			this.userId = userId;
			this.userName = userName;
			this.email = email;
			this.password = password;
		}

		public UserDetails() {
			
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public char getPassword() {
			return password;
		}

		public void setPassword(char password) {
			this.password = password;
		}

		
	

}
