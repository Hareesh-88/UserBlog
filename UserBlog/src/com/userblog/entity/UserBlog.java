package com.userblog.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_blog")
public class UserBlog implements Serializable{
	
	@Id
	@Column(name = "BLOG_ID")
    private String blogId;
	@Column(name = "BLOG_NAME")
	private String blogName;
	@Column(name = "BLOG_HEADER")
	private String tiltleHeader;
	@Column(name = "BLOG_DESCRIPTION")
	private String titleDescription;
	@Column(name = "BLOG_CONTENT")
	private String mainContent;
	@Column(name = "BLOG_FOOTER")
	private String footer;
	@Column(name = "BLOG_LEFT_CONTENT")
	private String leftContent;
	@Column(name = "BLOG_RFIGHT_CONTENT")
	private String rightContent;
	@Column(name = "CREATE_DATE")
	private String createDate;
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	
	public String getBlogId() {
		return blogId;
	}
	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}
	public String getBlogName() {
		return blogName;
	}
	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}
	public String getTiltleHeader() {
		return tiltleHeader;
	}
	public void setTiltleHeader(String tiltleHeader) {
		this.tiltleHeader = tiltleHeader;
	}
	public String getTitleDescription() {
		return titleDescription;
	}
	public void setTitleDescription(String titleDescription) {
		this.titleDescription = titleDescription;
	}
	public String getMainContent() {
		return mainContent;
	}
	public void setMainContent(String mainContent) {
		this.mainContent = mainContent;
	}
	public String getFooter() {
		return footer;
	}
	public void setFooter(String footer) {
		this.footer = footer;
	}
	public String getLeftContent() {
		return leftContent;
	}
	public void setLeftContent(String leftContent) {
		this.leftContent = leftContent;
	}
	public String getRightContent() {
		return rightContent;
	}
	public void setRightContent(String rightContent) {
		this.rightContent = rightContent;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	
	
	
	
	

}
