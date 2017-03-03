/**
 * Copyright (c) www.bugull.com
 */
package com.looty.proxy;

/**
 * USED TO:房东的租房与收租
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project looty-factory
 * @package com.mooty
 * @date 2017/2/17/017
 */
public class HouseOwner implements RentHouse {
    public void rent() {
        System.out.println("I'm rent my House");
    }

    public void charge(String str) {
        System.out.println("You get :" + str + " RMB HouseCharge");
    }
}
