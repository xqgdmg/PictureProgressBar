package com.scut.pictureprogressbar;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.yanzhikai.pictureprogressbar.PictureProgressBar;

public class MainActivity extends AppCompatActivity {
    Button btn_start;
    PictureProgressBar pb_1, pb_2, pb_3, pb_4, pb_5;
    private ValueAnimator valueAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();
        initData();

        //使用属性动画来实现进度的变化
        initAnimation();
    }

    private void initListener() {

        // 开始动画
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pb_1.setAnimRun(true);// 自定义图片
                pb_2.setPicture(R.drawable.b333);// 初始图片
                pb_3.setAnimRun(true);// 默认图片
                pb_4.setAnimRun(true);
                pb_5.setAnimRun(true);
                valueAnimator.start();
            }
        });
    }

    private void initAnimation() {
        valueAnimator = ValueAnimator.ofInt(0, 1000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                pb_1.setProgress(Integer.parseInt(animation.getAnimatedValue().toString()));
                if (pb_1.getProgress() >= pb_1.getMax()) {
                    //进度满了之后停止动画
                    pb_1.setAnimRun(false);
                }
                pb_2.setProgress(Integer.parseInt(animation.getAnimatedValue().toString()));
                if (pb_2.getProgress() >= pb_2.getMax()) {
                    //进度满了之后改变图片
                    pb_2.setPicture(R.drawable.b666);
                }
                pb_3.setProgress(Integer.parseInt(animation.getAnimatedValue().toString()));
                if (pb_3.getProgress() >= pb_3.getMax()) {
                    pb_3.setAnimRun(false);
                }
                pb_4.setProgress(Integer.parseInt(animation.getAnimatedValue().toString()));
                if (pb_4.getProgress() >= pb_4.getMax()) {
                    pb_4.setAnimRun(false);
                }
                pb_5.setProgress(Integer.parseInt(animation.getAnimatedValue().toString()));
                if (pb_5.getProgress() >= pb_5.getMax()) {
                    pb_5.setAnimRun(false);
                }
            }
        });
        valueAnimator.setDuration(10000);
    }

    private void initData() {
        pb_1.setDrawableIds(new int[]{R.drawable.i00, R.drawable.i01, R.drawable.i02, R.drawable.i03, R.drawable.i04, R.drawable.i05, R.drawable.i06});
    }

    private void initView() {
        btn_start = (Button) findViewById(R.id.btn_start);
        pb_1 = (PictureProgressBar) findViewById(R.id.pb_1);
        pb_2 = (PictureProgressBar) findViewById(R.id.pb_2);
        pb_3 = (PictureProgressBar) findViewById(R.id.pb_3);
        pb_4 = (PictureProgressBar) findViewById(R.id.pb_4);
        pb_5 = (PictureProgressBar) findViewById(R.id.pb_5);
    }
}
