package com.leon.base.result;

/**
 * 响应数据体
 *
 * @author minglei.chen
 * @date 10:40 AM 3/16/21
 **/
public class ResponseData<T> extends BaseResponse {

    /**
     * 数据
     */
    private T data;

    private ResponseData(CodeEnum code) {
        super(code);
    }

    private ResponseData(CodeEnum code, T data) {
        super(code);
        this.data = data;
    }

    public static ResponseData ok() {
        return new ResponseData(CodeEnum.SUCCESS);
    }

    public static ResponseData fail() {
        return new ResponseData(CodeEnum.FAIL);
    }

    public static  <T> ResponseData<T> fail(T data) {
        return new ResponseData(CodeEnum.FAIL,data);
    }

    /**
     * 对外开放基础响应体已供调用，可用于增、删、改接口操作
     */
    public static BaseResponse out(CodeEnum code) {
        return new BaseResponse(code);
    }

    /**
     * 对外开放数据响应体已供调用，可用于查询数据实用，引用了范型设计，支持各种数据类型
     */
    public static <T> ResponseData<T> out(CodeEnum code, T data) {
        return new ResponseData<>(code, data);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
