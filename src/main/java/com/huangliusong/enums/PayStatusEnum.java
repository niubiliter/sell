package com.huangliusong.enums;

import lombok.Data;
import lombok.Getter;

/**
 * Created by huangliusong on 2017/8/11.
 */
@Getter
public enum PayStatusEnum {
    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功")
    ;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;
    private String message;

}
