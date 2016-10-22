package com.taijielan.cookbook.base.u;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;


/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/9/26 14 14
 * @修改者 admin
 * @修改日期 2016/9/26 14 14
 * @修改内容
 */

public class MyFragmentViewPager extends FragmentPagerAdapter {
    private List<Fragment> list;

    public MyFragmentViewPager(FragmentManager fm, List<Fragment> f) {
        super(fm);
        this.list = f;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return null == list ? 0 : list.size();
    }
}
