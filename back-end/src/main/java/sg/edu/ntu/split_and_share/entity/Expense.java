package sg.edu.ntu.split_and_share.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table(name = "expense")
public class Expense {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "type")
  private String type;

  @Column(name = "amount")
  private Double amount;

  @Column(name = "description")
  private String description;

  @Column(name = "paid_by")
  private String paidBy;

  @ManyToOne
  @JoinColumn(name = "dashboard_id")
  private Dashboard dashboard;

  @ManyToMany
  @JoinTable(name = "expense_group_members", joinColumns = @JoinColumn(name = "expense_id"), inverseJoinColumns = @JoinColumn(name = "group_member_id"))
  private Set<GroupMember> sharedBy;
  /*
   * Set is used instead of List is because a Set does not allow duplicates
   * meaning user won't accidentally input same person twice in any expense, also
   * unlike List, there is no order required, which means user can enter names in
   * any order and it will work with no issue.
   */

}
