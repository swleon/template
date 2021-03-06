package com.leon.common.execption;

/**
 * @author minglei.chen
 * @description //自定义业务异常类
 * @date 3:45 PM 3/15/21
 **/
public class CustomerException extends RuntimeException {

    //异常对应的返回码
    private String retCd ;
    //异常对应的描述信息
    private String msgDes;

    public CustomerException() {
        super();
    }

    public CustomerException(String message) {
        super(message);
        msgDes = message;
    }

    public CustomerException(String retCd, String msgDes) {
        super();
        this.retCd = retCd;
        this.msgDes = msgDes;
    }

    public String getRetCd() {
        return retCd;
    }

    public String getMsgDes() {
        return msgDes;
    }

}
