package com.bawei.dimensionecommerce.data.bean;

public class RegisterBean {


    /**
     * message : 注册成功
     * status : 0000
     */

    private String message;
    private String status;
    private final String SUCCESS = "0000";

    public boolean getSuccess(){
        return status.equals(SUCCESS);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
