package com.taijielan.cookbook.present;

import com.taijielan.cookbook.bean.DetailCookBean;
import com.taijielan.cookbook.listener.BannerDataListener;
import com.taijielan.cookbook.model.SearchDeatilModel;
import com.taijielan.cookbook.ui.activity.SearchDetailActivity;
import com.taijielan.cookbook.ui.view.ISearchDeatilActivity;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/24 18 11
 * @修改者 admin
 * @修改日期 2016/10/24 18 11
 * @修改内容
 */

public class SearchDetailPresent {
    private SearchDeatilModel model;
    private ISearchDeatilActivity searchDetailActivity;

    public SearchDetailPresent(SearchDetailActivity searchDetailActivity, SearchDeatilModel searchDeatilModel) {
        this.searchDetailActivity = searchDetailActivity;
        this.model = searchDeatilModel;
    }

    public void getDetail(String id) {
        if (null != model) {
            model.getSearchByName(id, new BannerDataListener<DetailCookBean>() {
                @Override
                public void sucess(DetailCookBean o) {
                    searchDetailActivity.cookDetail(o);
                }

                @Override
                public void falid(Throwable e) {
                    searchDetailActivity.error();

                }
            });
        }
    }
}
