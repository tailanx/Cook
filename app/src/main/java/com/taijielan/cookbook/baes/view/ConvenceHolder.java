package com.taijielan.cookbook.baes.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.squareup.picasso.Picasso;
import com.taijielan.cookbook.R;
import com.taijielan.cookbook.bean.BannerBean;

import javax.inject.Inject;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/19 18 04
 * @修改者 admin
 * @修改日期 2016/10/19 18 04
 * @修改内容
 */

public class ConvenceHolder implements Holder<BannerBean> {
    private ImageView ivImage;
    private TextView tvContent;

    @Override
    public View createView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_convenience_banner, null);
        ivImage = (ImageView) view.findViewById(R.id.iv_banner_view);
        tvContent = (TextView) view.findViewById(R.id.tv_banner_title);
        ivImage.setScaleType(ImageView.ScaleType.FIT_XY);
        return view;
    }

    @Override
    public void UpdateUI(Context context, int position, BannerBean data) {
        if (!TextUtils.isEmpty(data.getImage())) {
            Picasso.with(context).load(data.getImage()).into(ivImage);
        }
        if (!TextUtils.isEmpty(data.getTitle())) {
            tvContent.setText(data.getTitle());
        }
    }
}
