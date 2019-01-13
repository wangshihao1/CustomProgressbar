package com.bawei.customprogressbar.activity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.bawei.customprogressbar.R;
import com.bawei.customprogressbar.custom.CircleProgressView;

public class MainActivity extends AppCompatActivity {

    private CircleProgressView mCircleProgressView;
    private int currentProgress = 0;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (currentProgress <= 100) {
                mCircleProgressView.setCurrentProgress(currentProgress);
                Log.i("wx", currentProgress + "");
                currentProgress++;
                sendEmptyMessageDelayed(1, 50);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCircleProgressView = (CircleProgressView) findViewById(R.id.circle_view3);

        mCircleProgressView.setListener(new CircleProgressView.ProgressedListener() {
            @Override
            public void loadEnd() {
                Intent intent = new Intent(MainActivity.this,ShowActivity.class);
                startActivity(intent);
            }

            @Override
            public void progressLoading(int progressed) {
                //TODO
            }

            @Override
            public void startLoad() {

            }
        });
        mHandler.sendEmptyMessageDelayed(1, 1000);
    }


}
