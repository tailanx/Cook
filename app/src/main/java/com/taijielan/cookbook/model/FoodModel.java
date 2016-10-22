package com.taijielan.cookbook.model;

import com.taijielan.cookbook.api.IApi;
import com.taijielan.cookbook.base.u.MySubScribe;
import com.taijielan.cookbook.base.u.ParseUrl;
import com.taijielan.cookbook.bean.BannerBean;
import com.taijielan.cookbook.bean.CookBean;
import com.taijielan.cookbook.listener.BannerDataListener;
import com.taijielan.cookbook.model.impl.IFoodModel;

import java.util.List;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/18 17 54
 * @修改者 admin
 * @修改日期 2016/10/18 17 54
 * @修改内容
 */

public class FoodModel implements IFoodModel {

    @Inject
    protected IApi api;

    @Inject
    public FoodModel() {
    }

    @Override
    public void getBannerList(BannerDataListener listener) {
        if (null != api) {
            api.getSliderShowFood().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map(s -> ParseUrl.getBanneBean(s))
                    .subscribe(new MySubScribe<List<BannerBean>>() {
                        @Override
                        public void onNext(List<BannerBean> o) {
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

    /***
     * 获取更新和加载更多
     *
     * @param listener
     */

    @Override
    public void getCookUpData(String type, int page, int lm, BannerDataListener listener) {
        if (null != api) {
//            ParamUtil paramUtil = new ParamUtil();
//            paramUtil.addParams("sortby", type);
//            paramUtil.addParams("page", Integer.toString(page));
//            paramUtil.addParams("lm", Integer.toString(pageSize));
            api.getLoadMoreDate(type,page,lm).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                    .map(s ->
                    ParseUrl.getLoadMore(s)).subscribe(new MySubScribe<List<CookBean>>() {
                        @Override
                        public void onNext(List<CookBean> o) {
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
