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
    ARTICLE_SPRING_SECURITY(17, "SpringSecurity文章");


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