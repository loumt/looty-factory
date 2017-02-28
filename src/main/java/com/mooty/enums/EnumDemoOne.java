/**
 * Copyright (c) www.bugull.com
 */
package com.mooty.enums;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project looty-factory
 * @package com.mooty.enums
 * @date 2017/2/27/027
 */
public class EnumDemoOne {

    /**
     * 定义一个内部枚举类
     */
    private enum InnerEnum {
        yellow, red, black, white, grey
    }

    public static void main(String[] args) {
        InnerEnum innerEnum = InnerEnum.black;

        switch (innerEnum) {
            case red:
                System.out.println("InnerEnum.red!");
                break;
            case yellow:
                System.out.println("InnerEnum.yellow!");
                break;
            case black:
                System.out.println("InnerEnum.black!");
                break;
            case white:
                System.out.println("InnerEnum.white!");
                break;
            case grey:
                System.out.println("InnerEnum.grey!");
                break;
            default:
                System.out.println("Nothing!");
                break;
        }
        System.out.println("======================");


        System.out.println("Enum length:" + InnerEnum.values().length);
        System.out.println("======================");

        System.out.println("InnerEnum cmparedTo:" + InnerEnum.black.compareTo(InnerEnum.black));
        System.out.println("======================");
        System.out.println("InnerEnum.ordinal:" + InnerEnum.black.ordinal());
        System.out.println("======================");
        System.out.println("InnerEnum valueOf:" + InnerEnum.valueOf("red").compareTo(InnerEnum.red));
    }
}
