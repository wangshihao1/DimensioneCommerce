package com.bawei.dimensionecommerce.di.contract;

public interface IContractLogin {

    //v层接口
    public interface ILoginView{
        //数据展示
         void showData(String responseData);
    }

    //P层接口
    public interface IPresenter<ILoginView>{
        // 绑定
        void attachView(ILoginView iView);
        // 解绑
        void detachView(ILoginView iView);

        void ruquestRegisterData(String username,String password);

    }

    // M层接口
    public interface IloginModel{

        public interface OnCallBack{

            void responseData(String responseData);
        }

        //做登录的接口的请求
        void containLoginData(String username,String password,OnCallBack onCallBack);
    }
}
