package com.taijielan.cookbook.ui.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.lidroid.xutils.view.annotation.ViewInject;
import com.taijielan.cookbook.R;
import com.taijielan.cookbook.adapter.VedioAdapter;
import com.taijielan.cookbook.base.u.ViewUtil;
import com.taijielan.cookbook.bmobbean.VedioBmobBean;
import com.taijielan.cookbook.present.VedioPresent;
import com.taijielan.cookbook.ui.view.IFriendFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 作者  admin
 * @类名 视频
 * @实现的主要功能
 * @创建日期 2016/10/18 10 06
 * @修改者 admin
 * @修改日期 2016/10/18 10 06
 * @修改内容
 */

public class FriendFragment extends BaseFramgment implements SwipeRefreshLayout.OnRefreshListener, IFriendFragment {
    @ViewInject(R.id.srl_content)
    private SwipeRefreshLayout srlContent;
    @ViewInject(R.id.rev_vedio_content)

    private RecyclerView recyclerView;
    private VedioPresent vedioPresent;
    private int page = 0;
    private int pageSize = 10;
    private List<VedioBmobBean> list;
    private VedioAdapter vedioAdapter;
    private GridLayoutManager linearLayoutManager;
    private final int COLNUM = 1;

    public static FriendFragment getInstance() {
        FriendFragment friendFragment = new FriendFragment();
        return friendFragment;
    }

    @Override
    public int getResourceView() {
        return R.layout.fragment_friend;
    }

    @Override
    public void initView() {
        srlContent.setColorSchemeResources(R.color.recycler_color1, R.color.recycler_color2,
                R.color.recycler_color3, R.color.recycler_color4);
        srlContent.setOnRefreshListener(this);
        list = new ArrayList<>();
        vedioAdapter = new VedioAdapter(getContext(), list);
        linearLayoutManager = new GridLayoutManager(getActivity(), COLNUM);
        linearLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return COLNUM;
            }
        });
        linearLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        vedioPresent = new VedioPresent(this, getActivity());
        vedioPresent.getRefreshData(pageSize, pageSize * page);

        recyclerView.setAdapter(vedioAdapter);
        recyclerView.setOnScrollListener(new MyRecycleView());
    }

    @Override
    public void onRefresh() {
        page = 0;
        vedioPresent.getRefreshData(pageSize, pageSize * page);
    }

    public void loadMore() {
        page++;
        vedioPresent.getLoadMoreData(pageSize, pageSize * page);
    }

    @Override
    public void showDialog() {
        srlContent.post(() -> srlContent.setRefreshing(true));
    }

    @Override
    public void hideDialog() {
        srlContent.post(() -> srlContent.setRefreshing(false));
    }

    @Override
    public void getRefreshData(List<VedioBmobBean> vedioBmobBeanList) {
        list.clear();
        list.addAll(vedioBmobBeanList);
        vedioAdapter.notifyDataSetChanged();
    }

    @Override
    public void getLoadMoreData(List<VedioBmobBean> vedioBmobBeen) {
        if(null != vedioBmobBeen && !vedioBmobBeen.isEmpty()){
            list.addAll(vedioBmobBeen);
            vedioAdapter.notifyDataSetChanged();
        }else{
            ViewUtil.showView(getActivity(),getString(R.string.no_more_data));
        }
    }


    @Override
    public void error() {
    }

    class MyRecycleView extends RecyclerView.OnScrollListener {
        private int lastVisiItem;
        private int mScrollThreshold = ViewUtil.dipToPx(getActivity(), 1);

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            boolean isScroll = Math.abs(dy) > mScrollThreshold;

            if (isScroll) {

            }
            lastVisiItem = linearLayoutManager.findLastVisibleItemPosition();

            Log.e("okhttp", "" + linearLayoutManager.findFirstVisibleItemPosition());

        }

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisiItem + 1 == vedioAdapter.getItemCount()) {
                loadMore();
            }
        }
    }

}
