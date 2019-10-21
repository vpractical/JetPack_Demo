package com.y.jetpack_demo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.y.jetpack_demo.navigation.NavigationActivity;
import com.y.jetpack_demo.paging.PagingActivity;
import com.y.jetpack_demo.viewmodel.LifecycleObserver2;
import com.y.jetpack_demo.viewmodel.ViewModelActivity;
import com.y.jetpack_demo.workmanager.WorkManagerActivity;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getLifecycle().addObserver(new LifecycleObserver2());

        findViewById(R.id.btn1).setOnClickListener(view -> ViewModelActivity.start(MainActivity.this));

        findViewById(R.id.btn2).setOnClickListener(view -> WorkManagerActivity.Companion.start(MainActivity.this));
        findViewById(R.id.btn3).setOnClickListener(view -> PagingActivity.start(MainActivity.this));

        findViewById(R.id.btn4).setOnClickListener(view -> NavigationActivity.start(MainActivity.this));

    }

}
