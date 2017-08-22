package com.huangliusong.service.impl;

import com.huangliusong.dto.OrderDTO;
import com.huangliusong.enums.ResultEnum;
import com.huangliusong.exception.SellException;
import com.huangliusong.service.BuyerService;
import com.huangliusong.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by huangliusong on 2017/8/20.
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService{
    @Autowired
    private OrderService orderService;
    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        OrderDTO orderDTO=checkOrderOwner(openid,orderId);
        return orderDTO;
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO=checkOrderOwner(openid,orderId);
        if(orderDTO==null){
            log.error("【取消订单】查询订单为空，orderId",orderId);
            throw new SellException(ResultEnum.ORDERDETAIL_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }
    private OrderDTO checkOrderOwner(String openid, String orderId){
        OrderDTO orderDTO=orderService.findOne(orderId);
        if(orderDTO==null){
            return null;
        }
        //判断是否是自己的订单
        if(!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)){
            log.error("【查询订单】订单的openid不一致，openid={},orderDTO={}",openid,orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
