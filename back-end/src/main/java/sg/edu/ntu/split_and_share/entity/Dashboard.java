package sg.edu.ntu.split_and_share.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dashboard")
public class Dashboard {
  @Id
  @Column(name = "username")
  private String username;

  @Column(name = "name", nullable = false)
  private String name;

  @OneToOne
  @JsonIgnoreProperties("dashboard")
  @JoinColumn(name = "username", nullable = false)
  private User user;

  @OneToMany(mappedBy = "dashboard", cascade = CascadeType.ALL)
  private List<Expense> expenses;

  @OneToMany(mappedBy = "dashboard", cascade = CascadeType.ALL)
  private List<GroupMember> groupMembers;
}