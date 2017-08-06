package com.huangliusong.utils;

import com.huangliusong.VO.ResultV0;

/**
 * Created by huangliusong on 2017/8/6.
 */
public class ResultVOUtil {
    public static ResultV0 success(Object object){
        ResultV0 resultV0=new ResultV0();
        resultV0.setData(object);
        resultV0.setCode(0);
        resultV0.setMsg("成功");
        return resultV0;
    }
    public static ResultV0 success(){
        return success(null);
    }

    public static ResultV0 error(Integer code,String msg){
        ResultV0 resultV0=new ResultV0();
        resultV0.setCode(code);
        resultV0.setMsg(msg);
        return resultV0;
    }
}
