package com.taijielan.cookbook.model.impl;

import com.taijielan.cookbook.listener.BannerDataListener;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/22 16 57
 * @修改者 admin
 * @修改日期 2016/10/22 16 57
 * @修改内容
 */

public interface ISearchModel {
    void getSearchByName(String name, BannerDataListener s);
}
