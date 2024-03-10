package pe.borabora.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users") 
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @Column(unique = true, nullable = false)
	private Integer identity_doc;

	@NotBlank
	@Column(name = "name")
	private String name;
	
	@NotBlank
	@Column(name = "lastname")
	private String lastname;
	
	@NotBlank
	@Column(name = "cellphone") 
	private Integer cellphone;
	
	@Email
	@NotBlank
	@Column(name = "email")
	private String email;
	
	@NotBlank
	@Column(name = "username")
	private String username ;
	
	@NotBlank
	@Column(name = "password")
	private String password ;
	
	@ManyToMany(fetch = FetchType.EAGER, targetEntity = Role.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "identity_doc"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
	
	public UserEntity(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}	
}