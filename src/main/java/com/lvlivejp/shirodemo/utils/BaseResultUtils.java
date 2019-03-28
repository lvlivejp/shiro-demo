package com.lvlivejp.shirodemo.utils;

import com.lvlivejp.shirodemo.base.BaseResult;
import com.lvlivejp.shirodemo.enums.ResultEnum;

public class BaseResultUtils {
    public static BaseResult success(Object obj) {
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(ResultEnum.SUCCESS.getCode());
        baseResult.setMessage(ResultEnum.SUCCESS.getName());
        baseResult.setT(obj);
        return baseResult;
    }

    public static BaseResult success() {
        return success(null);
    }


    public static BaseResult fail(String code, String name) {
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(code);
        baseResult.setMessage(name);
        return baseResult;
    }
}
