package com.vishwa.entities;

import org.springframework.data.annotation.Id;

public class Todo {
	public static final int  MAX_LENGTH_DESCRIPTION = 500;
	public static final int MAX_LENGTH_TITLE = 100;
	 
	@Id
	private String id ;
	private String description ;
	private String title ;
	
	public Todo(){
		
	}
	
	private Todo(Builder builder){
		this.description = builder.description;
		this.title = builder.title ;
	}
	
	public static Builder getBuilder(){
		return new Builder();
	}
	
	public void update(String title , String description){
		checkTitleAndDescription(title, description);
		this.title = title ;
		this.description = description ;
	}
	
	
	public static class Builder{
		private String description ;
		private String title ;
		private Builder(){
			
		}
		public Builder description(String desription){
			this.description = description ;
			return this ;
		}
		
		public Builder title(String title){
			this.title = title ;
			return this ;
		}
		
		public Todo build(){
			Todo build = new Todo(this);
			build.checkTitleAndDescription(title, description);
			return build ;
		}
	}
	
	private void checkTitleAndDescription(String title , String description){
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	

}
