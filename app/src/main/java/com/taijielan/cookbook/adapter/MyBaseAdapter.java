package com.taijielan.cookbook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/21 16 07
 * @修改者 admin
 * @修改日期 2016/10/21 16 07
 * @修改内容
 */

public abstract class MyBaseAdapter<T> extends BaseAdapter {

    protected Context context;
    protected List<T> list;
    protected LayoutInflater layoutInflater;

    public MyBaseAdapter(Context context, List<T> l) {
        this.context = context;
        this.list = l;
        layoutInflater  =LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return null == list ? 0 : list.size();
    }

    @Override
    public T getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public void appendList(List<T> l) {
        if (null != list) {
            list.addAll(l);
            this.notifyDataSetChanged();
        }
    }

    public void refreshList(List<T> l) {
        if (null != list) {
            list.clear();
            list.addAll(l);
            this.notifyDataSetChanged();
        }
    }

}
