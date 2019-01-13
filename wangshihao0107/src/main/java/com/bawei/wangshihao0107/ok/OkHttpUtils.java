package com.bawei.wangshihao0107.ok;

import android.os.Handler;
import android.os.Looper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpUtils {

    private static OkHttpUtils instance;
    private Handler handler = new Handler(Looper.myLooper());
    private OkHttpClient client;

    private OkHttpUtils(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .readTimeout(10,TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .connectTimeout(10,TimeUnit.SECONDS)
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

    public void doPost(String url, HashMap<String,String> params, final ICallBack callBack){
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String,String> entry: params.entrySet()) {
            builder.add(entry.getKey(),entry.getValue());
        }
        RequestBody body = builder.build();
        Request request = new Request.Builder()
                .post(body)
                .url(url)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                if (callBack!=null) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callBack.onFailed(e);
                        }
                    });
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result = response.body().string();
                if (callBack!=null) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callBack.onSuccess(result);
                        }
                    });
                }

            }
        });
    }
}
