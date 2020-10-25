package com.smart.app.resp;

//404 资源部存在
// 40001  用户已存在
// 40002 注册失败
// 40004 服务器繁忙! 请稍后再试


public class BaseResponseEntity<T> {
    private int status;
    private String msg;
    private T data;

    public static <T> BaseResponseEntity<T> success(T data) {
        return success(200, "success");
    }


    public static <T> BaseResponseEntity success(int status, String msg) {
        BaseResponseEntity baseResponseEntity = new BaseResponseEntity();
        baseResponseEntity.setStatus(status);
        baseResponseEntity.setMsg(msg);

        return baseResponseEntity;
    }

    public static <T> BaseResponseEntity error() {
        return error(404, "error");
    }

    public static <T> BaseResponseEntity error(int status, String msg) {
        BaseResponseEntity baseResponseEntity = new BaseResponseEntity();
        baseResponseEntity.setStatus(status);
        baseResponseEntity.setMsg(msg);
        return baseResponseEntity;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
