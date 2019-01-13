package com.bawei.zkweekrewrite.di.model;
import com.bawei.zkweekrewrite.data.api.Apis;
import com.bawei.zkweekrewrite.data.ok.OkHttpUtils;
import com.bawei.zkweekrewrite.di.contract.IContract;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class IModelImp implements IContract.IModel {


    @Override
    public void responseInformation(final CallBack callBack) {
        OkHttpUtils.getInstance().doGet(Apis.LEFT_URL, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                String message = e.getMessage();
                callBack.onCallBack(message);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                callBack.onCallBack(result);
            }
        });
    }

    @Override
    public void responseDetails(int cid, final CallBack callBack) {
        OkHttpUtils.getInstance().doGet(Apis.RIGHT_UTL +"?cid="+cid, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //错误数据
                String message = e.getMessage();
                callBack.onCallBack(message);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                callBack.onCallBack(result);
            }
        });
    }


}
