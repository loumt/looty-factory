/**
 * Copyright (c) www.bugull.com
 */
package json;

import com.alibaba.fastjson.JSONObject;
import com.looty.utils.JsonUtil;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package json
 * @date 2017/4/10/010
 */
public class JsonTest {

    @Test
    public void tset1() {
        try {
            User bean = new User();
            bean.setUsername("username");
            bean.setPassword("password");
            bean.setCode(1235);
            bean.setNickName("NickName");
            bean.setRealName("RealName");

            String jsonString = JSONObject.toJSONString(bean);
            System.out.println("toJSONString:" + jsonString);

            JSONObject jsonObject = JSONObject.parseObject(jsonString);
            System.out.println("parseObject getUsername():" + jsonObject.get("username"));

            User user = JSONObject.parseObject(jsonString, User.class);
            System.out.println("parseObject :" + ToStringBuilder.reflectionToString(user));

            System.out.println("--------------");
            System.out.println(JsonUtil.getValue(jsonString, "code"));

            System.out.println("---------------");
            System.out.println(ToStringBuilder.reflectionToString(JsonUtil.parseJsonString(jsonString, User.class)));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void tset2() {

        User bean1 = new User();
        bean1.setUsername("username1");
        bean1.setPassword("password1");
        bean1.setCode(1);
        bean1.setNickName("NickName1");
        bean1.setRealName("RealName1");

        User bean2 = new User();
        bean2.setUsername("username2");
        bean2.setPassword("password2");
        bean2.setCode(2);
        bean2.setNickName("NickName2");
        bean2.setRealName("RealName2");

        User bean3 = new User();
        bean3.setUsername("username3");
        bean3.setPassword("password3");
        bean3.setCode(3);
        bean3.setNickName("NickName3");
        bean3.setRealName("RealName3");

        List<User> users = new ArrayList<>();
        users.add(bean1);
        users.add(bean2);
        users.add(bean3);

        Group group = new Group();
        group.setUsers(users);
        group.setGroupCode(10);
        group.setGroupId(1500L);
        group.setGroupName("Group_Name");

        String jsonString = JSONObject.toJSONString(group);
        System.out.println("toJSONString:" + jsonString);

        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        System.out.println("parseObject getUsers():" + jsonObject.get("users"));

        Group toGroup = JSONObject.parseObject(jsonString, Group.class);
        System.out.println("parseObject :" + ToStringBuilder.reflectionToString(toGroup));


    }

    @Test
    public void tset3() {

    }
}
