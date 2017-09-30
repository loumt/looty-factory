package com.looty.enums;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.enums
 * @date 2017/3/30/030
 */
public enum CategoryEnum {
    DEFAULT_CATEGORY(0, "默认类型"),
    /**
     * 技术文章类
     */
    ARTICLE_JAVA(11, "Java文章"),
    ARTICLE_JVM(12, "Jvm文章"),
    ARTICLE_BOOTSTRAP(13, "Bootstrap文章"),
    ARTICLE_SPRING(14, "Spring文章"),
    ARTICLE_SPRING_MVC(15, "SpringMvc文章"),
    ARTICLE_SPRING_AOP(16, "SpringAop文章"),
    ARTICLE_SPRING_SECURITY(17, "SpringSecurity文章"),
    ARTICLE_SPRING_BOOT(18, "SpringBoot文章"),
    ARTICLE_SHIRO(19, "Shiro文章"),
    ARTICLE_NODE(20, "NodeJs"),

    /**
     * 功能性
     */
    FUNCTION_DECODE(50, "解码工具"),
    FUNCTION_FORMAT(51, "格式化工具"),

    /**
     * 专题类
     */
    SPECIAL_SPRING(80, "Spring专题"),
    SPECIAL_HIBERNATE(81, "Hibernate专题"),
    SPECIAL_STRUT2(82, "STRUT2专题"),
    SPECIAL_MYBATIS(83, "MyBatis专题"),
    SPECIAL_CAS(84, "Cas-Server专题"),



    /**
     * 中间件
     */
    MIDDLE_WARE_REDIS(100, "Redis"),
    MIDDLE_WARE_RABBIT_MQ(101, "RabbitMQ"),

    /**
     * JS插件
     */
    JS_ECHARTS(150, "eCharts.js"),
    JS_HIGHCHARTS(151, "HighCharts.js"),
    JS_JQUERY(151, "Jquery.js"),

    /**
     * 服务器方面
     */
    LINUX(200,"Linux"),


    /**
     * 开源项目
     */
    OPER_SOURCE(250,"开源项目"),


    /**
     * 设计模式
     */
    DESIGN_PATTERN(300,"设计模式")

    ;

    private int category;
    private String des;

    CategoryEnum(int category, String des) {
        this.category = category;
        this.des = des;
    }

    public int getCategory() {
        return this.category;
    }

    public String getDes() {
        return des;
    }

    public String getDes(int category) {
        for (CategoryEnum categoryEnum : CategoryEnum.values()) {
            if (category == categoryEnum.category) {
                return categoryEnum.des;
            }
        }
        return "";
    }


}
