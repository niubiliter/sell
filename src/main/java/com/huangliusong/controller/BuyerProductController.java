package com.huangliusong.controller;

import com.huangliusong.VO.ProductInfoVO;
import com.huangliusong.VO.ProductVO;
import com.huangliusong.VO.ResultV0;
import com.huangliusong.dataobject.ProductInfo;
import com.huangliusong.service.CategoryService;
import com.huangliusong.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 * Created by huangliusong on 2017/8/5.
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductService productService;
    private CategoryService categoryService;
    @GetMapping("/list")
    public ResultV0 list(){
        //1.查询所有上架的商品
        List<ProductInfo> productInfoList=productService.findUpAll();
        //2.查询类目 一次性查询
        List<Integer> categoryTypeList=new ArrayList<>();
        //传统的方法
       /* for(ProductInfo productInfo:productInfoList){
            categoryTypeList.add(productInfo.getCategoryType());
        }*/
        //精简的做法(java8新特性，lambda)
        productInfoList.stream().map(e->e.getCategoryType()).collect(Collectors.toList());
        categoryService.findByCategoryTypeIn(categoryTypeList);
        //3.数据拼装


        ResultV0 resultV0=new ResultV0();
        ProductVO productVO=new ProductVO();
        ProductInfoVO productInfoVO=new ProductInfoVO();

        productVO.setProductInfoVOList(Arrays.asList(productInfoVO));
        resultV0.setData(Arrays.asList(productVO));
        resultV0.setCode(0);
        resultV0.setMsg("成功");


        resultV0.setData(productVO);
        return resultV0;
    }

}
