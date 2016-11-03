package com.taijielan.cookbook.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.taijielan.cookbook.R;
import com.taijielan.cookbook.base.u.PicassoImageView;
import com.taijielan.cookbook.bean.SearchBean;
import com.taijielan.cookbook.ui.activity.SearchDetailActivity;

import java.util.List;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/22 18 39
 * @修改者 admin
 * @修改日期 2016/10/22 18 39
 * @修改内容
 */

public class SearchDetailAdapter extends RecyclerView.Adapter<SearchDetailAdapter.MyViewHold> {
    private Context context;
    private List<SearchBean.TngouEntity> searchBeens;

    public SearchDetailAdapter(Context context, List<SearchBean.TngouEntity> lists) {
        this.context = context;
        this.searchBeens = lists;
    }

    @Override
    public MyViewHold onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHold myViewHold = new MyViewHold(LayoutInflater.from(context).inflate(R.layout.adapter_search_detail, parent, false));
        return myViewHold;
    }

    @Override
    public void onBindViewHolder(MyViewHold holder, int position) {
        SearchBean.TngouEntity searchBean = searchBeens.get(position);
        if (!TextUtils.isEmpty(searchBean.getImg())) {
            holder.ivContent.setImageUrl("http://tnfs.tngou.net/image" + searchBean.getImg(), 0, 0);
        }
        if (!TextUtils.isEmpty(searchBean.getFood())) {
            holder.tvTitle.setText(searchBean.getFood());
        }
        if (!TextUtils.isEmpty(searchBean.getDescription())) {
            holder.tvDescription.setText(searchBean.getDescription());
        }
        if (!TextUtils.isEmpty(searchBean.getMessage())) {
            holder.tvKeyWord.setText(searchBean.getKeywords());
        }
        holder.tvCount.setText("访问次数：" + searchBean.getCount());
        holder.tvFav.setText("收藏数：" + searchBean.getFcount());
        holder.reContent.setOnClickListener(v -> context.startActivity(SearchDetailActivity.getIntent(context, searchBean)));

    }

    @Override
    public int getItemCount() {
        return searchBeens.size();
    }

    class MyViewHold extends RecyclerView.ViewHolder {
        @ViewInject(R.id.iv_content)
        PicassoImageView ivContent;
        @ViewInject(R.id.tv_title)
        TextView tvTitle;
        @ViewInject(R.id.tv_keyword)
        TextView tvKeyWord;
        @ViewInject(R.id.tv_desription)
        TextView tvDescription;
        @ViewInject(R.id.tv_count)
        TextView tvCount;
        @ViewInject(R.id.tv_fav)
        TextView tvFav;
        @ViewInject(R.id.re_content)
        RelativeLayout reContent;


        public MyViewHold(View itemView) {
            super(itemView);
            ViewUtils.inject(this, itemView);
        }
    }
}
