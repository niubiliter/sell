package com.huangliusong.service;

import com.huangliusong.dataobject.ProductInfo;
import com.huangliusong.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by huangliusong on 2017/8/4.
 */
public interface ProductService {
    //查询单个商品
    ProductInfo findOne(String productId);
    //查询所有的商品
    List<ProductInfo> findUpAll();
    //分页查询
    Page<ProductInfo> findAll(Pageable pageable);
    //添加
    ProductInfo save(ProductInfo productInfo);
    //加库存
    void increaseStock(List<CartDTO> cartDTOList);
    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);
}
