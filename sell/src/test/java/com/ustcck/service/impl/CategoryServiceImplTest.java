package com.ustcck.service.impl;

import com.ustcck.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by CaoKai on 2018/3/13 21:02.
 * Email:caokai@yijiahe.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl service;

    @Test
    public void findById() throws Exception {
        Optional<ProductCategory> categoryOptional = service.findById(2);
        ProductCategory category = categoryOptional.orElse(null);
        Assert.assertEquals(new Integer(2), category.getCategoryId());
    }

    @Test
    public void findAll() throws Exception {
        List<ProductCategory> productCategoryList = service.findAll();
        Assert.assertNotEquals(0, productCategoryList.size());
    }

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<Integer> list = Arrays.asList(2, 3, 4);
        List<ProductCategory> categories = service.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, categories.size());

    }

    @Test
    public void save() throws Exception {
        ProductCategory productCategory = new ProductCategory("生最爱", 4);
        ProductCategory result = service.save(productCategory);
        Assert.assertNotNull(result);
    }

}