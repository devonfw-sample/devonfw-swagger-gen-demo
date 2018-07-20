package com.cg.devonwithswagger.general.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import com.cg.devonwithswagger.general.logic.api.General;
import com.cg.devonwithswagger.general.logic.api.to.StaffMemberCto;
import com.cg.devonwithswagger.general.logic.api.to.StaffMemberEto;
import com.cg.devonwithswagger.general.logic.api.to.StaffMemberSearchCriteriaTo;
import com.cg.devonwithswagger.general.service.api.rest.GeneralRestService;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link General}.
 */
@Named("GeneralRestService")
public class GeneralRestServiceImpl implements GeneralRestService {

  @Inject
  private General general;

  @Override
  public StaffMemberEto getStaffMember(long id) {

    return this.general.findStaffMember(id);
  }

  @Override
  public StaffMemberEto saveStaffMember(StaffMemberEto staffmember) {

    return this.general.saveStaffMember(staffmember);
  }

  @Override
  public void deleteStaffMember(long id) {

    this.general.deleteStaffMember(id);
  }

  @Override
  public PaginatedListTo<StaffMemberEto> findStaffMembersByPost(StaffMemberSearchCriteriaTo searchCriteriaTo) {

    return this.general.findStaffMemberEtos(searchCriteriaTo);
  }

  @Override
  public StaffMemberCto getStaffMemberCto(long id) {

    return this.general.findStaffMemberCto(id);
  }

  @Override
  public PaginatedListTo<StaffMemberCto> findStaffMemberCtosByPost(StaffMemberSearchCriteriaTo searchCriteriaTo) {

    return this.general.findStaffMemberCtos(searchCriteriaTo);
  }
}