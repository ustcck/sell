package com.ustcck.repository;

import com.ustcck.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by CaoKai on 2018/3/13 16:38.
 * Email:caokai@yijiahe.com
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    //根据categoryType查询
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
