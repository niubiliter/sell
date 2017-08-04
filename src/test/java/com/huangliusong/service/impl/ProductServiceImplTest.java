package com.huangliusong.service.impl;


import com.huangliusong.dataobject.ProductInfo;
import com.huangliusong.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;


/**
 * Created by huangliusong on 2017/8/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
    @Autowired
    private ProductServiceImpl productService;
    @Test
    public void findOne() throws Exception {
        ProductInfo productInfo=productService.findOne("123456");
        //System.err.println(productInfo.toString());
        Assert.assertEquals("123456",productInfo.getProductId());
    }

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> list=productService.findUpAll();
        Assert.assertNotEquals(0,list.size());
    }

    @Test
    public void findAll() throws Exception {
        //第0页面 每一页10条
        PageRequest request=new PageRequest(0,10);
        Page<ProductInfo> page=productService.findAll(request);
        System.err.println(page.getTotalElements());
    }

    @Test
    public void save() throws Exception {
       ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId("1234567");
        productInfo.setProductName("泡泡袖");
        productInfo.setProductPrice(new BigDecimal(12));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("非常好吃泡泡袖");
        productInfo.setProductIcon("http://www.huanghuangliusong.top");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(2);
        productService.save(productInfo);

    }

}
