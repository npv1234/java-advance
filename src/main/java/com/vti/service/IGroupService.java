package com.vti.service;

import java.util.List;

import com.vti.entity.Group;
import com.vti.form.FormGroup;

public interface IGroupService {
	void addNewGroup(FormGroup formGroup);
	List<Group> getListGroups();
	void deleteGroup(int id);
	void updateGroup(FormGroup formGroup);
	void deleteGroups(List<Integer> ids);
}
