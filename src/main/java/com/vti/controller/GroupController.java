package com.vti.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.GroupDTO;
import com.vti.entity.Group;
import com.vti.form.FormGroup;
import com.vti.service.GroupService;
import com.vti.service.IGroupService;


@RestController
@RequestMapping(value="/api/v1/groups")
public class GroupController {
	private IGroupService grpService;
	
	public GroupController() {
		grpService = new GroupService();
	}
	
	@PostMapping
	public ResponseEntity<?> addNewGroup(@RequestBody FormGroup fromGroup) {
		System.out.println(fromGroup);
		grpService.addNewGroup(fromGroup);
		
		JSONObject message = new JSONObject();
		message.put("responseText", "Group created!");
		message.put("status", 200);
		return ResponseEntity.status(HttpStatus.OK).body(message.toString());
	}
	
//	@GetMapping
//	public List<Group> getListGroups() {
//		return grpService.getListGroups();
//	}
	// Using DTO
	@GetMapping
	public List<GroupDTO> getListGroups() {
		List<Group> groups = grpService.getListGroups();
		
		List<GroupDTO> listgroupDTO = new ArrayList<GroupDTO>();
		
		for (Group group : groups) {
			GroupDTO groupDTO = new GroupDTO(
				group.getId(),
				group.getGroupName(),
				group.getTotalMember(),
				group.getCreator().getUsername(),
				group.getCreator().getId(),
				group.getCreatedAt()
			);
			
			listgroupDTO.add(groupDTO);
		}
		
		return listgroupDTO;
	}
	
	
//	@DeleteMapping("/{id}")
//	public ResponseEntity<?> deleteGroup(@PathVariable(name="id") int id) {
//		System.out.println("id: " + id);
//		grpService.deleteGroup(id);
//		return ResponseEntity.status(HttpStatus.OK).body("Group deleted");
//	}
	
	@DeleteMapping()
    public ResponseEntity<?> deleteGroups(@RequestBody List<Integer> ids) throws JSONException {
        //...
        System.out.println("List group id for deleting: " + ids.toString());
        grpService.deleteGroups(ids);

        JSONObject message = new JSONObject();
        message.put("rusultText", "Groups deleted successfully");
        message.put("status", 200);

        return ResponseEntity.status(HttpStatus.OK).body(message.toString());
    }
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateGroup(@PathVariable(name="id") int id, @RequestBody FormGroup formGroup) {
		System.out.println("id: " + id);
		System.out.println(formGroup);
		
		formGroup.setId(id);
		grpService.updateGroup(formGroup);
		
		JSONObject message = new JSONObject();
		message.put("responseText", "Group updated!");
		message.put("status", 200);
		return ResponseEntity.status(HttpStatus.OK).body(message.toString());
	}
	
	
	
	
	
	
}
