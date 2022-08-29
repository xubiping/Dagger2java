package com.test.app.dagger2java.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.test.app.dagger2java.R;
import com.test.app.dagger2java.component.DaggerFirstScopeComponent;
import com.test.app.dagger2java.module.FirstScopeModule;
import com.test.app.dagger2java.object.Student;

import javax.inject.Inject;

/**
 * 参考网站：https://blog.csdn.net/qq_32534441/article/details/105124679
 */
public class FirstScopeActivity extends AppCompatActivity {

    String TAG = getClass().getName();
    //注入后直接用
    @Inject
    Student student1;
    @Inject
    Student student2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_scope_first);
        setTitle("FirstScopeActivity");
        DaggerFirstScopeComponent.builder()
                .firstScopeModule(new FirstScopeModule(this))
                .build()
                .inject(this);

        TextView tv_content = findViewById(R.id.tv_content);
        tv_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpActivity();
            }
        });
        Log.d(TAG,"student1 hashcode:"+student1.hashCode());
        Log.d(TAG,"student1 hashcode:"+student1.hashCode());
    }

    public void jumpActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}