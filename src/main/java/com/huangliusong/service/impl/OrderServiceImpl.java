package com.huangliusong.service.impl;

import com.huangliusong.dataobject.OrderDetail;
import com.huangliusong.dataobject.ProductInfo;
import com.huangliusong.dto.OrderDTO;
import com.huangliusong.enums.ResultEnum;
import com.huangliusong.exception.SellException;
import com.huangliusong.service.OrderService;
import com.huangliusong.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by huangliusong on 2017/8/13.
 */
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ProductService productService;
    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        //1.需要查询商品的质量 拿到商品的list
        for(OrderDetail orderDetail:orderDTO.getOrderDetailList()){
           ProductInfo productInfo=productService.findOne(orderDetail.getProductId());
           if(productInfo==null){
               throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
           }
        }
        //2.计算总价

        //3.写入订单数据库

        //4.扣库存

        return null;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
