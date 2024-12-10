package sg.edu.ntu.split_and_share.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.ntu.split_and_share.service.GroupMemberService;

@RestController
@RequestMapping("/api/group-members")
public class GroupMemberController {

  private GroupMemberService groupMemberService;

  public GroupMemberController(GroupMemberService groupMemberService) {
    this.groupMemberService = groupMemberService;
  }

  // Add group member(s) to user's dashboard
  // http://localhost:8080/api/group-members/add
  @PostMapping("/add")
  public ResponseEntity<List<String>> addGroupMembers(@RequestBody List<String> groupMemberList) {
    return new ResponseEntity<>(groupMemberService.addGroupMembers(groupMemberList), HttpStatus.CREATED);
  }

  // Remove group member(s) from user's dashboard
  // http://localhost:8080/api/group-members/remove/{member_name}
  @DeleteMapping("/remove/{member_name}")
  public ResponseEntity<HttpStatus> removeGroupMember(@PathVariable String memberName) {
    groupMemberService.removeGroupMember(memberName);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  // Get all group members
  // http://localhost:8080/api/group-members/list
  @GetMapping("/list")
  public ResponseEntity<List<String>> getAllGroupMembers() {
    return new ResponseEntity<>(groupMemberService.getAllGroupMembers(), HttpStatus.OK);
  }

}