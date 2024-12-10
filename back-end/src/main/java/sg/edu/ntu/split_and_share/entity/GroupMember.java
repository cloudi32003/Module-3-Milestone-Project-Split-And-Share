package sg.edu.ntu.split_and_share.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class GroupMember {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "member_name")
  private String memberName;

  /*
   * I set an initial balance of 0.0 so the value will not be null to avoid
   * NullPointerException
   */
  @Column(name = "balance", nullable = false)
  private Double balance = 0.0;

  @ManyToOne
  @JoinColumn(name = "dashboard_username", nullable = false, referencedColumnName = "username")
  private Dashboard dashboard;
}
