package com.json.push;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.SaveCallback;
import com.json.push.bean.FormBean;

public class MainActivity extends AppCompatActivity {

    private EditText htmlUrl;
    private EditText uploadUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        htmlUrl = findViewById(R.id.editText);
        uploadUrl = findViewById(R.id.editText2);
    }

    private void pushData(final String html, String upload) {
        // 测试 SDK 是否正常工作的代码
        AVObject testObject = new AVObject("Test");
        testObject.put("form", new FormBean("baidu", "红姐图库"));
        testObject.put("request", new Request(false, html, upload));
        testObject.saveInBackground(new SaveCallback() {
            @Override
            public void done(AVException e) {
                if (e == null) {
                    show("添加成功");
                    htmlUrl.setText(null);
                    uploadUrl.setText(null);
                    Log.d("saved", "success!");
                }
            }
        });
    }

    public void load(View view) {
        startActivity(new Intent(MainActivity.this, LoadActivity.class));
    }

    public void submit(View view) {
        String html = htmlUrl.getText().toString().trim();
        String upload = uploadUrl.getText().toString().trim();

        if (TextUtils.isEmpty(html)) {
            show("需要H5展示地址");
            return;
        }
        if (TextUtils.isEmpty(upload)) {
            show("需要apk强更地址");
            return;
        }

        pushData(html, upload);

    }

    public void show(String content) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }
}
