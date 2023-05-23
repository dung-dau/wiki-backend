package com.ddau.wiki.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Page {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String title;
	
	private String content;
	
	private String imageUrl;
	
	public Page() {}

	public Page(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}

	public Page(String title, String content, String imageUrl) {
		this(title, content);
		this.imageUrl = imageUrl;
	}

	public Page(int id, String title, String content, String imageUrl) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.imageUrl = imageUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "Page [title=" + title + ", content=" + content + "]";
	}
}
