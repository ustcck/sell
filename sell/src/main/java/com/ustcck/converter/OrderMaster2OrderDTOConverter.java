package com.ustcck.converter;

import com.ustcck.datatransferobject.OrderDTO;
import com.ustcck.entity.OrderMaster;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by CaoKai on 2018/3/30 11:31.
 * Email:caokai@yijiahe.com
 */
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO convert(OrderMaster orderMaster) {

        OrderDTO orderDTO = new OrderDTO();

        BeanUtils.copyProperties(orderMaster, orderDTO);

        return orderDTO;
    }


    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList) {

        return orderMasterList.stream().map(OrderMaster2OrderDTOConverter::convert).collect(Collectors.toList());
    }
}
