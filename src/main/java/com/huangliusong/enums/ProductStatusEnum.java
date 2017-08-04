package com.huangliusong.enums;

import lombok.Getter;

/**
 * 商品状态
 * Created by huangliusong on 2017/8/5.
 */
@Getter
public enum ProductStatusEnum {
    UP(0,"上架"),
    DOWN(1,"下架")
    ;
    private Integer code;
    private String message;
    ProductStatusEnum(Integer code,String message) {
        this.code = code;
    }

}
