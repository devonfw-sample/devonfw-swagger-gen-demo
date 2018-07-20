package com.cg.devonwithswagger.general.dataaccess.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.cg.devonwithswagger.general.common.api.StaffMember;

/**
 * The {@link devonfw.tutorial.general.dataaccess.api.ApplicationPersistenceEntity persistent entity} for
 * 
 * {@link StaffMember}.
 */
@Entity
@Table(name = "StaffMember")
public class StaffMemberEntity extends ApplicationPersistenceEntity implements StaffMember {

  private static final long serialVersionUID = 1L;

  private String name;

  private String firstName;

  private String lastName;

  /**
   * The constructor.
   */
  public StaffMemberEntity() {

    super();
  }

  @Column(name = "login", unique = true)
  @Override
  public String getName() {

    return this.name;
  }

  @Override
  public void setName(String login) {

    this.name = login;
  }

  @Override
  public String getFirstName() {

    return this.firstName;
  }

  @Override
  public void setFirstName(String firstName) {

    this.firstName = firstName;
  }

  @Override
  public String getLastName() {

    return this.lastName;
  }

  @Override
  public void setLastName(String lastName) {

    this.lastName = lastName;
  }

}
