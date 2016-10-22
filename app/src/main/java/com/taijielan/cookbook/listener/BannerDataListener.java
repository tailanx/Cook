package com.taijielan.cookbook.listener;

import com.taijielan.cookbook.bean.BannerBean;

import java.util.List;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/19 15 46
 * @修改者 admin
 * @修改日期 2016/10/19 15 46
 * @修改内容
 */

public interface BannerDataListener<T> {
    void sucess(T o);

    void falid(Throwable e);
}
