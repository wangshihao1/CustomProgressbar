package com.bawei.wangshihao0107.model;

import com.bawei.wangshihao0107.api.Apis;
import com.bawei.wangshihao0107.ok.ICallBack;
import com.bawei.wangshihao0107.ok.OkHttpUtils;

import java.util.HashMap;


public class IModelImp implements IModel {

    @Override
    public void rightData(HashMap<String, String> params, final MyCallBack myCallBack) {
               OkHttpUtils.getInstance().doPost(Apis.RIGHT_URL, params, new ICallBack() {
                   @Override
                   public void onSuccess(String obj) {
                       if (myCallBack!=null){
                           myCallBack.success(obj);
                       }
                   }

                   @Override
                   public void onFailed(Exception e) {
                       if (myCallBack!=null){
                           myCallBack.failed(e);
                       }
                   }
               });
    }

    @Override
    public void leftData(HashMap<String, String> params, final MyCallBack myCallBack) {
        OkHttpUtils.getInstance().doPost(Apis.LEFT_URL, params, new ICallBack() {
            @Override
            public void onSuccess(String obj) {
                if (myCallBack!=null){
                    myCallBack.success(obj);
                }
            }

            @Override
            public void onFailed(Exception e) {
                if (myCallBack!=null){
                    myCallBack.failed(e);
                }
            }
        });
    }


}
