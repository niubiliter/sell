package com.huangliusong.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huangliusong.dataobject.OrderDetail;
import com.huangliusong.dto.OrderDTO;
import com.huangliusong.enums.ResultEnum;
import com.huangliusong.exception.SellException;
import com.huangliusong.form.OrderForm;
import lombok.extern.slf4j.Slf4j;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangliusong on 2017/8/20.
 */
@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
            String i=orderDetailList.get(0).getProductId();
            System.err.println(i);
        } catch (Exception e) {
            log.error("【对象转换】错误, string={}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
