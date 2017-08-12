package com.huangliusong.repository;

import com.huangliusong.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;


/**
 * Created by huangliusong on 2017/8/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {
    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void findByOrderId() throws Exception {
    }

    @Test
    public void testSave(){
        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setDetailId("1234567890");
        orderDetail.setOrderId("1111111");
        orderDetail.setProductIcon("http://cion.com1");
        orderDetail.setProductId("11112221");
        orderDetail.setProductName("皮带粥1");
        orderDetail.setProductQuantity(2);
        orderDetail.setProductPrice(new BigDecimal(12));
        OrderDetail result=repository.save(orderDetail);
        Assert.assertNotNull(result);
    }
}
