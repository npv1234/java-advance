package com.vti.form;

import java.util.Date;

public class FormGroup {
	private int id;
	private String groupName;
	private int totalMember;
	private int creatorId;
	private Date createdAt;
	
	public FormGroup() {
		
	}
	
	public FormGroup(String groupName, int totalMember, int creatorId, Date createdAt) {
		super();
		this.groupName = groupName;
		this.totalMember = totalMember;
		this.creatorId = creatorId;
		this.createdAt = createdAt;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public int getTotalMember() {
		return totalMember;
	}
	public void setTotalMember(int totalMember) {
		this.totalMember = totalMember;
	}
	public int getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	@Override
	public String toString() {
		return "[id=" + id + "; groupName=" + groupName 
				+ "; totalMember=" + totalMember
				+ "; creatorId=" + creatorId + "; createAd=" + createdAt
				+ "]";
	}
	
	
}
