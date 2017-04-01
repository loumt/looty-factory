/**
 * Copyright (c) www.bugull.com
 */
package com.looty.base;

import com.looty.exception.DaoException;
import com.looty.pojo.system.QueryPageModel;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.util.ArrayList;
import java.util.List;
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

    /******************************************Insert**************************************/
    /**
     * 执行单条insert 语句 返回主键id
     *
     * @param sql    要执行的sql语句
     * @param object 语句中的参数
     * @return 执行语句影响数据的条数
     */
    protected long saveBean(String sql, Object object) {
        try {
            SqlParameterSource ps = new BeanPropertySqlParameterSource(object);
            KeyHolder keyHolder = new GeneratedKeyHolder();
            this.npjt.update(sql, ps, keyHolder);
            long id = keyHolder.getKey().longValue();
            return id;
        } catch (Exception e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    /**
     * 执行单条insert 语句 返回主键id
     *
     * @param sql
     * @param object
     * @return
     */
    protected long saveList(String sql, Object object) {
        try {
            SqlParameterSource ps = new BeanPropertySqlParameterSource(object);
            KeyHolder keyHolder = new GeneratedKeyHolder();
            this.npjt.update(sql, ps, keyHolder);
            long id = keyHolder.getKey().longValue();
            return id;
        } catch (Exception e) {
            throw new DaoException(e.getMessage(), e);
        }
    }



    /******************************************Delete**************************************/

    /**
     * 执行一条sql语句
     *
     * @param sql
     * @throws DaoException
     */
    protected void delete(String sql) throws DaoException {
        try {
            this.jdbcTemplate.execute(sql);
        } catch (DataAccessException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    /**
     * 执行一条sql语句
     *
     * @param sql
     * @throws DaoException
     */
    protected int delete(String sql, Object... args) throws DaoException {
        try {
            return this.jdbcTemplate.update(sql, args);
        } catch (DataAccessException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    /******************************************Update**************************************/

    /**
     * 执行更新操作
     *
     * @param sql
     * @throws DaoException
     */
    protected int update(String sql) throws DaoException {
        try {
            return this.jdbcTemplate.update(sql);
        } catch (DataAccessException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    /**
     * 执行更新操作
     *
     * @param sql
     * @param args 参数s
     * @return
     * @throws DaoException
     */
    protected int update(String sql, Object... args) throws DaoException {
        try {
            return this.jdbcTemplate.update(sql, args);
        } catch (DataAccessException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }


    /******************************************Search**************************************/

    /**
     * 执行select语句，获取一个整形数字
     *
     * @param sql 要执行的语句
     * @return 数字
     */
    protected int queryForInteger(String sql) throws DaoException {
        try {
            return this.jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (DataAccessException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    /**
     * 执行select语句，获取一个整形数字
     *
     * @param sql 要执行的语句
     * @return 数字
     */
    protected int queryForInteger(String sql, Object... args) throws DaoException {
        try {
            return this.jdbcTemplate.queryForObject(sql, Integer.class, args);
        } catch (DataAccessException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    /**
     * 获取数据总数
     *
     * @param sql
     * @return
     * @throws DaoException
     */
    protected Long totalCount(String sql) throws DaoException {
        try {
            return this.jdbcTemplate.queryForObject(sql, Long.class);
        } catch (DataAccessException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    /**
     * 获取数据总数
     *
     * @param sql
     * @param args
     * @return
     * @throws DaoException
     */
    protected Long totalCount(String sql, Object... args) throws DaoException {
        try {
            return this.jdbcTemplate.queryForObject(sql, Long.class, args);
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

    /**
     * 执行select语句，获取列表数据,并指定列表中Bean的类型
     *
     * @param sql          要执行的语句
     * @param requiredType 对象类型
     * @return List<Bean>数据列表
     */
    @SuppressWarnings("unchecked")
    protected <T> List<T> queryForBeanList(String sql, Class<T> requiredType)
            throws DaoException {
        try {
            List<T> resultList = new ArrayList<T>();
            Class<?> cls = Class.forName(requiredType.getName());// 取得Class对象

            List<Map<String, Object>> list = this.jdbcTemplate.queryForList(sql);
            for (Map<String, Object> m : list) {
                T t = (T) cls.newInstance();
                BeanUtils.copyProperties(t, m);
                resultList.add(t);
            }
            return resultList;
        } catch (Exception e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    /**
     * 执行select语句，获取列表数据
     *
     * @param sql         要执行的语句
     * @param requireType 对象类型
     * @param args        语句中的参数
     * @return 数据列表
     */
    @SuppressWarnings("unchecked")
    protected <T> List<T> queryForBeanList(String sql, Class<T> requireType, Object... args) throws DaoException {
        try {
            List<T> resultList = new ArrayList<T>();
            Class<?> cls = Class.forName(requireType.getName());

            List<Map<String, Object>> list = this.jdbcTemplate.queryForList(sql, args);

            for (Map<String, Object> m : list) {
                T t = (T) cls.newInstance();
                BeanUtils.copyProperties(t, m);
                resultList.add(t);
            }
            return resultList;
        } catch (Exception e) {
            throw new DaoException(e.getMessage(), e);
        }
    }


    /**
     * 执行Select语句,返回map结果集
     *
     * @param sql
     * @return
     * @throws DaoException
     */
    protected Map<String, Object> queryForMap(String sql) throws DaoException {
        try {
            return this.jdbcTemplate.queryForMap(sql);
        } catch (DataAccessException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    /**
     * 执行Select语句,返回map结果集
     *
     * @param sql
     * @param args
     * @return
     * @throws DaoException
     */
    protected Map<String, Object> queryForMap(String sql, Object... args) throws DaoException {
        try {
            return this.jdbcTemplate.queryForMap(sql, args);
        } catch (DataAccessException e) {
            throw new DaoException(e.getMessage(), e);
        }
    }


    /**
     * 执行select语句，获取列表数据,并指定列表中Bean的类型
     *
     * @param sql          要执行的语句
     * @param requiredType 对象类型
     * @return List<Bean>数据列表
     */
    @SuppressWarnings("unchecked")
    protected <T> List<T> queryForPageBeanList(String sql, Class<T> requiredType)
            throws DaoException {
        try {
            List<T> resultList = new ArrayList<T>();
            Class<?> cls = Class.forName(requiredType.getName());// 取得Class对象
            StringBuffer sb = new StringBuffer(sql);
            Integer pageNo = QueryPageModel.getPageNo() == null ? 0 : QueryPageModel.getPageNo();
            Integer pageSize = QueryPageModel.getPageSize() == null ? 10 : QueryPageModel.getPageSize();
            sb.append(getPageSql(pageNo, pageSize));
            List<Map<String, Object>> list = this.jdbcTemplate.queryForList(sb.toString());
            for (Map<String, Object> m : list) {
                T t = (T) cls.newInstance();
                BeanUtils.copyProperties(t, m);
                resultList.add(t);
            }
            return resultList;
        } catch (Exception e) {
            throw new DaoException(e.getMessage(), e);
        }
    }


    /**
     * 执行select语句，获取列表数据,并指定列表中Bean的类型
     *
     * @param sql
     * @param requiredType
     * @param args
     * @param <T>
     * @return
     * @throws DaoException
     */
    protected <T> List<T> queryForPageBeanList(String sql, Class<T> requiredType, Object... args) throws DaoException {
        try {
            List<T> list = new ArrayList<T>();
            Class<?> cls = Class.forName(requiredType.getName());// 取得Class对象
            StringBuffer sb = new StringBuffer(sql);
            Integer pageNo = QueryPageModel.getPageNo() == null ? 0 : QueryPageModel.getPageNo();
            Integer pageSize = QueryPageModel.getPageSize() == null ? 10 : QueryPageModel.getPageSize();
            sb.append(getPageSql(pageNo, pageSize));
            List<Map<String, Object>> maps = this.jdbcTemplate.queryForList(sb.toString(), args);
            for (Map<String, Object> m : maps) {
                T t = (T) cls.newInstance();
                BeanUtils.copyProperties(t, m);
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            throw new DaoException(e.getMessage(), e);
        }
    }

    /**
     * 拼凑Page sql
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    private String getPageSql(Integer pageNo, Integer pageSize) {
        return " limit " + pageNo + "," + pageSize;
    }

}
