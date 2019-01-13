package com.bawei.zkweekrewrite.data.ok;


import android.os.Handler;
import android.os.Looper;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class OkHttpUtils {

    private static OkHttpUtils instance;
    private OkHttpClient client;
    private Handler handler = new Handler(Looper.myLooper());

    private OkHttpUtils(){
        client = new OkHttpClient.Builder()
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .connectTimeout(10,TimeUnit.SECONDS)
                .addInterceptor(new LogInterceptor())
                .build();
    }

    public static OkHttpUtils getInstance() {
        if (instance == null){
            synchronized (OkHttpUtils.class){
                if (instance == null){
                    instance = new OkHttpUtils();
                }
            }
        }
        return instance;
    }

    public void doGet(String url, Callback callback){
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        client.newCall(request).enqueue(callback);
    }

    public void doPost(String url,Callback callback){
        FormBody.Builder builder = new FormBody.Builder();
        RequestBody body = builder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        client.newCall(request).enqueue(callback);
    }
}
