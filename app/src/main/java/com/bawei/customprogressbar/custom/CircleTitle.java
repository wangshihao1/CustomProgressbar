package com.bawei.customprogressbar.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.bawei.customprogressbar.R;

public class CircleTitle extends LinearLayout {

    private Context context;
    private EditText editText;
    private Button button;

    public CircleTitle(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public CircleTitle(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    private void init() {
        View v =View.inflate(context,R.layout.title,null);
        editText = v.findViewById(R.id.et_search);
        button = v.findViewById(R.id.bt_click);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mButtonClick!=null){
                    mButtonClick.onClick(editText.getText().toString().trim());
                }
            }
        });
        addView(v);
    }


    public interface onButtonClick{

        void onClick(String str);
    }

    private onButtonClick mButtonClick;

    public void setmButtonClick(onButtonClick mButtonClick) {
        this.mButtonClick = mButtonClick;
    }
}
