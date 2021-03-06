package com.taijielan.cookbook.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.taijielan.cookbook.R;
import com.taijielan.cookbook.adapter.SearchDetailAdapter;
import com.taijielan.cookbook.baes.view.TaijielanEditView;
import com.taijielan.cookbook.bean.SearchBean;
import com.taijielan.cookbook.present.SearchPresent;
import com.taijielan.cookbook.ui.view.ISearchDataActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 作者  admin
 * @类名 搜索商品
 * @实现的主要功能
 * @创建日期 2016/10/21 18 34
 * @修改者 admin
 * @修改日期 2016/10/21 18 34
 * @修改内容
 */

public class SearchFoodActivity extends BaseActivity implements ISearchDataActivity, TaijielanEditView.SearchCallBack, TaijielanEditView.OnEditViewClick {

    @ViewInject(R.id.tev_seach)
    private TaijielanEditView taijielanEditView;
    @ViewInject(R.id.ll_history_data)
    private LinearLayout linearLayoutSearchHis;
    @ViewInject(R.id.rv_detail)
    private RecyclerView linearLayoutSearchDetail;
    private SearchPresent searchPresent;
    private SearchDetailAdapter searchDetailAdapter;
    private List<SearchBean.TngouEntity> list;


    @Override
    public int getView() {
        return R.layout.activity_search_food;
    }

    @Override
    public void initView() {
        ViewUtils.inject(this);
        searchPresent = new SearchPresent(this, searchModel);
        taijielanEditView.setSearchCallBack(this);
        taijielanEditView.setOnEditViewClick(this);
        list = new ArrayList<>();
        searchDetailAdapter = new SearchDetailAdapter(this, list);
        linearLayoutSearchDetail.setAdapter(searchDetailAdapter);
        linearLayoutSearchDetail.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    public void searchData(Object searchBeen) {
        taijielanEditView.setHintText(taijielanEditView.getContent());
        SearchBean s = (SearchBean) searchBeen;
        linearLayoutSearchHis.setVisibility(View.GONE);
        linearLayoutSearchDetail.setVisibility(View.VISIBLE);
        list.clear();
        list.addAll(s.getTngou());
        searchDetailAdapter.notifyDataSetChanged();
    }

    @Override
    public void error() {

    }

    @Override
    public void onClick(String s) {
        if (null != searchPresent) {
            searchPresent.getSearchData(s);
        }
    }

    @Override
    public void onEditViewClick() {
        if (!linearLayoutSearchHis.isShown()) {
            taijielanEditView.setShowCusor();
            linearLayoutSearchHis.setVisibility(View.VISIBLE);
            linearLayoutSearchDetail.setVisibility(View.GONE);
        }
    }
}
