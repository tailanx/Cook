package com.taijielan.cookbook.model;

import com.taijielan.cookbook.api.SearchApi;
import com.taijielan.cookbook.base.u.MySubScribe;
import com.taijielan.cookbook.bean.DetailCookBean;
import com.taijielan.cookbook.listener.BannerDataListener;
import com.taijielan.cookbook.model.impl.ISearchModel;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/24 18 13
 * @修改者 admin
 * @修改日期 2016/10/24 18 13
 * @修改内容
 */

public class SearchDeatilModel implements ISearchModel {
    @Inject
    protected SearchApi searchApi;

    @Inject
    public SearchDeatilModel() {
    }

    @Override
    public void getSearchByName(String id, BannerDataListener s) {
        if (null != searchApi) {
            searchApi.searchDeatail(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new MySubScribe<DetailCookBean>() {
                @Override
                public void onNext(DetailCookBean o) {
                    super.onNext(o);
                    s.sucess(o);
                }

                @Override
                public void onError(Throwable e) {
                    super.onError(e);
                    s.falid(e);
                }
            });
        }

    }
}
