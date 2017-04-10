/**
 * Copyright (c) www.bugull.com
 */

import com.looty.enums.ResourceEnum;
import com.looty.pojo.User;
import com.looty.pojo.WeiBoResource;
import com.looty.service.IManageLogService;
import com.looty.service.IUserService;
import com.looty.service.IWeiBoResourceService;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package PACKAGE_NAME
 * @date 2017/3/13/013
 */
public class DbTest extends NoTransactAbstractTest {

    @Autowired
    private IManageLogService manageLogService;
    @Autowired
    private IWeiBoResourceService weiBoResourceService;


    @Test
    public void mapList() {
        Map<String, String> hashMap = new HashMap<String, String>() {
            {
                put("name", "哈哈");
                put("name1", "哈哈1");
                put("name2", "哈哈2");
                put("name3", "哈哈3");
                put("name4", "哈哈4");
            }
        };

        Iterator<String> iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key + ":" + hashMap.get(key));
        }
    }


    @Test
    public void setLinkType() {
        try {
            JdbcTemplate jdbcTemplate = super.jdbcTemplate;
            List<WeiBoResource> datas = new ArrayList<WeiBoResource>();
            List<Map<String, Object>> maps = jdbcTemplate.queryForList("SELECT * FROM wei_bo_resource");
            for (Map<String, Object> m : maps) {
                WeiBoResource t = new WeiBoResource();
                BeanUtils.copyProperties(t, m);
                datas.add(t);
            }
            for (WeiBoResource data : datas) {
                weiBoResourceService.updateType(data.getId(), ResourceEnum.S_WEI_BO_HOT);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Autowired
    private IUserService userService;

    @Test
    public void test7() {
        User user = new User();
        user.setUserId("13134");
        user.setUsername("username");
        user.setRealName("H");
        user.setLastOperationTime(new Date());
        user.setRoleCode("G");
        user.setCreateTime(new Date());
        user.setPassword("password");
        user.setAuthTop(22);
        userService.register(user);
    }

}
