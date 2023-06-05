package com.vti.service;

import java.util.List;

import com.vti.entity.Group;
import com.vti.form.FormGroup;
import com.vti.repository.GroupRepository;
import com.vti.repository.IGroupRepository;

public class GroupService implements IGroupService{
	private IGroupRepository grpRepository;
	
	public GroupService() {
		grpRepository = new GroupRepository();
	}
	
	public void addNewGroup(FormGroup formGroup) {
		grpRepository.addNewGroup(formGroup);
	}

	public List<Group> getListGroups() {
		// TODO Auto-generated method stub
		return grpRepository.getListGroups();
	}

	public void deleteGroup(int id) {
		grpRepository.deleteGroup(id);
	}

	public void updateGroup(FormGroup formGroup) {
		grpRepository.updateGroup(formGroup);
	}

	public void deleteGroups(List<Integer> ids) {
		grpRepository.deleteGroups(ids);
	}

}
