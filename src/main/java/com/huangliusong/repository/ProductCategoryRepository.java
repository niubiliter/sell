package com.huangliusong.repository;

import com.huangliusong.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by huangliusong on 2017/8/2.
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer>{
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categotyTypeList);

}
