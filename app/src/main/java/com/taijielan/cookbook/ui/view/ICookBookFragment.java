package com.taijielan.cookbook.ui.view;

import com.taijielan.cookbook.bean.BannerBean;
import com.taijielan.cookbook.bean.CookBean;
import com.taijielan.cookbook.bean.FoodGeneralItem;

import java.util.List;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/18 17 36
 * @修改者 admin
 * @修改日期 2016/10/18 17 36
 * @修改内容
 */

public interface ICookBookFragment {
    //获取banner数据
    void getBannerData(List<BannerBean> bannerList);

    //下拉刷新
    void refreshData(List<CookBean> foodGeneralItems);

    //加载更多
    void loadMoreData(List<CookBean> loadMoreList);


}
