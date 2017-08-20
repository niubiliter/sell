package com.huangliusong.controller;

import com.huangliusong.VO.ResultV0;
import com.huangliusong.converter.OrderForm2OrderDTOConverter;
import com.huangliusong.dto.OrderDTO;
import com.huangliusong.enums.ResultEnum;
import com.huangliusong.exception.SellException;
import com.huangliusong.form.OrderForm;
import com.huangliusong.service.OrderService;
import com.huangliusong.utils.ResultVOUtil;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Action;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by huangliusong on 2017/8/20.
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {
    @Autowired
    private OrderService orderService;
    //创建订单
    @PostMapping("/create")
    public ResultV0<Map<String,String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【创建表单】参数不正确,orderForm={}",orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO= OrderForm2OrderDTOConverter.convert(orderForm);
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【创建订单】购物车不能为空");
            throw  new SellException(ResultEnum.CART_EMPTY);

        }
        System.err.println(orderDTO.getOrderDetailList().toString());
        OrderDTO createResult=orderService.create(orderDTO);
        Map<String,String> map=new HashMap<>();
        map.put("orderId",createResult.getOrderId());
        return ResultVOUtil.success(map);
    }
    //订单列表
    @GetMapping("/list")
    public  ResultV0<List<OrderDTO>> list(@RequestParam("openid")String openid,
                                          @RequestParam(value = "page",defaultValue = "0")Integer page,
                                          @RequestParam(value = "size",defaultValue = "10")Integer size){
        if(StringUtils.isEmpty(openid)){
            log.error("【查询订单列表】openid不能为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest request=new PageRequest(page,size);
        Page<OrderDTO> orderDTOPage=orderService.findList(openid,request);

        //
        return ResultVOUtil.success(orderDTOPage.getContent());
        }
    //订单详情

    //取消订单



}
