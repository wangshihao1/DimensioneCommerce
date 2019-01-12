package com.bawei.dimensionecommerce.data.interceptor;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class LogInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Log.e("LogInterceptor","request:"+request);
        Response response = chain.proceed(request);
        Log.e("LogInterceptor","request:"+request);
        return response;
    }
}
