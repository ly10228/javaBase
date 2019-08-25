package com.ly.senior.datastructure.stack.enm;

/**
 * @author luoyong
 * @Description: 运算符优先级的定义
 * @create 2019-08-25 15:47
 * @last modify by [LuoYong 2019-08-25 15:47]
 **/
public enum OperatorPriorityEnum {

    ONE("*/", 1),
    ZERO("+-", 0),
    ALL("+-*/",null);

    private String code;

    private Integer priority;


    OperatorPriorityEnum(String code, Integer priority) {
        this.code = code;
        this.priority = priority;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
