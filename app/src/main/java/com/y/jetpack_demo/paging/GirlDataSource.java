package com.y.jetpack_demo.paging;

import androidx.annotation.NonNull;
import androidx.paging.PositionalDataSource;

import com.y.jetpack_demo.R;
import com.y.jetpack_demo.viewmodel.Girl;

import java.util.ArrayList;
import java.util.List;

/**
 * DataSource:顾名思义，数据源，获取数据是通过它实现的。
 * 官方文档上，实现的是ItemKeyedDataSource,而我这里实现的是PositionalDataSource
 */
public class GirlDataSource extends PositionalDataSource<Girl> {
    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<Girl> callback) {
        callback.onResult(loadData(),0,100);
    }

    @Override
    public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<Girl> callback) {
        callback.onResult(loadData());
    }


    public List<Girl> loadData() {
        List<Girl> data = new ArrayList<>();
        data.add(new Girl(R.drawable.f1, "1星", "*"));
        data.add(new Girl(R.drawable.f2, "2星", "**"));
        data.add(new Girl(R.drawable.f3, "3星", "***"));
        data.add(new Girl(R.drawable.f4, "4星", "****"));
        data.add(new Girl(R.drawable.f5, "5星", "*****"));
        data.add(new Girl(R.drawable.f6, "6星", "******"));
        data.add(new Girl(R.drawable.f7, "7星", "*******"));
        data.add(new Girl(R.drawable.f8, "8星", "********"));
        data.add(new Girl(R.drawable.f9, "9星", "*********"));
        data.add(new Girl(R.drawable.f10, "10星", "**********"));
        return data;
    }
}
