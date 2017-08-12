package com.huangliusong.repository;

import com.huangliusong.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by huangliusong on 2017/8/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositotyTest {
    @Autowired
    private OrderMasterRepositoty repositoty;
    private final String OPENID="110110";
    @Test
    public void findByOrderId() throws Exception {
    }

    @Test
    public void saveTest(){
        OrderMaster orderMaster=new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("师兄");
        orderMaster.setBuyerPhone("11111111111");
        orderMaster.setBuyerAddress("马村");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(12.11));
        OrderMaster result=repositoty.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenid(){
        //传入一个分页的参数 从第0页开始的  描述调查的页有多少项
        /**
         * 解答疑惑：为什么在参数的时候是Pageable而真正的传入的时候是request
         * 因为这是一个抽象类 这个抽象类实现了一个Pageable接口 并不是一个具体的类
         */
        PageRequest request=new PageRequest(0 ,3);
        //执行结果最终返回的是一个Page对象
        Page<OrderMaster> result=repositoty.findByBuyerOpenid(OPENID,request);
        //总的元素的个数
        System.err.println(result.getTotalElements());
        //总的页数
        System.err.println(result.getTotalPages());
        Assert.assertNotEquals(0,result.getContent().size());
        System.err.println(result.getContent().size());
    }

}
