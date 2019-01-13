package com.bawei.dimensionecommerce.di.presenter;
import com.bawei.dimensionecommerce.di.contract.IContractLogin;
import com.bawei.dimensionecommerce.di.model.ILoginModelImp;

import java.lang.ref.SoftReference;

public class ILoginPresenterImp implements IContractLogin.IPresenter<IContractLogin.ILoginView> {

    SoftReference<IContractLogin.ILoginView> reference;
    IContractLogin.ILoginView iView;
    IContractLogin.IloginModel modelImp;


    @Override
    public void attachView(IContractLogin.ILoginView iView) {
        this.iView = iView;
        reference= new SoftReference<>(iView);
        modelImp = new ILoginModelImp();
    }

    @Override
    public void detachView(IContractLogin.ILoginView iView) {
        reference.clear();
    }

    @Override
    public void ruquestRegisterData(String username, String password) {
        modelImp.containLoginData(username, password, new IContractLogin.IloginModel.OnCallBack() {
            @Override
            public void responseData(String responseData) {
                iView.showData(responseData);
            }
        });
    }


}
