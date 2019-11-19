package com.example.xts.greendaodemo.db;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import commd.jy.zl.day01_01.SqlBean;

import com.example.xts.greendaodemo.db.SqlBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig sqlBeanDaoConfig;

    private final SqlBeanDao sqlBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        sqlBeanDaoConfig = daoConfigMap.get(SqlBeanDao.class).clone();
        sqlBeanDaoConfig.initIdentityScope(type);

        sqlBeanDao = new SqlBeanDao(sqlBeanDaoConfig, this);

        registerDao(SqlBean.class, sqlBeanDao);
    }
    
    public void clear() {
        sqlBeanDaoConfig.clearIdentityScope();
    }

    public SqlBeanDao getSqlBeanDao() {
        return sqlBeanDao;
    }

}
