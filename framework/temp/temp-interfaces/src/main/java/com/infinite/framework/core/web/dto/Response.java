package com.infinite.framework.core.web.dto;

import com.infinite.framework.core.dto.AbstractEntity;

/**
 * Created by hx handler 16-6-15.
 */
public class Response extends AbstractEntity {
    private String code;
    private String message;
    private Object obj;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", obj=" + obj +
                '}';
    }
}
