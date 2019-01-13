package com.bawei.customprogressbar.model;

import com.bawei.customprogressbar.ok.MyCallBack;
import com.bawei.customprogressbar.ok.OkHttpUtils;

import java.util.Map;

public class IModelImp implements IModel {

    @Override
    public void requestData(String url, Map<String, String> params, Class clazz, final ICallBack callBack) {
        OkHttpUtils.getInstance().doPost(url, params, clazz, new MyCallBack() {
            @Override
            public void success(Object obj) {
                callBack.onSuccess(obj);
            }

            @Override
            public void failed(Exception e) {
                callBack.onFailed(e);
            }
        });
    }
}
