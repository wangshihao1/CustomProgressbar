package com.bawei.zkweekrewrite.ui.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bawei.zkweekrewrite.R;

public class CustomTitleBar extends LinearLayout implements View.OnClickListener {


    private int mColor;
    public CustomTitleBar(Context context) {
        super(context);
    }

    public CustomTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        View rootView = LayoutInflater.from(context).inflate(R.layout.title_bar_item, this);
        TextView tv_custom_title = rootView.findViewById(R.id.tv_custom_title);
        ImageView iv_back = rootView.findViewById(R.id.iv_back);
        ImageView iv_menu = rootView.findViewById(R.id.iv_menu);
        iv_back.setOnClickListener(this);
        iv_menu.setOnClickListener(this);
        //自定义属性
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomTitleBar);
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            switch (index){
                case R.styleable.CustomTitleBar_mColor:
                    mColor = typedArray.getColor(i, Color.GREEN);
                    tv_custom_title.setTextColor(mColor);
                    break;
            }
        }
    }





    @Override
    public void onClick(View v) {
           switch (v.getId()){
               case R.id.iv_back:
                   callBackListener.onCallBack();
               case R.id.iv_menu:
                   menuBackListener.onCallBack();
           }
    }


    public interface onCallBackListener{
        void onCallBack();
    }

    private onCallBackListener callBackListener;

    public void setCallBackListener(onCallBackListener callBackListener) {
        this.callBackListener = callBackListener;
    }

    public interface onMenuBackListener{
        void onCallBack();
    }

    private onMenuBackListener menuBackListener;

    public void setMenuBackListener(onMenuBackListener menuBackListener) {
        this.menuBackListener = menuBackListener;
    }
}
