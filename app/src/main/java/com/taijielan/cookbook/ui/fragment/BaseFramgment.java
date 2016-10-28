package com.taijielan.cookbook.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lidroid.xutils.ViewUtils;
import com.taijielan.cookbook.CookApplication;
import com.taijielan.cookbook.model.FoodModel;

import javax.inject.Inject;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/17 17 58
 * @修改者 admin
 * @修改日期 2016/10/17 17 58
 * @修改内容
 */

public abstract class BaseFramgment extends Fragment {
    @Inject
    protected LayoutInflater inflater;
    @Inject
    protected FoodModel foodModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getResourceView(), container, false);
        ((CookApplication) getActivity().getApplication()).getCookComponent().inject(this);
        ViewUtils.inject(this, view);
        initView();
        return view;
    }


    public void startActivity(Class<?> s) {
        Intent intent = new Intent(getActivity(), s);
        startActivity(intent);
    }

    public abstract int getResourceView();

    public abstract void initView();

}
