package com.vti.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class GroupDTO {
	private int id;
	private String groupName;
	private int totalMember;
	private String creatorUsername;
	private int creatorId;
	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date createdAt;
	
	public GroupDTO() {
		
	}
	
	public GroupDTO(int id, String groupName, int totalMember, String creatorUsername, int creatorId, Date createdAt) {
		super();
		this.id = id;
		this.groupName = groupName;
		this.totalMember = totalMember;
		this.creatorUsername = creatorUsername;
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
	public String getCreatorUsername() {
		return creatorUsername;
	}
	public void setCreatorUsername(String creatorUsername) {
		this.creatorUsername = creatorUsername;
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
	
	
}
