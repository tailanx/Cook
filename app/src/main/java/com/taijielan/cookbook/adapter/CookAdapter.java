package com.taijielan.cookbook.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.taijielan.cookbook.R;
import com.taijielan.cookbook.base.u.PicassoImageView;
import com.taijielan.cookbook.base.u.ViewUtil;
import com.taijielan.cookbook.bean.CookBean;

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

public class CookAdapter extends MyBaseAdapter<CookBean> {

    private int width;

    public CookAdapter(Context context, List l) {
        super(context, l);
        width = ViewUtil.getDisplayMetrics(context).widthPixels - ViewUtil.dipToPx(context, 24);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (null == convertView) {
            convertView = layoutInflater.inflate(R.layout.adapter_cook, parent, false);
            holder = new ViewHolder();
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.imageView = (PicassoImageView) convertView.findViewById(R.id.iv_content);
        holder.tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
        holder.tvSmell = (TextView) convertView.findViewById(R.id.tv_smell);
        holder.tvStep = (TextView) convertView.findViewById(R.id.tv_step);
        holder.tvComment = (TextView) convertView.findViewById(R.id.tv_comment);
        holder.tvSoruce = (TextView) convertView.findViewById(R.id.tv_source);
        holder.reContent = (RelativeLayout) convertView.findViewById(R.id.re_content);
        ViewGroup.LayoutParams lp = holder.reContent.getLayoutParams();
        lp.width = width;
        lp.height = width;

        CookBean cookBean = list.get(position);
        if (null != cookBean) {
            if (!TextUtils.isEmpty(cookBean.getImg())) {
//                Picasso.with(context).load(cookBean.getImg()).placeholder(R.drawable.picasso_hold_pic).resize(width, width).centerCrop().into(holder.imageView);
                holder.imageView.setImageUrl(cookBean.getImg(), width, width);
                holder.imageView.setOnClickListener(v -> {
                    holder.imageView.clearColorFilter();
                });
            }
            if (!TextUtils.isEmpty(cookBean.getTitle())) {
                holder.tvTitle.setText(cookBean.getTitle());
            }
            if (!TextUtils.isEmpty(cookBean.getStrSmell())) {
                holder.tvSmell.setText(cookBean.getStrSmell());
            }
            if (!TextUtils.isEmpty(cookBean.getStrStep())) {
                holder.tvStep.setText(cookBean.getStrStep());
            }
            if (!TextUtils.isEmpty(cookBean.getStrOther())) {
                holder.tvComment.setText(cookBean.getStrOther());
            }
            if (!TextUtils.isEmpty(cookBean.getSource())) {
                holder.tvSoruce.setText(cookBean.getSource());
            }
        }
        return convertView;
    }

    class ViewHolder {
        private PicassoImageView imageView;
        private TextView tvTitle;
        private TextView tvSmell;
        private TextView tvStep;
        private TextView tvComment;
        private TextView tvSoruce;
        private RelativeLayout reContent;

    }
}
