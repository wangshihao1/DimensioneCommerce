package com.bawei.dimensionecommerce.di.contract;

public interface IContractRegister {

    //v层接口
    public interface IRegisterView{
        //数据展示
        public void showData(String responseData);
    }

    //P层接口
    public interface IPresenter<IRegisterView>{
        // 绑定
        void attachView(IRegisterView iView);
        // 解绑
         void detachView(IRegisterView iView);

        void ruquestRegisterData(String username,String password);

    }

    // M层接口
    public interface IregisterModel{

        public interface OnCallBack{

             void responseData(String responseData);
        }
        //做注册的接口的请求
        void containRegisterData(String username,String password,OnCallBack onCallBack);

    }
}
