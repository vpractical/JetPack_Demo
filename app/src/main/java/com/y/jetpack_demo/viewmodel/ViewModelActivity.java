package com.y.jetpack_demo.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.y.jetpack_demo.R;

import java.util.List;

public class ViewModelActivity extends AppCompatActivity {

    public static void start(Context context){
        Intent intent = new Intent(context, ViewModelActivity.class);
        context.startActivity(intent);
    }

    Button button;

    ListView listView;
    GirlAdapter adapter;
    List<Girl> data;

    GirlViewModel girlViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewmodel);

        getLifecycle().addObserver(new LifecycleObserver2());

        //调用系统API初始化ViewModel
        girlViewModel = ViewModelProviders.of(this).get(GirlViewModel.class);
        data = GirlViewModel.loadData();
        girlViewModel.getData().observe(this, girls -> {
            data.clear();
            data.addAll(girls);
            adapter.notifyDataSetChanged();
        });

        listView=findViewById(R.id.listview);
        listView.setAdapter(adapter =new GirlAdapter(ViewModelActivity.this,data));

        button = findViewById(R.id.btn1);
        button.setOnClickListener(view -> girlViewModel.changeValue(1,999));
    }

}
