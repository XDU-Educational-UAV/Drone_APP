package com.test.UAVRemoter;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Help extends Activity {

    TextView helpId;
    TextView helpText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        helpId=(TextView)findViewById(R.id.HelpId);
        helpText=(TextView)findViewById(R.id.textHelp);
        InputStream input=getResources().openRawResource(R.raw.help);
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
    }
}
