package com.taijielan.cookbook.model.impl;

import com.taijielan.cookbook.listener.BannerDataListener;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/18 17 55
 * @修改者 admin
 * @修改日期 2016/10/18 17 55
 * @修改内容
 */
public interface IFoodModel {
    void getBannerList(BannerDataListener listener);

    void getCookUpData(String type, int page, int lm, BannerDataListener listener);
}
