package com.example.administrator.mr.readsms.project.net;

/*
 * 项目名:    ThreeCash
 * 包名       com.dfjt.cash.model
 * 文件名:    BaseBean
 * 创建者:    唐洋
 * 创建时间:  2018/6/21 on 11:17
 * 描述:     TODO
 */
public class BaseBean<T> {

    /**
     * code : u_01
     * msg : 用户名或密码错误
     * result : null
     * success : false
     */

    private String code;
    private String msg;
    private T result;
    private boolean success;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
