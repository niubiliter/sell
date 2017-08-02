package com.huangliusong.service;

import com.huangliusong.dataobject.ProductCategory;

import java.util.List;

/**
 * Created by huangliusong on 2017/8/3.
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);


}
