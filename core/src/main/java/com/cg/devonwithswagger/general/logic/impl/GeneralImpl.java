package com.cg.devonwithswagger.general.logic.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.cg.devonwithswagger.general.dataaccess.api.StaffMemberEntity;
import com.cg.devonwithswagger.general.dataaccess.api.dao.StaffMemberDao;
import com.cg.devonwithswagger.general.logic.api.General;
import com.cg.devonwithswagger.general.logic.api.to.StaffMemberCto;
import com.cg.devonwithswagger.general.logic.api.to.StaffMemberEto;
import com.cg.devonwithswagger.general.logic.api.to.StaffMemberSearchCriteriaTo;
import com.cg.devonwithswagger.general.logic.base.AbstractComponentFacade;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import io.oasp.module.jpa.common.api.to.PaginationResultTo;

/**
 * Implementation of component interface of general
 */
@Named
@Transactional
public class GeneralImpl extends AbstractComponentFacade implements General {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(GeneralImpl.class);

  /** @see #getStaffMemberDao() */
  @Inject
  private StaffMemberDao staffMemberDao;

  /**
   * The constructor.
   */
  public GeneralImpl() {

    super();
  }

  @Override
  public StaffMemberEto findStaffMember(Long id) {

    LOG.debug("Get StaffMember with id {} from database.", id);
    return getBeanMapper().map(getStaffMemberDao().findOne(id), StaffMemberEto.class);
  }

  @Override
  public PaginatedListTo<StaffMemberEto> findStaffMemberEtos(StaffMemberSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<StaffMemberEntity> staffmembers = getStaffMemberDao().findStaffMembers(criteria);
    return mapPaginatedEntityList(staffmembers, StaffMemberEto.class);
  }

  @Override
  public boolean deleteStaffMember(Long staffMemberId) {

    StaffMemberEntity staffMember = getStaffMemberDao().find(staffMemberId);
    getStaffMemberDao().delete(staffMember);
    LOG.debug("The staffMember with id '{}' has been deleted.", staffMemberId);
    return true;
  }

  @Override
  public StaffMemberEto saveStaffMember(StaffMemberEto staffMember) {

    Objects.requireNonNull(staffMember, "staffMember");
    StaffMemberEntity staffMemberEntity = getBeanMapper().map(staffMember, StaffMemberEntity.class);

    // initialize, validate staffMemberEntity here if necessary
    StaffMemberEntity resultEntity = getStaffMemberDao().save(staffMemberEntity);
    LOG.debug("StaffMember with id '{}' has been created.", resultEntity.getId());

    return getBeanMapper().map(resultEntity, StaffMemberEto.class);
  }

  /**
   * Returns the field 'staffMemberDao'.
   * 
   * @return the {@link StaffMemberDao} instance.
   */
  public StaffMemberDao getStaffMemberDao() {

    return this.staffMemberDao;
  }

  @Override
  public StaffMemberCto findStaffMemberCto(Long id) {

    LOG.debug("Get StaffMemberCto with id {} from database.", id);
    StaffMemberEntity entity = getStaffMemberDao().findOne(id);
    StaffMemberCto cto = new StaffMemberCto();
    cto.setStaffMember(getBeanMapper().map(entity, StaffMemberEto.class));

    return cto;
  }

  @Override
  public PaginatedListTo<StaffMemberCto> findStaffMemberCtos(StaffMemberSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<StaffMemberEntity> staffmembers = getStaffMemberDao().findStaffMembers(criteria);
    List<StaffMemberCto> ctos = new ArrayList<>();
    for (StaffMemberEntity entity : staffmembers.getResult()) {
      StaffMemberCto cto = new StaffMemberCto();
      cto.setStaffMember(getBeanMapper().map(entity, StaffMemberEto.class));
      ctos.add(cto);

    }
    PaginationResultTo pagResultTo = new PaginationResultTo(criteria.getPagination(), (long) ctos.size());
    PaginatedListTo<StaffMemberCto> pagListTo = new PaginatedListTo(ctos, pagResultTo);
    return pagListTo;
  }

}