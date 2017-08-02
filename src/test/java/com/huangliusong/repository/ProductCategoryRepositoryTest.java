package com.huangliusong.repository;

import com.huangliusong.dataobject.ProductCategory;
import org.hibernate.annotations.DynamicUpdate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;


/**
 * Created by huangliusong on 2017/8/2.
 * DynamicUpdate动态更新
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    @Test
    public void findOneTest(){
        ProductCategory productCategory=productCategoryRepository.findOne(1);
        System.err.println(productCategory);
    }

    @Test
    public void saveTest(){
        ProductCategory productCategory=new ProductCategory();
        productCategory.setCategoryName("男生最爱");
        productCategory.setCategoryType(3);
        productCategoryRepository.save(productCategory);
    }

    @Test
    public void updateTest(){
        ProductCategory productCategory=productCategoryRepository.findOne(2);
        productCategory.setCategoryType(58);
        productCategoryRepository.save(productCategory);
    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list= Arrays.asList(2,3,4);
        List<ProductCategory> result=productCategoryRepository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }
}