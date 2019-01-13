package com.bawei.dimensionecommerce.data.ok;
import android.os.Handler;
import android.os.Looper;
import com.bawei.dimensionecommerce.data.interceptor.LogInterceptor;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpUtils {

    private static OkHttpUtils instance;
    private Handler handler = new Handler(Looper.myLooper());
    private OkHttpClient client;

    private OkHttpUtils(){
        client = new OkHttpClient.Builder()
                .connectTimeout(10,TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .addInterceptor(new LogInterceptor())
                .build();
    }

    public static OkHttpUtils getInstance() {
        if (instance==null){
            synchronized (OkHttpUtils.class){
                if (instance==null){
                    instance = new OkHttpUtils();
                }
            }
        }
        return instance;
    }

    /*public void doPost(String url, Map<String,String> map,final ICallBack callback){
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String,String> entry : map.entrySet()) {
            builder.add(entry.getKey(),entry.getValue());
        }
        RequestBody body = builder.build();
         //获取Request对象
        Request request = new Request.Builder()
                .post(body)
                .url(url)
                .build();
        //开启请求
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.failed(e);
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseData = response.body().string();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.success(responseData);
                    }
                });

            }
        });

    }*/
}
