package com.y.jetpack_demo.paging;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.y.jetpack_demo.viewmodel.Girl;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * PagedList: 数据源获取的数据最终靠PagedList来承载。
 * 对于PagedList,我们可以这样来理解，它就是一页数据的集合。
 * 每请求一页，就是新的一个PagedList对象。
 */
public class GirlViewModel2 extends ViewModel {
    private Executor mExecutor = Executors.newSingleThreadExecutor();

    //通过Config 设置PageList 从Datasource 加载数据的方式。
    private PagedList.Config mPagingConfig = new PagedList.Config.Builder()
            .setInitialLoadSizeHint(10)//设置首次加载的数量；
            .setPageSize(10)//设置每一页加载的数量；
            .setPrefetchDistance(1)//设置距离最后还有多少个item时加载下一页；
            .setEnablePlaceholders(true)//表示是否设置null占位符；
            .build();

    private DataSource.Factory<Integer, Girl> mGirlDataSourceFactory =
            new GirlDataSourceFactory();

    private LiveData<PagedList<Girl>> girls = new LivePagedListBuilder<>(mGirlDataSourceFactory, mPagingConfig)
            .setFetchExecutor(mExecutor)//设置Executor执行器的线程。
            .build();
//    private LiveData<PagedList<Girl>> girls = new LivePagedListBuilder<>(mGirlDataSourceFactory, 10).build();

    //定义一个对象,相当于一个用来存放数据的仓库
    //进入secActivity后，点击按钮改变数据，返回在进入时还原.定义为static后，不还原
    //ViewModelProviders.of(this).get(GirlViewModel2.class)初始化时，传入of的act，fm
    //ViewModel的生命周期等于this，定义为static时则更长，所以不能持有context对象

    public LiveData<PagedList<Girl>> getData() {
        return girls;
    }



    /**
     * 数据刷新方法
     * 由于利用了MutableLiveData机制，concertList能响应数据变化。
     */
    public void invalidateDataSource() {
        PagedList<Girl> pagedList = girls.getValue();
        if (pagedList != null){
            pagedList.getDataSource().invalidate();
        }
    }


}
