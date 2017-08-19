package com.huangliusong.dto;

import lombok.Data;

/**
 * Created by huangliusong on 2017/8/13.
 */@Data
public class CartDTO {
     //商品id
     private String  productId;
     //数量
     private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
