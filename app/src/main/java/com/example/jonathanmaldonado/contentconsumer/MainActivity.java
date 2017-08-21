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
            Uri uri = Uri.parse("content://com.example.jonathanmaldonado.w5d3_ex01.DataBase/movie");
            ContentProviderClient contentProviderClient = getContentResolver().acquireContentProviderClient(uri);
            Cursor cursor = contentProviderClient.query(uri, null, null, null, null, null);





            String newMessage="Start: \n";
            while (cursor.moveToNext()){

                newMessage +="Movie: \n";
                long entryID =cursor.getLong(cursor.getColumnIndexOrThrow("_ID"));
                String entryTitle=cursor.getString(cursor.getColumnIndexOrThrow("name"));
                String entrydate=cursor.getString(cursor.getColumnIndexOrThrow("date"));

                newMessage += "Note id: "+ entryID+ " Title: "+ entryTitle+ " Date "+entrydate+"\n";
               // newMessage +=  "Title: "+ entryTitle+ " Date "+entrydate+"\n";
            }

            resultTV.setText("");
            resultTV.setText(newMessage);

            Log.d(TAG, "onCreate URI:" + uri + " ");
           // resultTV.setText(cursor.toString());
        }
        catch (Exception e){
            resultTV.setText(e.toString());
        }


    }
}
