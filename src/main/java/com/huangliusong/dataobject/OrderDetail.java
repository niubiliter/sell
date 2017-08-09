package com.huangliusong.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by huangliusong on 2017/8/9.
 */
@Entity
@Data
public class OrderDetail {
    @Id
    private String detailId;
    //订单id
    private String orderId;
    //商品的id
    private String productId;
    //商品的名字
    private String productName;
    //商品的价格
    private BigDecimal productPrice;
    //商品的数量
    private Integer productQuantity;
    //商品的图标
    private String productIcon;
}
