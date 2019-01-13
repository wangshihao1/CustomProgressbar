package com.bawei.zkweekrewrite.di.contract;

public interface IContract {
    // v层
    public interface IView{
        //展示信息
        public void showInformation(String data);
        //详情数据
        public void showDetails(String data);
    }

    // p层
    public interface IPresnter<IView>{
        //绑定
        public void attachView(IView view);
        //解绑
        public void dectach(IView view);
        //请求数据
        public void requestInformation();
        //请求详情
        public void requestDetails(int cid);
    }
    // m层
    public interface IModel{
        // 回调方法
        public interface CallBack{
            public void onCallBack(String data);
        }

        //请求展示信息
        public void responseInformation(CallBack callBack);
        //请求详情数据
        public void responseDetails(int cid,CallBack callBack);
    }
}
