package com.test.UAVRemoter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.method.ScrollingMovementMethod;
import android.text.style.SuperscriptSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Help extends Dialog {
    private ImageView img_back;
    private Context context;
    private TextView helpText;


    public Help(Context context, int theme) {
        super(context, theme);

        this.context=context;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.dialog_help);
        initview();
    }
    private void initview() {

        img_back=(ImageView) findViewById(R.id.close);
        helpText=(TextView)findViewById(R.id.textHelp);
        InputStream input=context.getResources().openRawResource(R.raw.help);
        Reader reader=new InputStreamReader(input);
        StringBuffer stringBuffer=new StringBuffer();
        char b[]=new char[1024];
        int len=-1;
        try {
            while ((len = reader.read(b))!= -1){
                stringBuffer.append(b);
                reader.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        String stringHelp=stringBuffer.toString();
        helpText.setMovementMethod(ScrollingMovementMethod.getInstance());
        helpText.setText(stringHelp);
        img_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Help.this.dismiss();
            }
        });
    }


}

