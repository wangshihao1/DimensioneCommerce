package com.bawei.dimensionecommerce.di.presenter;

import com.bawei.dimensionecommerce.di.contract.IContract;
import com.bawei.dimensionecommerce.di.model.ILoginRegisterModel;
import java.lang.ref.SoftReference;
import java.util.Map;

public class ILoginRegisterPresenter implements IContract.IPresenter<IContract.IView> {
    private SoftReference<IContract.IView> reference;
    IContract.IView iView;
    ILoginRegisterModel modelImp;
    @Override
    public void attachView(IContract.IView iView) {
        this.iView = iView;
        //软引用包裹
        reference = new SoftReference<>(iView);
        modelImp = new ILoginRegisterModel();
}

    @Override
    public void detachView(IContract.IView iView) {
          reference.clear();
    }

    @Override
    public void requstRegisterData(String url, Map<String, String> params, Class clazz) {
         modelImp.registerResponseData(url, params, clazz, new IContract.IModel.CallBack() {
             @Override
             public void responseData(String responseData) {
                 iView.showData(responseData);
             }
         });
    }

    @Override
    public void requstLoginData(String url, Map<String, String> params, Class clazz) {
        modelImp.loginResponseData(url, params, clazz, new IContract.IModel.CallBack() {
            @Override
            public void responseData(String responseData) {
                iView.showData(responseData);
            }
        });
    }


}
