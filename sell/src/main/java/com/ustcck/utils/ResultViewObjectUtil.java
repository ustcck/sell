package com.ustcck.utils;

import com.ustcck.common.ResultViewObject;

public class ResultViewObjectUtil {

    public static ResultViewObject success(Object object) {
        ResultViewObject ResultViewObject = new ResultViewObject();
        ResultViewObject.setData(object);
        ResultViewObject.setCode(0);
        ResultViewObject.setMsg("成功");
        return ResultViewObject;
    }

    public static ResultViewObject success() {
        return success(null);
    }

    public static ResultViewObject error(Integer code, String msg) {
        ResultViewObject ResultViewObject = new ResultViewObject();
        ResultViewObject.setCode(code);
        ResultViewObject.setMsg(msg);
        return ResultViewObject;
    }
}