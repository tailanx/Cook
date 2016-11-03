package com.taijielan.cookbook.model.impl;

import android.content.Context;
import android.util.Log;

import com.taijielan.cookbook.bmobbean.VedioBmobBean;
import com.taijielan.cookbook.listener.BannerDataListener;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/31 18 28
 * @修改者 admin
 * @修改日期 2016/10/31 18 28
 * @修改内容
 */

public class Vediomodel implements IVedioModle {
    private BmobQuery bmobQuery;
    private Context context;

    public Vediomodel(Context context) {
        this.context = context;
        bmobQuery = new BmobQuery("VedioBmobBean");
    }

    @Override
    public void getVedioData(int pageSize, int skipSize,BannerDataListener<List<VedioBmobBean>> listener) {
        bmobQuery.setLimit(pageSize);
        bmobQuery.setSkip(skipSize);
        bmobQuery.findObjects(context, new FindListener<VedioBmobBean>() {
            @Override
            public void onSuccess(List<VedioBmobBean> list) {
                listener.sucess(list);
            }
            @Override
            public void onError(int i, String s) {
            }
        });
    }
}
