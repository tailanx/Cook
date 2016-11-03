package com.taijielan.cookbook.model;

import com.taijielan.cookbook.api.SearchApi;
import com.taijielan.cookbook.base.u.MySubScribe;
import com.taijielan.cookbook.bean.SearchBean;
import com.taijielan.cookbook.listener.BannerDataListener;
import com.taijielan.cookbook.model.impl.ISearchModel;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/22 16 49
 * @修改者 admin
 * @修改日期 2016/10/22 16 49
 * @修改内容
 */

public class SearchModel implements ISearchModel {

    @Inject
    protected SearchApi searchApi;

    @Inject
    public SearchModel() {

    }

    @Override
    public void getSearchByName(String name, BannerDataListener listener) {
        if (null != searchApi) {
            searchApi.searchByName(name).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new MySubScribe<SearchBean>() {
                @Override
                public void onNext(SearchBean o) {
                    super.onNext(o);
                    listener.sucess(o);
                }

                @Override
                public void onError(Throwable e) {
                    super.onError(e);
                    listener.falid(e);
                }
            });
        }

    }
}
