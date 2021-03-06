package com.ustcck.repository;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.ustcck.entity.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by CaoKai on 2018/3/29 10:47.
 * Email:caokai@yijiahe.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    private final String OPENID = "110110";

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("000001");
        orderMaster.setBuyerName("ustcck");
        orderMaster.setBuyerPhone("123456789");
        orderMaster.setBuyerAddress("楚翘城");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(2.5));

        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenid() {
        PageRequest request = PageRequest.of(0, 3);

        Page<OrderMaster> result = repository.findByBuyerOpenid(OPENID, request);

        System.out.println(result.getTotalElements());
        System.out.println(result.getTotalPages());

    }
}