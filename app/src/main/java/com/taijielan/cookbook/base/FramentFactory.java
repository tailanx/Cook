package com.taijielan.cookbook.base;

import android.support.v4.app.Fragment;

import com.taijielan.cookbook.R;
import com.taijielan.cookbook.ui.fragment.CookBookFragment;
import com.taijielan.cookbook.ui.fragment.FriendFragment;
import com.taijielan.cookbook.ui.fragment.MyPannelFragment;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/18 10 42
 * @修改者 admin
 * @修改日期 2016/10/18 10 42
 * @修改内容
 */

public class FramentFactory {

    public static Fragment getInstanceByIndex(int index) {
        Fragment fragment = null;
        switch (index) {
            case R.id.rb_main:
                fragment = CookBookFragment.getInstance();
                break;
            case R.id.rb_friend:
                fragment = FriendFragment.getInstance();
                break;
            case R.id.rb_me:
                fragment = MyPannelFragment.getInstance();
                break;
            default:
                break;
        }
        return fragment;
    }

}
