package com.ustcck.service;

import com.ustcck.dataobject.ProductCategory;

import java.util.List;
import java.util.Optional;

/**
 * Created by CaoKai on 2018/3/13 20:51.
 * Email:caokai@yijiahe.com
 */
public interface CategoryService {
    Optional<ProductCategory> findById(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
