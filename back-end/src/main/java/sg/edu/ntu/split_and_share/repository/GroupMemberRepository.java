package sg.edu.ntu.split_and_share.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.ntu.split_and_share.entity.GroupMember;

public interface GroupMemberRepository extends JpaRepository<GroupMember, Long> {

  // Find members from the dashboard by username & memberName
  Optional<GroupMember> findByDashboard_UsernameAndMemberName(String username, String memberName);

  // Find all members that belong to a given user's dashboard
  List<GroupMember> findByDashboard_Username(String username);

}
