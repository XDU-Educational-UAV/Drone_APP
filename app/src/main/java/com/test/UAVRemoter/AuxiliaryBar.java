package com.test.UAVRemoter;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class AuxiliaryBar extends Dialog {

    private final static String TAG = AuxiliaryBar.class.getSimpleName();
    private ImageView imageView;
    private Context context;
    private SeekBar seekBar1;
    private SeekBar seekBar2;
    private SeekBar seekBar3;
    private SeekBar seekBar4;
    private TextView seekBar1Text;
    private TextView seekBar2Text;
    private TextView seekBar3Text;
    private TextView seekBar4Text;
    private int mProgress2;
    private int mProgress1;
    private int mProgress3;
    private int mProgress4;
    public OnProgressGetListener mOnProgressGetListener;

    public AuxiliaryBar(Context context, int myDialog,int progress1,int progress2,int progress3,int progress4) {
        super(context, myDialog);
        this.context=context;
        this.mProgress1=progress1;
        this.mProgress2=progress2;
        this.mProgress3=progress3;
        this.mProgress4=progress4;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.dialog_bar);

        //尝试过用类去封装来简化代码，但是因为控件和对象的对接总是出现问题，若能实现代码化简，欢迎联系！

        //seekBar
        initSeekBar1();
        initSeekBar2();
        initSeekBar3();
        initSeekBar4();

        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mOnProgressGetListener.getProgress(mProgress1,mProgress2,mProgress3,mProgress4);
                AuxiliaryBar.this.dismiss();
            }
        });
    }


    public void setOnProgressGetListener(OnProgressGetListener listener) {
        mOnProgressGetListener = listener;
    }

    /**
     * 监听接口
     */
    public interface OnProgressGetListener {
        // 开始
        void getProgress(int progress1,int progress2,int progress3,int progress4);
    }


    private void initSeekBar1()
    {
        seekBar1Text = (TextView) findViewById(R.id.mySeekBar1text);
        imageView = (ImageView) findViewById(R.id.close);
        seekBar1 = (SeekBar) findViewById(R.id.mySeekBar1);
        //初始化
        seekBar1.setMax(Protocol.MAX);
        seekBar1.setProgress(mProgress1);
        seekBar1.setOnSeekBarChangeListener(seekListener1);
        seekBar1Text.setText(Integer.toString(mProgress1));

    }

    private SeekBar.OnSeekBarChangeListener seekListener1 = new SeekBar.OnSeekBarChangeListener(){
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            Log.i(TAG,"onStopTrackingTouch");
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            Log.i(TAG,"onStartTrackingTouch");
        }

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,
                                      boolean fromUser) {
            Log.i(TAG,"onProgressChanged");
            seekBar1Text.setText(Integer.toString(progress));
            mProgress1=progress;
        }
    };

    //second
    private void initSeekBar2()
    {
        seekBar2Text = (TextView) findViewById(R.id.mySeekBar2text);
        seekBar2 = (SeekBar) findViewById(R.id.mySeekBar2); //初始化
        seekBar2.setMax(Protocol.MAX);
        seekBar2.setProgress(mProgress2);
        Log.d(TAG,"middle"+mProgress2);
        seekBar2.setOnSeekBarChangeListener(seekListener2);
        seekBar2Text.setText(Integer.toString(mProgress2));
    }

    private SeekBar.OnSeekBarChangeListener seekListener2 = new SeekBar.OnSeekBarChangeListener(){
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            Log.i(TAG,"onStopTrackingTouch");
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            Log.i(TAG,"onStartTrackingTouch");
        }

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,
                                      boolean fromUser) {
            Log.i(TAG,"onProgressChanged");
            seekBar2Text.setText(Integer.toString(progress));
            mProgress2=progress;
        }
    };
    //third
    private void initSeekBar3()
    {
        seekBar3Text = (TextView) findViewById(R.id.mySeekBar3text);
        imageView = (ImageView) findViewById(R.id.close);
        seekBar3 = (SeekBar) findViewById(R.id.mySeekBar3); //初始化
        seekBar3.setMax(Protocol.MAX);
        seekBar3.setProgress(mProgress3);
        seekBar3.setOnSeekBarChangeListener(seekListener3);
        seekBar3Text.setText(Integer.toString(mProgress3));

        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AuxiliaryBar.this.dismiss();
            }
        });
    }

    private SeekBar.OnSeekBarChangeListener seekListener3 = new SeekBar.OnSeekBarChangeListener(){
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            Log.i(TAG,"onStopTrackingTouch");
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            Log.i(TAG,"onStartTrackingTouch");
        }

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,
                                      boolean fromUser) {
            Log.i(TAG,"onProgressChanged");
            seekBar3Text.setText(Integer.toString(progress));
            mProgress3=progress;
        }
    };
    //fourth
    private void initSeekBar4()
    {
        seekBar4Text = (TextView) findViewById(R.id.mySeekBar4text);
        imageView = (ImageView) findViewById(R.id.close);
        seekBar4 = (SeekBar) findViewById(R.id.mySeekBar4); //初始化
        seekBar4.setMax(Protocol.MAX);
        seekBar4.setProgress(mProgress4);
        seekBar4.setOnSeekBarChangeListener(seekListener4);
        seekBar4Text.setText(Integer.toString(mProgress4));

        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AuxiliaryBar.this.dismiss();
            }
        });
    }

    private SeekBar.OnSeekBarChangeListener seekListener4 = new SeekBar.OnSeekBarChangeListener(){
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            Log.i(TAG,"onStopTrackingTouch");
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            Log.i(TAG,"onStartTrackingTouch");
        }

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,
                                      boolean fromUser) {
            Log.i(TAG,"onProgressChanged");
            seekBar4Text.setText(Integer.toString(progress));
            mProgress4=progress;
        }
    };
}
