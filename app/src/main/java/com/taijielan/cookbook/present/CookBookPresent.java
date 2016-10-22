package com.taijielan.cookbook.present;

import com.taijielan.cookbook.bean.BannerBean;
import com.taijielan.cookbook.bean.CookBean;
import com.taijielan.cookbook.listener.BannerDataListener;
import com.taijielan.cookbook.model.FoodModel;
import com.taijielan.cookbook.ui.view.ICookBookFragment;

import java.util.List;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/18 17 52
 * @修改者 admin
 * @修改日期 2016/10/18 17 52
 * @修改内容
 */

public class CookBookPresent {
    private ICookBookFragment iCookBookFragment;
    private FoodModel foodModel;

    public CookBookPresent(ICookBookFragment f, FoodModel foodModel) {
        this.iCookBookFragment = f;
        this.foodModel = foodModel;
    }

    public void getBannerData() {
        if (null != foodModel) {
            foodModel.getBannerList(new BannerDataListener<List<BannerBean>>() {
                @Override
                public void sucess(List<BannerBean> o) {
                    if (null != iCookBookFragment) {
                        iCookBookFragment.getBannerData(o);
                    }
                }

                @Override
                public void falid(Throwable e) {

                }
            });
        }
    }

    /***
     * 刷新数据
     */
    public void getRefrshData(String type, int page, int lm) {
        if (null != foodModel) {
            foodModel.getCookUpData(type, page, lm, new BannerDataListener<List<CookBean>>() {
                @Override
                public void sucess(List<CookBean> o) {
                    iCookBookFragment.refreshData(o);
                }

                @Override
                public void falid(Throwable e) {

                }
            });
        }
    }

    /**
     * 加载更多
     */
    public void getLoadMoreData(String type, int page, int lm) {
        if (null != foodModel) {
            foodModel.getCookUpData(type, page, lm, new BannerDataListener<List<CookBean>>() {
                @Override
                public void sucess(List<CookBean> o) {
                    iCookBookFragment.loadMoreData(o);
                }

                @Override
                public void falid(Throwable e) {

                }
            });
        }
    }


}
