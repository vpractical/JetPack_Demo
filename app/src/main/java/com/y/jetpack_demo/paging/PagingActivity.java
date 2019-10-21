package com.y.jetpack_demo.paging;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.y.jetpack_demo.R;
import com.y.jetpack_demo.util.L;

public class PagingActivity extends AppCompatActivity {

    public static void start(Context context){
        Intent intent = new Intent(context, PagingActivity.class);
        context.startActivity(intent);
    }

    private RecyclerView mRecyclerView;
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paging);
        mRecyclerView = findViewById(R.id.rv);
        adapter = new RecyclerAdapter();
        GirlViewModel2 girlViewModel = ViewModelProviders.of(this).get(GirlViewModel2.class);

        //将数据(既被观察者)订阅给观察者。
        girlViewModel.getData().observe(this, dataBeans -> {
            adapter.submitList(girlViewModel.getData().getValue());
            L.e("数据更新了");
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        mRecyclerView.setAdapter(adapter);
    }
}
