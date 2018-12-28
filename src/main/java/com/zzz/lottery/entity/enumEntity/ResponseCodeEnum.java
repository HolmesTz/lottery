package com.zzz.lottery.entity.enumEntity;

public enum ResponseCodeEnum {

    SUCCESS("200", "请求成功"),
    FAILED("500", "请求失败");

    private String code;

    private String message;

    ResponseCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode(){
        return code;
    }

    public String getMessage(){
        return message;
    }

}
