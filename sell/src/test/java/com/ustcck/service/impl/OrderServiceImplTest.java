package com.ustcck.service.impl;

import com.ustcck.datatransferobject.OrderDTO;
import com.ustcck.entity.OrderDetail;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by CaoKai on 2018/3/30 9:59.
 * Email:caokai@yijiahe.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    private final String BUYER_OPENID = "110110";
    private final String ORDER_ID = "1522377509397298221";

    @Autowired
    private OrderServiceImpl orderService;

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("ustcck");
        orderDTO.setBuyerAddress("铁心桥");
        orderDTO.setBuyerPhone("123456789");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("123456");
        orderDetail.setProductQuantity(1);

        OrderDetail orderDetail2 = new OrderDetail();
        orderDetail2.setProductId("123462");
        orderDetail2.setProductQuantity(3);

        orderDetailList.add(orderDetail);
        orderDetailList.add(orderDetail2);

        orderDTO.setOrderDetailList(orderDetailList);

        orderService.create(orderDTO);
    }

    @Test
    public void findOne() {

        OrderDTO result = orderService.findOne(ORDER_ID);

        log.info("查询单个订单， result={}", result);
        Assert.assertEquals(ORDER_ID, result.getOrderId());

    }

    @Test
    public void findList() {
    }

    @Test
    public void cencel() {
    }

    @Test
    public void finish() {
    }

    @Test
    public void paid() {
    }
}