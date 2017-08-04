package com.huangliusong.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * 商品
 * Created by huangliusong on 2017/8/4.
 */
@Entity
@Data
public class ProductInfo {
    //商品的id
    @Id
    private String productId;
    //商品d名字
    private String productName;
    //商品的价格单价
    private BigDecimal productPrice;
    //库存
    private Integer productStock;
    //商品的描述
    private String productDescription;
    //商品的小图
    private String productIcon;
    //商品的状态 正常为0 下架为1
    private Integer productStatus;
    //类目标号
    private Integer categoryType;

}
