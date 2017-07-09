package com.mportal.ec.model;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;

//@Entity
//@Table(name = "user_role")
//public class UserRole {
//  @Embeddable
//  public static class Id implements Serializable {
//      private static final long serialVersionUID = 1322120000551624359L;
//      
//      @Column(name = "APP_USER_ID")
//      protected Integer userId;
//      
//      @Enumerated(EnumType.STRING)
//      @Column(name = "ROLE")
//      protected Role role;
//      
//      public Id() { }
//
//      public Id(Integer userId, Role role) {
//          this.userId = userId;
//          this.role = role;
//      }
//  }
//  
//  @EmbeddedId
//  Id id = new Id();
//  
//  @Enumerated(EnumType.STRING)
//  @Column(name = "ROLE", insertable=false, updatable=false)
//  protected Role role;
//
//  public Role getRole() {
//      return role;
//  }
//}
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user_role")
public class UserRole{
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id",
		unique = true, nullable = false)
	private Integer userRoleId;
	
	@JsonIgnore    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "APP_USER_ID", nullable = false)
	private User user;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "ROLE", insertable=false, updatable=false)
	private Role role;

	public UserRole() {
	}

	public UserRole(User user, Role role) {
		this.user = user;
		this.role = role;
	}

	public Integer getUserRoleId() {
		return this.userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}