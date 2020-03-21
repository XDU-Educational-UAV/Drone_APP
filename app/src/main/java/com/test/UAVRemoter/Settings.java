package com.test.UAVRemoter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Set;

public class Settings extends Activity {

    private String[] data= { "Help","License","Data Log"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        final ArrayAdapter<String> adapter =new ArrayAdapter<String>(
                Settings.this, android.R.layout.simple_list_item_1,data);
        ListView listView =(ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        Intent intent1=new Intent();
                        intent1.setClass(Settings.this,Help.class);
                        Settings.this.startActivity(intent1);
                        break;
                    case 1:
                        Intent intent2 = new Intent();
                        intent2.setClass(Settings.this,License.class);
                        Settings.this.startActivity(intent2);
                        break;
                    case 2:
                        Intent intent3 = new Intent();
                        intent3.setClass(Settings.this,logData.class);
                        Settings.this.startActivity(intent3);
                }
            }
        });
    }
}
