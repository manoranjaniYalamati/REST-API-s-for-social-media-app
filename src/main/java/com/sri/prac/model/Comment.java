package com.sri.prac.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Comment {
	@Id
	String id;
	String userId;
	String statusId;
	String comment;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getStatusId() {
		return statusId;
	}
	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Comment(String userId, String statusId, String comment) {
		super();
		this.userId = userId;
		this.statusId = statusId;
		this.comment = comment;
	}
	
	
	
}
