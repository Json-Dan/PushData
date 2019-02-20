package com.json.push;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.avos.avoscloud.GetCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class LoadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        loadData();
    }

    private void loadData() {

        AVQuery<AVObject> avQuery = new AVQuery<>("Test");
        avQuery.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> avObjects, AVException avException) {
                Log.e("TEST_DATA", avObjects.toString());
            }
        });
        avQuery.getInBackground("5c6d6b00303f39004767042b", new GetCallback<AVObject>() {
            @Override
            public void done(AVObject avObject, AVException e) {
                if (avObject != null) {

                    try {
                        Log.e("TEST_DATA", avObject.toString());
                        JSONObject request = avObject.getJSONObject("request");
                        Log.e("TEST_DATA", request.getString("url"));

                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                } else {
                    Log.e("TEST_DATA", "this is data null");
                }
            }
        });

    }
}
