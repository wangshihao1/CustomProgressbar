package com.bawei.customprogressbar.ok;
import android.os.Handler;
import android.os.Looper;
import com.google.gson.Gson;
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
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpUtils {

    private static OkHttpUtils instance;
    private Handler handler = new Handler(Looper.myLooper());
    private OkHttpClient client;

    private OkHttpUtils(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(10,TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
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

    public void doGet(String url, Map<String,String> parmas, final Class clazz, final MyCallBack myCallBack){
        final Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        myCallBack.failed(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                      String result = response.body().string();
                      Gson gson = new Gson();
                      final Object o = gson.fromJson(result, clazz);
                      handler.post(new Runnable() {
                          @Override
                          public void run() {
                              myCallBack.success(o);
                          }
                      });
            }
        });
    }

    public void doPost(String url, Map<String,String> parmas, final Class clazz, final MyCallBack myCallBack){
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String,String> entry :parmas.entrySet() ) {
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
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            myCallBack.failed(e);
                        }
                    });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                  String result = response.body().string();
                  Gson gson = new Gson();
                  final Object o = gson.fromJson(result, clazz);
                  handler.post(new Runnable() {
                      @Override
                      public void run() {
                         myCallBack.success(o);
                      }
                  });
            }
        });

    }
}
