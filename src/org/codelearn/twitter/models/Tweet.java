package org.codelearn.twitter.models;

public class Tweet {

	String id;
	String title;
	String body;
	
	public void setId(String id)
	{
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	
	public String getBody() {
		return body;
	}
}
