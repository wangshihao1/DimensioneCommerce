package com.bawei.dimensionecommerce.di.model;
import com.bawei.dimensionecommerce.data.ok.Apis;
import com.bawei.dimensionecommerce.di.contract.IContractRegister;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;


public class IRegisterModelImp implements IContractRegister.IregisterModel {


    @Override
    public void containRegisterData(String username, String password, final OnCallBack onCallBack) {
       String urlString = Apis.REGISTER_URL+"?phone="+username+"&pwd="+password;

        OkGo.<String>post(urlString).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                String responseData = response.body().toString();
                onCallBack.responseData(responseData);
            }
        });

    }

}
