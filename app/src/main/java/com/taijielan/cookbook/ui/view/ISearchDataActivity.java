package com.taijielan.cookbook.ui.view;

import com.taijielan.cookbook.bean.SearchBean;

import java.util.List;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/22 16 43
 * @修改者 admin
 * @修改日期 2016/10/22 16 43
 * @修改内容
 */

public interface ISearchDataActivity {
    void searchData(List<SearchBean> searchBeen);
    void error();

}
