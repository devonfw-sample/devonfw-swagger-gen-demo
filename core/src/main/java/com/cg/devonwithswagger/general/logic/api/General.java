package com.cg.devonwithswagger.general.logic.api;

import com.cg.devonwithswagger.general.logic.api.to.StaffMemberCto;
import com.cg.devonwithswagger.general.logic.api.to.StaffMemberEto;
import com.cg.devonwithswagger.general.logic.api.to.StaffMemberSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Interface for General component.
 */
public interface General {

  /**
   * Returns a StaffMember by its id 'id'.
   *
   * @param id The id 'id' of the StaffMember.
   * @return The {@link StaffMemberEto} with id 'id'
   */
  StaffMemberEto findStaffMember(Long id);

  /**
   * Returns a paginated list of StaffMembers matching the search criteria.
   *
   * @param criteria the {@link StaffMemberSearchCriteriaTo}.
   * @return the {@link List} of matching {@link StaffMemberEto}s.
   */
  PaginatedListTo<StaffMemberEto> findStaffMemberEtos(StaffMemberSearchCriteriaTo criteria);

  /**
   * Deletes a staffMember from the database by its id 'staffMemberId'.
   *
   * @param staffMemberId Id of the staffMember to delete
   * @return boolean <code>true</code> if the staffMember can be deleted, <code>false</code> otherwise
   */
  boolean deleteStaffMember(Long staffMemberId);

  /**
   * Saves a staffMember and store it in the database.
   *
   * @param staffMember the {@link StaffMemberEto} to create.
   * @return the new {@link StaffMemberEto} that has been saved with ID and version.
   */
  StaffMemberEto saveStaffMember(StaffMemberEto staffMember);

  /**
   * Returns a composite StaffMember by its id 'id'.
   *
   * @param id The id 'id' of the StaffMember.
   * @return The {@link StaffMemberCto} with id 'id'
   */
  StaffMemberCto findStaffMemberCto(Long id);

  /**
   * Returns a paginated list of composite StaffMembers matching the search criteria.
   *
   * @param criteria the {@link StaffMemberSearchCriteriaTo}.
   * @return the {@link List} of matching {@link StaffMemberCto}s.
   */
  PaginatedListTo<StaffMemberCto> findStaffMemberCtos(StaffMemberSearchCriteriaTo criteria);

}