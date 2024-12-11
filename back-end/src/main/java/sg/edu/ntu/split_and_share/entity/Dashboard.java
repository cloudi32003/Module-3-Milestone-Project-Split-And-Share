package sg.edu.ntu.split_and_share.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dashboard")
public class Dashboard {
  @Id
  @OneToOne(mappedBy = "dashboard")
  @JsonIgnoreProperties("dashboard")
  private User user;

  @Column(name = "name", nullable = false)
  private String name;

  @OneToMany(mappedBy = "dashboard", cascade = CascadeType.ALL)
  private List<Expense> expenses;

  @OneToMany(mappedBy = "dashboard", cascade = CascadeType.ALL)
  private List<GroupMember> groupMembers;

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public List<Expense> getExpenses() {
    return this.expenses;
  }

  public void setExpenses(List<Expense> expenses) {
    this.expenses = expenses;
  }

  public List<GroupMember> getGroupMembers() {
    return this.groupMembers;
  }

  public void setGroupMembers(List<GroupMember> groupMembers) {
    this.groupMembers = groupMembers;
  }

}