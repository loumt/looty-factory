package com.looty.enums;

/**
 * USED TO:资源类型
 * 用于爬虫资源的区分
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.enums
 * @date 2017/3/29/029
 */
public enum ResourceEnum {

    //微博热搜
    S_WEI_BO_HOT(10);

    private int type;

    ResourceEnum(int type) {
        this.type = type;
    }

    public int getType() {
        return this.type;
    }

}
