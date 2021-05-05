package com.sri.prac.model;

import java.util.Collection;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Status {
	private static final String action = null;
		//static Status status=new Status();
		@Id
		String id;
		String userId;
		String title;
		String description;
		String url;
		
		public Status(String userId, String title, String description, String url) {
			super();
			this.userId = userId;
			this.title = title;
			this.description = description;
			this.url = url;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public static String getAction() {
			return action;
		}
		
		
		
		
}
