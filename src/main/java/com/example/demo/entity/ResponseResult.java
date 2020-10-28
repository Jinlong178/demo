package com.example.demo.entity;

/**
 * 响应实体类
 */
public class ResponseResult {

    public static final Integer CODE_NO_RESULT = 0;
    public static final String STR_NO_RESULT = "数据为空";

    public static final Integer CODE_SUCCESS = 1;
    public static final String STR_SUCCESS = "SUCCESS";

    public static final Integer CODE_FAILURE = -1;
    public static final String STR_FAILURE = "FAILURE";

    private Integer code;

    private String message;
    /**
     * 请求成功时返回的数据
     */
    private Object data;

    public ResponseResult() {
    }


    /**
     * 这里实现链式操作
     */
    public static ResponseResult builder() {
        return new ResponseResult();
    }

    /**
     * 设置错误[成功时也可以传递信息]消息与编码
     */
    public ResponseResult msg(Integer code, String msg) {
        setCode(code);
        setMessage(msg);
        return this;
    }

    /**
     * 设置需要返回的数据体
     */
    public ResponseResult data(Object data) {
        setData(data);
        return this;
    }

    /**
     * 设置错误[成功时也可以传递信息]消息与编码
     */
    public static ResponseResult success(Object data) {
        return builder().msg(CODE_SUCCESS, STR_SUCCESS).data(data);
    }

    public Object getData() {
        return data;
    }

    private void setData(Object data) {
        this.data = data;
    }

    private void setCode(Integer code) {
        this.code = code;
    }

    private void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
