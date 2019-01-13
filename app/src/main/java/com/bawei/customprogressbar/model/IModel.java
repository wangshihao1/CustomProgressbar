package com.bawei.customprogressbar.model;

import java.util.Map;

public interface IModel {

    void requestData(String url, Map<String,String> params,Class clazz,ICallBack callBack);
}
