package com.ustcck.controller;

import com.lly835.bestpay.model.PayResponse;
import com.ustcck.common.ResultEnum;
import com.ustcck.datatransferobject.OrderDTO;
import com.ustcck.exception.SellException;
import com.ustcck.service.OrderService;
import com.ustcck.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by CaoKai on 2018/4/2 16:14.
 * Email:caokai@yijiahe.com
 */
@Controller
@RequestMapping("/pay")
public class PayController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private PayService payService;

    @GetMapping("/create")
    public void create(@RequestParam("orderId") String orderId,
                  @RequestParam("returnUrl") String returnUrl) {
        //1.查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        //发起支付
        payService.create(orderDTO);
    }
}
