package com.ustcck.repository;

import com.ustcck.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by CaoKai on 2018/3/13 16:41.
 * Email:caokai@yijiahe.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest() {
        Optional<ProductCategory> productCategoryOptional = repository.findById(1);
        System.out.println(productCategoryOptional.orElse(null));
    }

    @Test
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory("女生最爱",5);
        repository.save(productCategory);
    }

    @Test
    public void updateTest() {
        Optional<ProductCategory> productCategoryOptional = repository.findById(2);
        ProductCategory productCategory = productCategoryOptional.orElse(null);
        productCategory.setCategoryType(10);
        repository.save(productCategory);
    }
    @Test
    @Transactional //测试中的Transactional是完全回滚的，比如：下面的插入操作就不会再数据库中有记录
    public void insertTest() {
        ProductCategory productCategory = new ProductCategory("男生最爱", 7);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> list = Arrays.asList(2, 3, 4);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, result.size());
    }
}