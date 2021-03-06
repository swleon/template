package com.leon.base.result;

/**
 * 响应状态码枚举
 *
 * @author minglei.chen
 * @date 10:35 AM 3/16/21
 **/
public enum CodeEnum {

    SUCCESS(0, "成功"),
    FAIL(1, "失败"),
            ;

    private final Integer code;

    private final String msg;

    CodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
