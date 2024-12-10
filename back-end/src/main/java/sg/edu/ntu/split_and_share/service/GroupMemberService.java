package sg.edu.ntu.split_and_share.service;

import java.util.List;

public interface GroupMemberService {

  List<String> addGroupMembers(List<String> groupMemberList);

  void removeGroupMember(String memberName);

  List<String> getAllGroupMembers();
}