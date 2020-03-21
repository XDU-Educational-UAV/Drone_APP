package com.test.UAVRemoter;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.PriorityQueue;
import java.util.Vector;
import java.util.concurrent.TimeoutException;

public class logData extends Activity {
    private TextView textViewId;
    private TextView textViewLogData;
    private Vector<StringBuilder> mdata=new Vector<>();

    public void SetData(Vector<StringBuilder> data)
    {
        mdata=data;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_data);
        textViewId=(TextView)findViewById(R.id.LogDataId);
        textViewLogData=(TextView)findViewById(R.id.TextLogData);
        for(StringBuilder stringBuilder : mdata)
            textViewLogData.append(stringBuilder);
        textViewLogData.setMovementMethod(ScrollingMovementMethod.getInstance());
    }
}
