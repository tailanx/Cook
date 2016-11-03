package com.taijielan.cookbook.ui.view;

import com.taijielan.cookbook.bmobbean.VedioBmobBean;

import java.util.List;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/31 18 23
 * @修改者 admin
 * @修改日期 2016/10/31 18 23
 * @修改内容
 */

public interface IFriendFragment {
    void showDialog();

    void hideDialog();

    void getRefreshData(List<VedioBmobBean> vedioBmobBeanList);

    void getLoadMoreData(List<VedioBmobBean> vedioBmobBeen);

    void error();
}
