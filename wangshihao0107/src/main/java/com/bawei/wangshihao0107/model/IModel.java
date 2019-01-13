package com.bawei.wangshihao0107.model;

import java.util.HashMap;

public interface IModel {

    void rightData( HashMap<String,String> params,MyCallBack myCallBack);
    void leftData(HashMap<String,String> params,MyCallBack myCallBack);
}
