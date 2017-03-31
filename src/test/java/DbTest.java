/**
 * Copyright (c) www.bugull.com
 */

import com.looty.enums.ResourceEnum;
import com.looty.pojo.LinkTypeData;
import com.looty.service.ILinkDataTypeService;
import com.looty.service.IManageLogService;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package PACKAGE_NAME
 * @date 2017/3/13/013
 */
public class DbTest extends AbstractTest {

    @Autowired
    private IManageLogService appLogService;
    @Autowired
    private ILinkDataTypeService linkDataTypeService;

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
    public void mapTest() {
        Arrays.asList("a", "b", "d").forEach(e -> System.out.println(e));
    }


//    @Test
//    public void setLinkType(){
//        try {
//            JdbcTemplate jdbcTemplate = super.jdbcTemplate;
//            List<LinkTypeData> datas = new ArrayList<LinkTypeData>();
//            List<Map<String, Object>> maps = jdbcTemplate.queryForList("SELECT * FROM link_data_type");
//            for (Map<String, Object> m : maps) {
//                LinkTypeData t = new LinkTypeData();
//                BeanUtils.copyProperties(t, m);
//                datas.add(t);
//            }
//            for (LinkTypeData data : datas) {
//                linkDataTypeService.updateType(data.getId(),ResourceEnum.S_WEI_BO_HOT);
//            }
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//
//    }


}
