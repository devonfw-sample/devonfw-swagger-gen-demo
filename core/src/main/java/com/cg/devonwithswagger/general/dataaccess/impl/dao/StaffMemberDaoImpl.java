package com.cg.devonwithswagger.general.dataaccess.impl.dao;

import java.util.List;

import javax.inject.Named;

import com.cg.devonwithswagger.general.dataaccess.api.StaffMemberEntity;
import com.cg.devonwithswagger.general.dataaccess.api.dao.StaffMemberDao;
import com.cg.devonwithswagger.general.dataaccess.base.dao.ApplicationDaoImpl;
import com.cg.devonwithswagger.general.logic.api.to.StaffMemberSearchCriteriaTo;
import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

import io.oasp.module.jpa.common.api.to.OrderByTo;
import io.oasp.module.jpa.common.api.to.OrderDirection;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * This is the implementation of {@link StaffMemberDao}.
 */
@Named
public class StaffMemberDaoImpl extends ApplicationDaoImpl<StaffMemberEntity> implements StaffMemberDao {

  /**
   * The constructor.
   */
  public StaffMemberDaoImpl() {

    super();
  }

  @Override
  public Class<StaffMemberEntity> getEntityClass() {

    return StaffMemberEntity.class;
  }

  @Override
  public PaginatedListTo<StaffMemberEntity> findStaffMembers(StaffMemberSearchCriteriaTo criteria) {

    StaffMemberEntity staffmember = Alias.alias(StaffMemberEntity.class);
    EntityPathBase<StaffMemberEntity> alias = Alias.$(staffmember);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    String name = criteria.getName();
    if (name != null) {
      query.where(Alias.$(staffmember.getName()).eq(name));
    }
    String firstName = criteria.getFirstName();
    if (firstName != null) {
      query.where(Alias.$(staffmember.getFirstName()).eq(firstName));
    }
    String lastName = criteria.getLastName();
    if (lastName != null) {
      query.where(Alias.$(staffmember.getLastName()).eq(lastName));
    }
    addOrderBy(query, alias, staffmember, criteria.getSort());

    return findPaginated(criteria, query, alias);
  }

  private void addOrderBy(JPAQuery query, EntityPathBase<StaffMemberEntity> alias, StaffMemberEntity staffmember,
      List<OrderByTo> sort) {

    if (sort != null && !sort.isEmpty()) {
      for (OrderByTo orderEntry : sort) {
        switch (orderEntry.getName()) {
        case "name":
          if (OrderDirection.ASC.equals(orderEntry.getDirection())) {
            query.orderBy(Alias.$(staffmember.getName()).asc());
          } else {
            query.orderBy(Alias.$(staffmember.getName()).desc());
          }
          break;
        case "firstName":
          if (OrderDirection.ASC.equals(orderEntry.getDirection())) {
            query.orderBy(Alias.$(staffmember.getFirstName()).asc());
          } else {
            query.orderBy(Alias.$(staffmember.getFirstName()).desc());
          }
          break;
        case "lastName":
          if (OrderDirection.ASC.equals(orderEntry.getDirection())) {
            query.orderBy(Alias.$(staffmember.getLastName()).asc());
          } else {
            query.orderBy(Alias.$(staffmember.getLastName()).desc());
          }
          break;
        }
      }
    }
  }

}