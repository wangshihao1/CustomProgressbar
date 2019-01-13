package com.bawei.wangshihao0107.presenter;

import com.bawei.wangshihao0107.bean.LeftBean;
import com.bawei.wangshihao0107.bean.RightBean;
import com.bawei.wangshihao0107.model.IModelImp;
import com.bawei.wangshihao0107.model.MyCallBack;
import com.bawei.wangshihao0107.view.IView;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IPresenterImp implements IPresenter {

    private IView iView;
    private IModelImp modelImp;

    public IPresenterImp(IView iView) {
        this.iView = iView;
        modelImp = new IModelImp();
    }

    @Override
    public void leftResult(HashMap<String, String> params) {
         if (modelImp!=null){
             modelImp.leftData(params, new MyCallBack() {
                 @Override
                 public void success(String obj) {
                     Gson gson = new Gson();
                     LeftBean leftBean = gson.fromJson( obj, LeftBean.class);
                     List<LeftBean.DataBean> data = leftBean.data;
                     if (iView!=null){
                         iView.leftSuccess(data);
                     }
                 }

                 @Override
                 public void failed(Exception e) {
                     if (iView!=null){
                         iView.leftfialed(e.getMessage());
                     }
                 }
             });
         }
    }

    @Override
    public void rightResult(HashMap<String, String> params) {
        if (modelImp!=null){
            modelImp.leftData(params, new MyCallBack() {
                @Override
                public void success(String obj) {
                    Gson gson = new Gson();
                    RightBean rightBean = gson.fromJson( obj, RightBean.class);
                    List<RightBean.DataBean> data = rightBean.data;
                    if (iView!=null){
                        iView.rightSuccess(data);
                    }
                }

                @Override
                public void failed(Exception e) {
                    if (iView!=null){
                        iView.rightfialed(e.getMessage());
                    }
                }
            });
        }
    }

    public void onDectach(){
        if (iView!=null){
            iView=null;
        }
        if (modelImp!=null){
            modelImp=null;
        }
    }



}
