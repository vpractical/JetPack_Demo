package com.y.jetpack_demo.paging;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

import com.y.jetpack_demo.viewmodel.Girl;

public class GirlDataSourceFactory extends DataSource.Factory<Integer, Girl> {

    private MutableLiveData<GirlDataSource> liveData = new MutableLiveData<>();

    @Override
    public DataSource<Integer, Girl> create() {
        GirlDataSource dataSource = new GirlDataSource();
        liveData.postValue(dataSource);
        return dataSource;
    }
}
