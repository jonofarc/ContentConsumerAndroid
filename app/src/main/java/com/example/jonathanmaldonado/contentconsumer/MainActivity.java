package com.example.jonathanmaldonado.contentconsumer;

import android.content.ContentProviderClient;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName()+"_TAG";

    TextView resultTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTV = (TextView) findViewById(R.id.result_tv);
        resultTV.setText("OK we start!");

        try {
            Uri uri = Uri.parse("content://com.example.jonathanmaldonado.w5d3_ex01.DataBase/genre");
            ContentProviderClient contentProviderClient = getContentResolver().acquireContentProviderClient(uri);
            Cursor cursor = contentProviderClient.query(uri, null, null, null, null, null);







            Log.d(TAG, "onCreate: URI --> " + uri + " REACHED PERFECT !!!!! ");
            resultTV.setText(cursor.toString());
        }
        catch (Exception e){
            resultTV.setText(e.toString());
        }


    }
}
