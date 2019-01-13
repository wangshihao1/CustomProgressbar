package com.bawei.zkweekrewrite.di.presemter;

import com.bawei.zkweekrewrite.di.contract.IContract;
import com.bawei.zkweekrewrite.di.model.IModelImp;

import java.lang.ref.SoftReference;

public class IPresenterImp implements IContract.IPresnter<IContract.IView> {

     private IContract.IView view;
     private IContract.IModel model;
     private SoftReference<IContract.IView> reference;
    @Override
    public void attachView(IContract.IView iView) {
            this.view = iView;
            reference = new SoftReference<>(view);
            model = new IModelImp();
    }

    @Override
    public void dectach(IContract.IView iView) {
            reference.clear();
    }

    @Override
    public void requestInformation() {
          model.responseInformation(new IContract.IModel.CallBack() {
              @Override
              public void onCallBack(String data) {
                  view.showInformation(data);
              }
          });
    }

    @Override
    public void requestDetails(int cid) {
            model.responseDetails(cid, new IContract.IModel.CallBack() {
                @Override
                public void onCallBack(String data) {
                    view.showDetails(data);
                }
            });
    }


}
