package com.ustcck.service;

import com.ustcck.datatransferobject.OrderDTO;

/**
 * Created by CaoKai on 2018/4/2 9:51.
 * Email:caokai@yijiahe.com
 */
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid, String orderId);
}
