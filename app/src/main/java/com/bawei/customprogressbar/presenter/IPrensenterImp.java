package com.bawei.customprogressbar.presenter;

import com.bawei.customprogressbar.model.ICallBack;
import com.bawei.customprogressbar.model.IModelImp;
import com.bawei.customprogressbar.view.IView;

import java.util.Map;

public class IPrensenterImp implements IPresenter {

    private IView view;
    private IModelImp modelImp;

    public IPrensenterImp(IView view) {
        this.view = view;
        modelImp = new IModelImp();
    }

    @Override
    public void getData(String url, Map<String, String> params, Class clazz) {
          modelImp.requestData(url, params, clazz, new ICallBack() {
              @Override
              public void onSuccess(Object datas) {
                    view.showData(datas);
              }

              @Override
              public void onFailed(Exception e) {
                    view.showData(e.getMessage());
              }
          });
    }

    public void onDetach(){
        if (modelImp!=null){
            modelImp = null;
        }
        if (view!=null){
            view =null;
        }
    }
}
