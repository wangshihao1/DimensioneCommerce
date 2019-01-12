package com.bawei.dimensionecommerce.di.model;
import com.bawei.dimensionecommerce.data.ok.ICallBack;
import com.bawei.dimensionecommerce.data.ok.OkHttpUtils;
import com.bawei.dimensionecommerce.di.contract.IContract;
import com.google.gson.Gson;

import java.util.Map;

public class ILoginRegisterModel implements IContract.IModel {

    @Override
    public void registerResponseData(String url, Map<String, String> params, final Class clazz, final CallBack callback) {
        OkHttpUtils.getInstance().doPost(url, params, new ICallBack() {
            @Override
            public void success(String datas) {
                try {
                    Object o = new Gson().fromJson(datas, clazz);
                    if (callback != null) {
                        callback.responseData((String) o);
                    }
                }catch (Exception e){
                    if (callback!=null){
                        callback.responseData(e.getMessage());
                    }
                }
            }

            @Override
            public void failed(Exception e) {
               if (callback!=null){
                   callback.responseData(e.getMessage());
               }
            }
        });
    }

    @Override
    public void loginResponseData(String url, Map<String, String> params, final Class clazz, final CallBack callback) {
        OkHttpUtils.getInstance().doPost(url, params, new ICallBack() {
            @Override
            public void success(String datas) {
                try {
                    Object o = new Gson().fromJson(datas, clazz);
                    if (callback != null) {
                        callback.responseData((String) o);
                    }
                }catch (Exception e){
                    if (callback!=null){
                        callback.responseData(e.getMessage());
                    }
                }
            }

            @Override
            public void failed(Exception e) {
                if (callback!=null){
                    callback.responseData(e.getMessage());
                }
            }
        });
    }
}
