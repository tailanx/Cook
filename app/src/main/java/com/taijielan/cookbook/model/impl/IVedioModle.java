package com.taijielan.cookbook.model.impl;

import com.taijielan.cookbook.bmobbean.VedioBmobBean;
import com.taijielan.cookbook.listener.BannerDataListener;

import java.util.List;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/31 18 27
 * @修改者 admin
 * @修改日期 2016/10/31 18 27
 * @修改内容
 */

public interface IVedioModle {
    void getVedioData(int pageSize, int skipSize, BannerDataListener<List<VedioBmobBean>> listener);
}
