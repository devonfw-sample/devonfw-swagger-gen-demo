package com.cg.devonwithswagger.general.dataaccess.base.dao;

import com.cg.devonwithswagger.general.dataaccess.api.BinaryObjectEntity;
import com.cg.devonwithswagger.general.dataaccess.api.dao.BinaryObjectDao;

import javax.inject.Named;

/**
 * Implementation of {@link BinaryObjectDao}.
 */
@Named
public class BinaryObjectDaoImpl extends ApplicationDaoImpl<BinaryObjectEntity> implements BinaryObjectDao {

  @Override
  public Class<BinaryObjectEntity> getEntityClass() {

    return BinaryObjectEntity.class;
  }

}
