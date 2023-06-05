package com.vti.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="`Group`")
public class Group {
	@Column(name="id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="group_name", length = 50, nullable = false)
	private String groupName;
	
	@Column(name="total_member")
	private int totalMember;
	
	//Chúng ta coi một group chỉ do một accoutn tạo ra
	//bảng con
	@ManyToOne
	@JoinColumn(name="account_id", referencedColumnName="id")
	private Account creator;
	
	@Column(name="created_date")
	private Date createdAt;
	
	public Group() {
		
	}
	
	public Group(String groupName, int totalMember, Account creator, Date createdAt) {
		super();
		this.groupName = groupName;
		this.totalMember = totalMember;
		this.creator = creator;
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

	public Account getCreator() {
		return creator;
	}

	public void setCreator(Account creator) {
		this.creator = creator;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	@Override
	public String toString() {
		return "[id=" + id + "; groupName=" + groupName + "; totalMember=" + 
	totalMember + ";createdAt=" + createdAt + ";creator=" + creator  + "]";
	}
	
	
	
	
}
