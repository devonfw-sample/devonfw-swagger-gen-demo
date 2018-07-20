package com.cg.devonwithswagger.general.dataaccess.api.dao;

import com.cg.devonwithswagger.general.dataaccess.api.StaffMemberEntity;
import com.cg.devonwithswagger.general.logic.api.to.StaffMemberSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Data access interface for StaffMember entities
 */
public interface StaffMemberDao extends ApplicationDao<StaffMemberEntity> {

  /**
   * Finds the {@link StaffMemberEntity staffmembers} matching the given {@link StaffMemberSearchCriteriaTo}.
   *
   * @param criteria is the {@link StaffMemberSearchCriteriaTo}.
   * @return the {@link PaginatedListTo} with the matching {@link StaffMemberEntity} objects.
   */
  PaginatedListTo<StaffMemberEntity> findStaffMembers(StaffMemberSearchCriteriaTo criteria);
}
