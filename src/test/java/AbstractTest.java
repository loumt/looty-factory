/**
 * Copyright (c) www.bugull.com
 */

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * USED TO:Spring测试抽象类
 * Log File:
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
public abstract class AbstractTest {

}
