package com.ustcck.repository;

import com.ustcck.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by CaoKai on 2018/3/13 16:38.
 * Email:caokai@yijiahe.com
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);
}
