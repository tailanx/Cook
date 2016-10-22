package com.taijielan.cookbook.ui.fragment;

import com.taijielan.cookbook.R;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/18 10 06
 * @修改者 admin
 * @修改日期 2016/10/18 10 06
 * @修改内容
 */

public class FriendFragment extends BaseFramgment {

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

    }
}
