package com.huangliusong.dto;

import com.huangliusong.dataobject.OrderDetail;
import com.huangliusong.enums.OrderStatusEnum;
import com.huangliusong.enums.PayStatusEnum;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by huangliusong on 2017/8/13.
 */
@Data
public class OrderDTO {
    //订单id
    private String orderId;
    //买家名字
    private String buyerName;
    //买家手机号
    private String buyerPhone;
    //'买家的地址
    private String buyerAddress;
    //openid
    private String buyerOpenid;
    //订单总金额
    private BigDecimal orderAmount;
    //订单状态
    private Integer orderStatus;
    //支付状态 默认未支付
    private Integer payStatus;

    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    //@Transient
    private List<OrderDetail> orderDetailList;

}
