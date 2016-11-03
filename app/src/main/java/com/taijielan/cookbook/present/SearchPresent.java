package com.taijielan.cookbook.present;

import com.taijielan.cookbook.bean.SearchBean;
import com.taijielan.cookbook.listener.BannerDataListener;
import com.taijielan.cookbook.model.SearchModel;
import com.taijielan.cookbook.ui.activity.SearchFoodActivity;
import com.taijielan.cookbook.ui.view.ISearchDataActivity;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/22 16 47
 * @修改者 admin
 * @修改日期 2016/10/22 16 47
 * @修改内容
 */

public class SearchPresent {

    private ISearchDataActivity<SearchBean> searchDataActivity;
    private SearchModel iSearchModel;

    public SearchPresent(SearchFoodActivity activity, SearchModel i) {
        this.searchDataActivity = activity;
        this.iSearchModel = i;

    }

    /***
     * 根据名字查看类型
     *
     * @param name
     */
    public void getSearchData(String name) {
        if (null != iSearchModel) {
            iSearchModel.getSearchByName(name, new BannerDataListener<SearchBean>() {
                @Override
                public void sucess(SearchBean o) {
                    searchDataActivity.searchData(o);
                }

                @Override
                public void falid(Throwable e) {
                    searchDataActivity.error();
                }
            });
        }

    }
}
