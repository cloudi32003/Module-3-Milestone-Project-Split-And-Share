
package sg.edu.ntu.split_and_share.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "app_user")
public class User {
  @Id
  @Column(name = "username", unique = true, nullable = false)
  @NotBlank(message = "Username is mandatory")
  private String username;

  @Column(name = "password", nullable = false)
  @NotBlank(message = "password cannot be blank")
  @Size(min = 8, message = "Password must be 8 characters long")
  private String password;

  @Column(name = "name")
  @NotBlank(message = "Name is mandatory")
  private String name;

  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
  @JsonIgnoreProperties("user")
  private Dashboard dashboard;
}
