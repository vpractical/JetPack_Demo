package com.y.jetpack_demo.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.y.jetpack_demo.R;

import java.util.ArrayList;
import java.util.List;

public class GirlViewModel extends ViewModel {

    //定义一个对象,相当于一个用来存放数据的仓库
    //进入secActivity后，点击按钮改变数据，返回在进入时还原.定义为static后，不还原
    //ViewModelProviders.of(this).get(GirlViewModel2.class)初始化时，传入of的act，fm
    //ViewModel的生命周期等于this，定义为static时则更长，所以不能持有context对象
    private static MutableLiveData<List<Girl>> liveData;

    //用于获取数据
    public LiveData<List<Girl>> getData() {
        if (liveData == null) {
            liveData = new MutableLiveData<>();
            liveData.postValue(loadData());
        }
        return liveData;
    }

    public static List<Girl> loadData() {
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

    //提供一个方法来改变数据
    public void changeValue(int item, int i) {
        List<Girl> value = liveData.getValue();
        value.get(item).like = (i + "");
        liveData.setValue(value);

    }


}
