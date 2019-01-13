package com.bawei.zkweekrewrite.data.ok;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class LogInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Log.e("LogInterceptor","request:" + request);
        Log.e("LogInterceptor","request:"+System.nanoTime());
        Response response = chain.proceed(request);
        Log.e("LogInterceptor","request:" + request);
        Log.e("LogInterceptor","request:"+System.nanoTime());
        return response;
    }
}
