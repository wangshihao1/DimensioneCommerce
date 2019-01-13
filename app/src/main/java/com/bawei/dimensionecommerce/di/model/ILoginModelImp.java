package com.bawei.dimensionecommerce.di.model;
import com.bawei.dimensionecommerce.data.ok.Apis;
import com.bawei.dimensionecommerce.di.contract.IContractLogin;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

public class ILoginModelImp implements IContractLogin.IloginModel {

    @Override
    public void containLoginData(String username, String password, final OnCallBack onCallBack) {
        String urlString = Apis.LOGIN_URL+"?phone="+username+"&pwd="+password;

        OkGo.<String>post(urlString).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                String responseData = response.body().toString();
                onCallBack.responseData(responseData);
            }
        });
    }
}
