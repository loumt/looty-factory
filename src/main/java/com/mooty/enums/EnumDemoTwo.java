/**
 * Copyright (c) www.bugull.com
 */
package com.mooty.enums;

import java.util.EnumMap;
import java.util.EnumSet;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project looty-factory
 * @package com.mooty.enums
 * @date 2017/2/27/027
 */
public class EnumDemoTwo {


    public enum InnerEnum {
        RED("红色"), GREEN("绿色"), YELLOW("黄色");

        private String color;

        InnerEnum(String color) {
            this.color = color;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "InnerEnum{" +
                    "color='" + color + '\'' +
                    '}';
        }
    }


    public static void main(String[] args) {
        EnumMap<InnerEnum, String> enumMap = new EnumMap<InnerEnum, String>(InnerEnum.class);
        enumMap.put(InnerEnum.GREEN, "LV");
        enumMap.put(InnerEnum.RED, "HONG");
        enumMap.put(InnerEnum.YELLOW, "YELLOW");

        System.out.println(enumMap);
    }
}
