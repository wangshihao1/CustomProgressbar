package com.bawei.customprogressbar.model;

import java.util.Map;

public interface ICallBack<T> {

    void onSuccess(T datas);
    void onFailed(Exception e);
}
