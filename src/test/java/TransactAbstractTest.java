/**
 * Copyright (c) www.bugull.com
 */

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * USED TO:Spring测试抽象类
 * Log File:
 * 测试基类,
 *
 * @Transactional 添加事务，所有改变数据库的改变均在方法结束后撤销
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package PACKAGE_NAME
 * @date 2017/3/15/015
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-init.xml",
        "classpath:spring-http.xml",
        "classpath:spring-redis.xml",
        "classpath:spring-jdbc.xml"
})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public abstract class TransactAbstractTest {

    @Autowired
    protected JdbcTemplate jdbcTemplate;
}
