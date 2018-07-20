package com.cg.devonwithswagger.general.logic.api.to;

import com.cg.devonwithswagger.general.common.api.to.AbstractCto;

/**
 * Composite transport object of StaffMember
 */
public class StaffMemberCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private StaffMemberEto staffMember;

  public StaffMemberEto getStaffMember() {

    return staffMember;
  }

  public void setStaffMember(StaffMemberEto staffMember) {

    this.staffMember = staffMember;
  }

}
