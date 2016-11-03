package com.taijielan.cookbook.model.impl;

import com.taijielan.cookbook.bean.DetailCookBean;
import com.taijielan.cookbook.listener.BannerDataListener;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/24 18 11
 * @修改者 admin
 * @修改日期 2016/10/24 18 11
 * @修改内容
 */

public interface ISearchDetail {
    void getDetailData(int id, BannerDataListener<DetailCookBean> beanBannerDataListener);
}
