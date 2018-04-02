package com.ustcck.exception;

import com.ustcck.common.ResultEnum;

/**
 * Created by CaoKai on 2018/3/29 20:28.
 * Email:caokai@yijiahe.com
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;

    }
}
