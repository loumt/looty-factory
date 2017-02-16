/**
 * Copyright (c) www.bugull.com
 */
package com.looty.base;

import com.looty.exception.DaoException;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.Map;

/**
 * USED TO:基础Dao
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project looty-factory
 * @package com.looty.base
 * @date 2017/2/12/012
 */
public class BaseDao {

    protected Logger logger = Logger.getLogger(getClass());
    /**
     * SpringMVC框架注入的参数JdbcTemplate 对象
     */
    @Autowired
    protected JdbcTemplate jdbcTemplate;

    /**
     * SpringMVC框架注入的参数NamedParameterJdbcTemplate 对象
     */
    @Autowired
    protected NamedParameterJdbcTemplate npjt;

    /**
     * 执行单条sql语句，如create table或者drop table
     *
     * @param sql 要执行sql语句
     */
    protected void executeSQL(String sql) throws DaoException {
        try {
            this.jdbcTemplate.execute(sql);
        } catch (DataAccessException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    /**
     * 执行单条insert、update或者delete语句
     *
     * @param sql 要执行的sql语句
     * @return 执行语句影响数据的条数
     */
    protected int update(String sql) throws DaoException {
        try {
            return this.jdbcTemplate.update(sql);
        } catch (DataAccessException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    /**
     * 执行单条insert、update或者delete语句
     *
     * @param sql  要执行的sql语句
     * @param args 语句中的参数
     * @return 执行语句影响数据的条数
     */
    protected int update(String sql, Object... args) throws DaoException {
        try {
            return this.jdbcTemplate.update(sql, args);
        } catch (DataAccessException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    /**
     * 执行select语句，获取一个记录
     *
     * @param sql          要执行的语句
     * @param requiredType 返回对象类型
     * @return 单个数据对象
     */
    protected <T> T queryForObject(String sql, Class<T> requiredType)
            throws DaoException {
        try {
            return this.jdbcTemplate.queryForObject(sql, requiredType);
        } catch (DataAccessException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    /**
     * 执行select语句，获取一个记录
     *
     * @param sql          要执行的语句
     * @param requiredType 返回对象类型
     * @param args         参数
     * @return 单个数据对象
     * @throws DaoException
     */
    protected <T> T queryForObject(String sql, Class<T> requiredType,
                                   Object... args) throws DaoException {
        try {
            return this.jdbcTemplate.queryForObject(sql, requiredType, args);
        } catch (DataAccessException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    /**
     * 执行select语句，获取一个记录,并转换为传入类型Bean
     *
     * @param sql          要执行的语句
     * @param requiredType 返回对象类型
     * @return Bean数据对象
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    protected <T> T queryForBean(String sql, Class<T> requiredType)
            throws DaoException {
        try {
            Map m = this.jdbcTemplate.queryForMap(sql);
            Class<?> cls = Class.forName(requiredType.getName());// 取得Class对象
            Object obj = cls.newInstance();
            T t = (T) obj;
            BeanUtils.copyProperties(t, m);
            return t;
        } catch (EmptyResultDataAccessException ede) {
            logger.debug(ede.getMessage());
            return null;
        } catch (Exception e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    /**
     * 执行select语句，获取一个记录,并转换为传入类型Bean
     *
     * @param sql          要执行的语句
     * @param requiredType 返回对象类型
     * @param args         参数
     * @return Bean数据对象
     * @throws DaoException
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    protected <T> T queryForBean(String sql, Class<T> requiredType,
                                 Object... args) throws DaoException {
        try {
            Map m = this.jdbcTemplate.queryForMap(sql, args);
            Class<?> cls = Class.forName(requiredType.getName());// 取得Class对象
            Object obj = cls.newInstance();
            T t = (T) obj;
            BeanUtils.copyProperties(t, m);
            return t;

        } catch (EmptyResultDataAccessException ede) {
            return null;
        } catch (Exception e) {
            throw new DaoException(e.getMessage(), e);
        }
    }
}
