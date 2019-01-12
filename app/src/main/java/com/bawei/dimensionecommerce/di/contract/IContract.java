package com.bawei.dimensionecommerce.di.contract;


import java.util.Map;

public interface IContract {

    //v层接口
    public interface IView<T>{
        //数据展示
        public void showData(T responseData);
    }

    //P层接口
    public interface IPresenter<IView>{
        // 绑定
        public void attachView(IView iView);
        // 解绑
        public void detachView(IView iView);

        public void requstRegisterData(String url, Map<String,String> params,Class clazz);
        //数据请求，请求M层数据，做登录处理
        public void requstLoginData(String url, Map<String,String> params,Class clazz);
    }

    // M层接口
    public interface IModel{

        public interface CallBack{

            public void responseData(String responseData);
        }
        //做注册的接口的请求
        public void registerResponseData(String url, Map<String,String> params,Class clazz, CallBack callback);
        //做登录的接口的请求
        public void loginResponseData(String url, Map<String,String> params,Class clazz, CallBack callback);
    }
}
