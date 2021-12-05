package com.xhu.util;

import lombok.Data;

import java.io.Serializable;

/**
 * Json格式的数据进行响应的泛型类
 *<p>当需要给前端传递json数据时调用这个类</p>
 * @author YXM
 */
@Data
public class JsonResult<E> implements Serializable {
    /**
     * 状态码
     */
    private Integer state;

    /**
     * 描述信息
     */
    private String message;

    /**数据*/
    private E data;


    public JsonResult() {
    }

    public JsonResult(Integer state) {
        this.state = state;
    }

    public JsonResult(Integer state, E data) {
        this.state = state;
        this.data = data;
    }

    public JsonResult(Throwable e) {
        this.message=e.getMessage();
    }


}
