package com.huangliusong.service.impl;


import com.huangliusong.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by huangliusong on 2017/8/3.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {
    @Autowired
    private CategoryServiceImpl categoryService;
    @Test
    public void findOne() throws Exception {
        ProductCategory productCategory=categoryService.findOne(10);
        System.err.print(productCategory.toString());
        Assert.assertEquals(new Integer(1),productCategory.getCategoryId());
    }

    @Test
    public void findAll() throws Exception {
        List<ProductCategory> list=categoryService.findAll();
        System.err.println(list);
    }

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<ProductCategory> productCategories=categoryService.findByCategoryTypeIn(Arrays.asList(1,2,3));

    }

    @Test
    public void save() throws Exception {
        ProductCategory productCategory=new ProductCategory("xiaoxiao",5);
        categoryService.save(productCategory);
    }


}
