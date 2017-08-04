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
    private String product_Description;
    //商品的小图
    private String product_Icon;
    //商品的状态 正常为0 下架为1
    private Integer product_Status;
    //类目编号
    private Integer categoryType;

    @Override
    public String toString() {
        return "ProductInfo{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productStock=" + productStock +
                ", product_Description='" + product_Description + '\'' +
                ", product_Icon='" + product_Icon + '\'' +
                ", product_Status=" + product_Status +
                ", categoryType=" + categoryType +
                '}';
    }
}
