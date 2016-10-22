package com.taijielan.cookbook.base.u;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/9/18 14 50
 * @修改者 admin
 * @修改日期 2016/9/18 14 50
 * @修改内容
 */

public class ViewPagerAdapter extends PagerAdapter {
    private List<View> viewList;

    public ViewPagerAdapter(List<View> l) {
        this.viewList = l;
    }

    @Override
    public int getCount() {
        return null == viewList ? 0 : viewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewList.get(position));
        return viewList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewList.get(position));
    }
}
