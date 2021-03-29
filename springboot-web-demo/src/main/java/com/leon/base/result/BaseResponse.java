package com.leon.base.result;

/**
 * 响应数据基类
 *
 * @author minglei.chen
 * @date 10:38 AM 3/16/21
 **/
public class BaseResponse {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 响应消息
     */
    private String msg;

    protected BaseResponse() {}

    protected BaseResponse(CodeEnum code) {
        this.code = code.getCode();
        this.msg = code.getMsg();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
