package com.bawei.dimensionecommerce.di.presenter;
import com.bawei.dimensionecommerce.di.contract.IContractRegister;
import com.bawei.dimensionecommerce.di.model.IRegisterModelImp;
import java.lang.ref.SoftReference;

public class IRegisterPresenterImp implements IContractRegister.IPresenter<IContractRegister.IRegisterView> {
    SoftReference<IContractRegister.IRegisterView> reference;
    IContractRegister.IRegisterView iView;
    IContractRegister.IregisterModel modelImp;


    @Override
    public void attachView(IContractRegister.IRegisterView iView) {
         this.iView = iView;
         reference= new SoftReference<>(iView);
         modelImp = new IRegisterModelImp();
    }

    @Override
    public void detachView(IContractRegister.IRegisterView iView) {
           reference.clear();
    }

    @Override
    public void ruquestRegisterData(String username, String password) {
          modelImp.containRegisterData(username, password, new IContractRegister.IregisterModel.OnCallBack() {
              @Override
              public void responseData(String responseData) {
                  iView.showData(responseData);
              }
          });
    }




}
