package com.bawei.wangshihao0107.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bawei.wangshihao0107.R;

public class CustomTitle extends LinearLayout {

    private ImageView retur,tab;
    private TextView title;
    private Context context;
    public CustomTitle(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public CustomTitle(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    private void init() {
        View v = View.inflate(context, R.layout.itme_title,null);
        retur = v.findViewById(R.id.retur);
        retur.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        addView(v);
    }
}
