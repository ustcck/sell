package com.ustcck.datatransferobject;

import lombok.Data;

/**
 * Created by CaoKai on 2018/3/29 20:56.
 * Email:caokai@yijiahe.com
 */
@Data
public class CartDTO {

    private String productId;

    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
