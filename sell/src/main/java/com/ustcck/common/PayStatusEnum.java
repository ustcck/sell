package com.ustcck.common;

import lombok.Getter;

/**
 * Created by CaoKai on 2018/3/29 10:06.
 * Email:caokai@yijiahe.com
 */
@Getter
public enum PayStatusEnum {

    WAIT(0, "等待支付"),
    SUCCESSS(1, "支付成功");

    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
