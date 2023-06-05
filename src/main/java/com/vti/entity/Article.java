package com.vti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//Anotation
@Entity
@Table(name="Article")
public class Article {
	
	public Article () {
		
	}
	
	public Article(String title, String type, Status status) {
		this.title = title;
		this.type = type;
		this.status = status;
	}

	@Column(name="id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="title", length = 100, nullable = false)
	private String title;
	
	@Column(name="type", length = 50, nullable = false)
	private String type;
	
	@Column(name="status")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	public enum Status {
		OPEN, REVIEW, APPROVED, REJECT
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "[id=" + id + "; title=" + title + "; status=" + status + "; type=" + type + "]";
	}
	
	
	
	
}
