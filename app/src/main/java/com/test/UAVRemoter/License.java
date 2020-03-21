package com.test.UAVRemoter;

import android.app.Activity;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;

public class License extends Activity {

    private TextView textViewId;
    private TextView textViewLicense;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_license);
        textViewId=(TextView)findViewById(R.id.LicenseId);
        textViewLicense=(TextView)findViewById(R.id.textLicense);
        InputStream input=getResources().openRawResource(R.raw.license);
        Reader reader=new InputStreamReader(input);
        StringBuffer stringBuffer=new StringBuffer();
        char b[]=new char[1024];
        int len=-1;
        try {
            while ((len = reader.read(b))!= -1){
                stringBuffer.append(b);
                reader.close();
            }
        }catch ( IOException e){
            e.printStackTrace();
        }
        String stringLicense=stringBuffer.toString();
        Log.i("License",stringLicense);
        textViewLicense.setMovementMethod(ScrollingMovementMethod.getInstance());
        textViewLicense.setText(stringLicense);
    }
}
