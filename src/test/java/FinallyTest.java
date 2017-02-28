/**
 * Copyright (c) www.bugull.com
 */

import com.looty.enums.ResultMsgEnum;
import com.looty.pojo.ResultMsg;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project looty-factory
 * @package PACKAGE_NAME
 * @date 2017/2/12/012
 */
public class FinallyTest {

    /**
     * try {}里有一个return语句,那么紧跟在这个try后的finally {}里的
     * code会不会被执行,什么时候被执行,在return前还是后?
     *
     * @return
     */
    public String Test1() {
        String str = "真的在";
        try {
            str = str + "return前输出？";
            return str;
        } finally {
            str = "finally在return前输出";
            System.out.println(str);
        }
    }

    public static void main(String[] args) {

        List<Long> delFileId = new ArrayList<Long>() {
            {
                //[422, 423, 424, 421, 207, 206, 204, 425, 205, 203, 197]
                add(422L);
                add(423L);
                add(424L);
                add(207L);
                add(206L);
                add(204L);
                add(425L);
                add(205L);
                add(203L);
                add(197L);
            }
        };
        List<Long> workFlow = new ArrayList<Long>() {
            {
                //[398, 422, 412, 415, 381]
                add(398L);
                add(422L);
                add(412L);
                add(415L);
                add(381L);
            }
        };

        System.out.println(CollectionUtils.containsAny(workFlow, delFileId));

    }

}
