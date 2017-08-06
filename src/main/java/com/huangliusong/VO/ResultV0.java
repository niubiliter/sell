package com.huangliusong.VO;

import lombok.Data;

/** http请求返回的最外层对象
 * Created by huangliusong on 2017/8/6.
 */
@Data
public class  ResultV0<T> {
    //错误码
    private Integer code;
    //消息提示消息
    private String msg;
    //数据data
    private T data;
}
