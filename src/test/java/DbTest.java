/**
 * Copyright (c) www.bugull.com
 */

import com.looty.service.IWeiBoResourceService;
import com.looty.service.IManageLogService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
public class DbTest extends AbstractTest {

    @Autowired
    private IManageLogService appLogService;
    @Autowired
    private IWeiBoResourceService linkDataTypeService;

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
