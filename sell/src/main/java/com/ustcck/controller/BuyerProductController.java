package com.ustcck.controller;

import com.ustcck.common.ProductInfoViewObject;
import com.ustcck.common.ProductViewObject;
import com.ustcck.common.ResultViewObject;
import com.ustcck.entity.ProductCategory;
import com.ustcck.entity.ProductInfo;
import com.ustcck.service.CategoryService;
import com.ustcck.service.ProductService;
import com.ustcck.utils.ResultViewObjectUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by CaoKai on 2018/3/14 10:09.
 * Email:caokai@yijiahe.com
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultViewObject list() {
        //1. 查询所有的上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2. 查询类目(一次性查询)
//        List<Integer> categoryTypeList = new ArrayList<>();
        //传统方法
//        for (ProductInfo productInfo : productInfoList) {
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        //精简方法(java8, lambda)
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //3. 数据拼装
        List<ProductViewObject> ProductViewObjectList = new ArrayList<>();
        for (ProductCategory productCategory: productCategoryList) {
            ProductViewObject ProductViewObject = new ProductViewObject();
            ProductViewObject.setCategoryType(productCategory.getCategoryType());
            ProductViewObject.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoViewObject> ProductInfoViewObjectList = new ArrayList<>();
            for (ProductInfo productInfo: productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoViewObject ProductInfoViewObject = new ProductInfoViewObject();
                    BeanUtils.copyProperties(productInfo, ProductInfoViewObject);
                    ProductInfoViewObjectList.add(ProductInfoViewObject);
                }
            }
            ProductViewObject.setProductInfoViewObjectList(ProductInfoViewObjectList);
            ProductViewObjectList.add(ProductViewObject);
        }

        return ResultViewObjectUtil.success(ProductViewObjectList);
    }
}