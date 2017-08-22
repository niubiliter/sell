package com.huangliusong.service;

import com.huangliusong.dto.OrderDTO;

/**
 * Created by huangliusong on 2017/8/20.
 */
public interface BuyerService {
    //查询一个订单
    OrderDTO findOrderOne(String openid,String orderId);
    //取消订单
    OrderDTO cancelOrder(String openid,String orderId);
}
