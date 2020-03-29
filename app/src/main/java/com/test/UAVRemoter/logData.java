package com.test.UAVRemoter;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Vector;

public class logData extends Dialog{
    private ImageView img_back;
    private Context context;
    private TextView dataText;
    private Vector<StringBuilder> mdata=new Vector<>();

    public void SetData(Vector<StringBuilder> data)
    {
        mdata=data;
    }

    public logData(Context context, int theme) {
        super(context, theme);
        this.context=context;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.dialog_log_data);
        initview();
    }

    private void initview() {

        img_back=(ImageView) findViewById(R.id.close);
        dataText=(TextView)findViewById(R.id.TextLogData);
        for(StringBuilder stringBuilder : mdata)
            dataText.append(stringBuilder);
        dataText.setMovementMethod(ScrollingMovementMethod.getInstance());
        img_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                logData.this.dismiss();
            }
        });
    }
}

