package com.bawei.customprogressbar.presenter;

import java.util.Map;

public interface IPresenter {

    void  getData(String url, Map<String,String> params,Class clazz);
}
