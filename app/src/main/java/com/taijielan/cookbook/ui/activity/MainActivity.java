package com.taijielan.cookbook.ui.activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnRadioGroupCheckedChange;
import com.taijielan.cookbook.R;
import com.taijielan.cookbook.ui.fragment.CookBookFragment;
import com.taijielan.cookbook.ui.fragment.FriendFragment;
import com.taijielan.cookbook.ui.fragment.MyPannelFragment;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    @ViewInject(R.id.ll_root)
    private LinearLayout linearLayoutRoot;
    @ViewInject(R.id.rg_group)
    private RadioGroup mainRadio;
    private FragmentManager fragmentManager;

    private long lasttime;
    private final int DISTIME = 1000;
    private CookBookFragment cookBookFragment = null;
    private FriendFragment friendFragment = null;
    private MyPannelFragment myPannelFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public int getView() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        ViewUtils.inject(this);
        initview();
    }

    private void initview() {
        fragmentManager = getSupportFragmentManager();
        onCheckedChanged(mainRadio, R.id.rb_main);
    }

    /**
     * 先隐藏所有的  再对应的添加或者显示
     */

    @OnRadioGroupCheckedChange({R.id.rg_group})
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        int size = group.getChildCount();
        for (int i = 0; i < size; i++) {
            group.getChildAt(i).setSelected(false);
        }
        findViewById(checkedId).setSelected(true);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideView(transaction);
        switch (checkedId) {
            case R.id.rb_main:
                if (null != cookBookFragment) {
                    transaction.show(cookBookFragment);
                } else {
                    cookBookFragment = CookBookFragment.getInstance();
                    transaction.add(R.id.fl_main_content, cookBookFragment);
                }
                break;
            case R.id.rb_friend:
                if (null != friendFragment) {
                    transaction.show(friendFragment);
                } else {
                    friendFragment = FriendFragment.getInstance();
                    transaction.add(R.id.fl_main_content, friendFragment);
                }
                break;
            case R.id.rb_me:
                if (null != myPannelFragment) {
                    transaction.show(myPannelFragment);
                } else {
                    myPannelFragment = MyPannelFragment.getInstance();
                    transaction.add(R.id.fl_main_content, myPannelFragment);
                }
                break;
            default:
                break;
        }
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - lasttime > DISTIME) {
            Snackbar.make(linearLayoutRoot, getString(R.string.press_twice_exit), Snackbar.LENGTH_SHORT).setActionTextColor(getResources().getColor(R.color.color_b5)).setAction(getString(R.string.exit_directly),
                    v -> MainActivity.super.onBackPressed()).show();
        } else {
            moveTaskToBack(true);
        }
        lasttime = System.currentTimeMillis();
    }

    private void hideView(FragmentTransaction transaction) {
        if (null != cookBookFragment) {
            transaction.hide(cookBookFragment);
        }
        if (null != friendFragment) {
            transaction.hide(friendFragment);
        }
        if (null != myPannelFragment) {
            transaction.hide(myPannelFragment);
        }
    }
}
