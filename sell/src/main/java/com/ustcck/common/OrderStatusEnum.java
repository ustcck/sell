package com.ustcck.common;

import lombok.Getter;

/**
 * Created by CaoKai on 2018/3/28 23:44.
 * Email:caokai@yijiahe.com
 */
@Getter
public enum OrderStatusEnum {
    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2,"已取消")
    ;

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
