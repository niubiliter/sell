package com.huangliusong.dataobject;

import com.huangliusong.enums.OrderStatusEnum;
import com.huangliusong.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by huangliusong on 2017/8/9.
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {
    //订单id
    @Id
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
    private Integer orderStatus= OrderStatusEnum.NEW.getCode();
    //支付状态 默认未支付
    private Integer payStatus= PayStatusEnum.WAIT.getCode();

    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
}
