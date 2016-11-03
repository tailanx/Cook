package com.taijielan.cookbook.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.taijielan.cookbook.R;
import com.taijielan.cookbook.base.u.PicassoImageView;
import com.taijielan.cookbook.bmobbean.VedioBmobBean;
import com.taijielan.cookbook.ui.activity.VedioActivity;

import java.util.List;


/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/11/1 17 58
 * @修改者 admin
 * @修改日期 2016/11/1 17 58
 * @修改内容
 */

public class VedioAdapter extends RecyclerView.Adapter<VedioAdapter.MyVedioHolder> {

    private List<VedioBmobBean> list;

    private Context context;

    public VedioAdapter(Context context, List<VedioBmobBean> l) {
        this.list = l;
        this.context = context;
    }

    @Override
    public MyVedioHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyVedioHolder hold = new MyVedioHolder(LayoutInflater.from(context).inflate(R.layout.item_vedio, parent, false));
        return hold;
    }

    @Override
    public void onBindViewHolder(MyVedioHolder holder, int position) {
        VedioBmobBean vedioBmobBean = list.get(position);
        if (null != vedioBmobBean) {
            if (!TextUtils.isEmpty(vedioBmobBean.getStrPic())) {
                holder.ivContent.setImageUrl(vedioBmobBean.getStrPic(), 0, 0);
            }
            holder.tvTitle.setText(vedioBmobBean.getName());
        }
        holder.reContent.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    break;
                case MotionEvent.ACTION_CANCEL:
                case MotionEvent.ACTION_UP:
                    holder.ivContent.reset();
                    break;

            }
            return false;
        });

        holder.reContent.setOnClickListener(v -> {
            context.startActivity(VedioActivity.getIntent(context, vedioBmobBean));
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyVedioHolder extends RecyclerView.ViewHolder {
        @ViewInject(R.id.re_content)
        private RelativeLayout reContent;
        @ViewInject(R.id.tv_title)
        private TextView tvTitle;
        @ViewInject(R.id.iv_content)
        private PicassoImageView ivContent;

        public MyVedioHolder(View itemView) {
            super(itemView);
            ViewUtils.inject(this, itemView);
        }
    }
}
