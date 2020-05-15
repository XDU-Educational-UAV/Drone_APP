package com.test.UAVRemoter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class BatteryView extends View {
    private int mMargin = 5;    //电池内芯与边框的距离
    private int mBoder = 4;     //电池外框的宽带
    private int mWidth = 70;    //总长
    private int mHeight = 40;   //总高
    private int mHeadWidth = 6;
    private int mHeadHeight = 10;

    private RectF mMainRect;
    private RectF mHeadRect;
    private float mRadius = 4f;   //圆角
    private float mPower = (float) 0;



    public BatteryView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public BatteryView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public BatteryView(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        mHeadRect = new RectF(0, (mHeight - mHeadHeight) / 2, mHeadWidth, (mHeight + mHeadHeight) / 2);

        float left = mHeadRect.width();
        float top = mBoder;
        float right = mWidth - mBoder;
        float bottom = mHeight - mBoder;
        mMainRect = new RectF(left, top, right, bottom);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint1 = new Paint();

        //画电池头
        paint1.setStyle(Paint.Style.FILL);  //实心
        paint1.setColor(Color.WHITE);
        canvas.drawRect(mHeadRect, paint1);

        //画外框
        paint1.setStyle(Paint.Style.STROKE);    //设置空心矩形
        paint1.setStrokeWidth(mBoder);          //设置边框宽度
        paint1.setColor(Color.WHITE);
        canvas.drawRoundRect(mMainRect, mRadius, mRadius, paint1);

        //画电池芯
        Paint paint = new Paint();
        if (mPower < 0.2) {
            paint.setColor(Color.RED);
        } else if(mPower>=0.2 && mPower <=0.6){
                paint.setColor(Color.YELLOW);
            }
        else
            paint.setColor(Color.GREEN);

        int width = (int) (mPower * (mMainRect.width() - mMargin * 2));
        int left = (int) (mMainRect.right - mMargin - width);
        int right = (int) (mMainRect.right - mMargin);
        int top = (int) (mMainRect.top + mMargin);
        int bottom = (int) (mMainRect.bottom - mMargin);
        Rect rect = new Rect(left, top, right, bottom);
        canvas.drawRect(rect, paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(mWidth, mHeight);
    }


    public void setPower(float power) {
        mPower = power;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        };
    }

//    public class BatteryThread extends Thread{
//        @Override
//        public void run()
//        {
//            if (Protocol.voltage!=mTempPower)
//                invalidate();
//        }
//    }

}
