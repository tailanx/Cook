package com.taijielan.cookbook.ui.fragment;

import android.view.View;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.taijielan.cookbook.R;
import com.taijielan.cookbook.adapter.CookAdapter;
import com.taijielan.cookbook.baes.view.ConvenceHolder;
import com.taijielan.cookbook.bean.BannerBean;
import com.taijielan.cookbook.bean.CookBean;
import com.taijielan.cookbook.present.CookBookPresent;
import com.taijielan.cookbook.ui.activity.SearchFoodActivity;
import com.taijielan.cookbook.ui.view.ICookBookFragment;

import java.util.ArrayList;
import java.util.List;

import me.maxwin.view.XListView;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/17 18 01
 * @修改者 admin
 * @修改日期 2016/10/17 18 01
 * @修改内容
 */

public class CookBookFragment extends BaseFramgment implements ICookBookFragment, XListView.IXListViewListener, View.OnClickListener {
    @ViewInject(R.id.xlv_listview)
    private XListView xListView;
    @ViewInject(R.id.cb_banner)
    private ConvenientBanner<BannerBean> convenientBanner;
    private int[] res = new int[]{R.drawable.shopcart_red_dot_night, R.drawable.shopcart_red_dot};

    private CookBookPresent cookBookPresent;
    private List<CookBean> lists;
    private int page = 1;
    /**
     * 食品种类
     */
    private int lm = 2;
    /**
     * update 是更新 renqi 是最热
     */
    private final String COOK_TYPE = "update";
    private CookAdapter cookAdapter;


    public static CookBookFragment getInstance() {
        CookBookFragment cookBookFragment = new CookBookFragment();
        return cookBookFragment;
    }

    @Override
    public int getResourceView() {
        return R.layout.base_fragment;
    }

    @Override
    public void initView() {
        lists = new ArrayList<>();
        cookAdapter = new CookAdapter(getActivity(), lists);

        cookBookPresent = new CookBookPresent(this, foodModel);
        cookBookPresent.getBannerData();
        cookBookPresent.getRefrshData(COOK_TYPE, page, lm);
        View view = inflater.inflate(R.layout.view_banner, null);
        ViewUtils.inject(this, view);
        xListView.addHeaderView(view);
        xListView.setXListViewListener(this);
        xListView.setPullLoadEnable(true);
        xListView.setAdapter(cookAdapter);
    }

    @Override
    public void getBannerData(List<BannerBean> bannerList) {
        convenientBanner.setPageIndicator(res);
        convenientBanner.setPages(new CBViewHolderCreator<ConvenceHolder>() {
            @Override
            public ConvenceHolder createHolder() {
                return new ConvenceHolder();
            }
        }, bannerList);
    }

    @Override
    public void refreshData(List<CookBean> foodGeneralItems) {
        cookAdapter.refreshList(foodGeneralItems);
        xListView.stopRefresh();
    }

    @Override
    public void loadMoreData(List<CookBean> loadMoreList) {
        cookAdapter.appendList(loadMoreList);
        xListView.stopLoadMore();

    }

    @Override
    public void onRefresh() {
        page = 1;
        cookBookPresent.getRefrshData(COOK_TYPE, page, lm);
    }

    @Override
    public void onLoadMore() {
        page++;
        cookBookPresent.getLoadMoreData(COOK_TYPE, page, lm);

    }


    @Override
    public void onStart() {
        super.onStart();
        convenientBanner.startTurning(5000);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        convenientBanner.stopTurning();
    }

    @OnClick({R.id.re_search})
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.re_search) {
            startActivity(SearchFoodActivity.class);
        }

    }


}
