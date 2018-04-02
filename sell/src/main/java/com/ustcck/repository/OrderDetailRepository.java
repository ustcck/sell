package com.ustcck.repository;

import com.ustcck.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by CaoKai on 2018/3/29 10:42.
 * Email:caokai@yijiahe.com
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    List<OrderDetail> findByOrderId(String orderId);
}
