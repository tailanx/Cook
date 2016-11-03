package com.taijielan.cookbook.present;

import android.content.Context;

import com.taijielan.cookbook.bmobbean.VedioBmobBean;
import com.taijielan.cookbook.listener.BannerDataListener;
import com.taijielan.cookbook.model.impl.Vediomodel;
import com.taijielan.cookbook.ui.view.IFriendFragment;

import java.util.List;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/31 18 26
 * @修改者 admin
 * @修改日期 2016/10/31 18 26
 * @修改内容
 */

public class VedioPresent {
    private Context context;
    private IFriendFragment friendFragment;
    private Vediomodel vediomodel;

    public VedioPresent(IFriendFragment friendFragment, Context context) {
        this.friendFragment = friendFragment;
        this.context = context;
        this.vediomodel = new Vediomodel(context);
    }

    /**
     * 刷新
     *
     * @param pageSize
     * @param skipSize
     */
    public void getRefreshData(int pageSize, int skipSize) {
        friendFragment.showDialog();
        if (null != vediomodel) {
            vediomodel.getVedioData(pageSize, skipSize, new BannerDataListener<List<VedioBmobBean>>() {
                @Override
                public void sucess(List<VedioBmobBean> o) {
                    friendFragment.getRefreshData(o);
                    friendFragment.hideDialog();
                }

                @Override
                public void falid(Throwable e) {
                    friendFragment.error();
                    friendFragment.hideDialog();
                }
            });
        }
    }

    /**
     * 加载更多
     */
    public void getLoadMoreData(int pageSize, int skipSize) {
        friendFragment.showDialog();
        if (null != vediomodel) {
            vediomodel.getVedioData(pageSize, skipSize, new BannerDataListener<List<VedioBmobBean>>() {
                @Override
                public void sucess(List<VedioBmobBean> o) {
                    friendFragment.getLoadMoreData(o);
                    friendFragment.hideDialog();
                }

                @Override
                public void falid(Throwable e) {
                    friendFragment.error();
                    friendFragment.hideDialog();

                }
            });
        }

    }
}
