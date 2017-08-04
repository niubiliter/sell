package com.huangliusong.repository;

import com.huangliusong.dataobject.ProductInfo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;


/**
 * Created by huangliusong on 2017/8/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository repository;
    @Test
    public void saveTest(){
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("茶叶蛋");
        productInfo.setProductPrice(new BigDecimal(12));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("非常好吃");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);
        repository.save(productInfo);
    }

    @Test
    public void findByProductStatus() throws Exception{
        List<ProductInfo> list=repository.findByProductStatus(0);
        Assert.assertNotEquals(0, list.size());
    }

    @Test
    public void findOneTest(){
        ProductInfo productInfo=repository.findOne("123456");
        System.err.print(productInfo.toString());
    }
}
