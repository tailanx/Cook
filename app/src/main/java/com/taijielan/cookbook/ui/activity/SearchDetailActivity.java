package com.taijielan.cookbook.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.taijielan.cookbook.R;
import com.taijielan.cookbook.base.u.Blur;
import com.taijielan.cookbook.base.u.PicassoImageView;
import com.taijielan.cookbook.bean.DetailCookBean;
import com.taijielan.cookbook.bean.SearchBean;
import com.taijielan.cookbook.present.SearchDetailPresent;
import com.taijielan.cookbook.ui.view.ISearchDeatilActivity;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/24 16 25
 * @修改者 admin
 * @修改日期 2016/10/24 16 25
 * @修改内容
 */

public class SearchDetailActivity extends BaseActivity implements ISearchDeatilActivity {

    @ViewInject(R.id.ctl_view)
    private CollapsingToolbarLayout collapsingToolbarLayout;
    @ViewInject(R.id.tl_bar)
    private Toolbar toolbar;
    @ViewInject(R.id.iv_cook_bg)
    private ImageView ivBg;
    @ViewInject(R.id.iv_cook)
    private PicassoImageView ivCook;
    @ViewInject(R.id.tv_title)
    private TextView tvTitle;
    @ViewInject(R.id.tv_keyword)
    private TextView tvKeyWord;
    @ViewInject(R.id.tv_count)
    private TextView tvCount;
    @ViewInject(R.id.tv_fav)
    private TextView tvFav;
    @ViewInject(R.id.tv_messagea)
    private TextView tvMsg;


    private SearchDetailPresent searchDetailPresent;
    private SearchBean.TngouEntity searchBean;

    private DetailCookBean detailCookBean;


    public static Intent getIntent(Context context, SearchBean.TngouEntity searchBean) {
        Intent intent = new Intent(context, SearchDetailActivity.class);
        intent.putExtra("bean", searchBean);
        return intent;
    }

    @Override
    public int getView() {
        return R.layout.activity_searchdetail;
    }

    @Override
    public void initView() {
        searchBean = (SearchBean.TngouEntity) getIntent().getSerializableExtra("bean");
        ViewUtils.inject(this);
        searchDetailPresent = new SearchDetailPresent(this, searchDeatilModel);
        if (null != searchBean) {
            searchDetailPresent.getDetail(Integer.toString(searchBean.getId()));
            collapsingToolbarLayout.setTitle(searchBean.getFood());
            collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.color_b1));
            ivCook.setImageUrl("http://tnfs.tngou.net/image" + searchBean.getImg(), 0, 0);
            Picasso.with(this).load("http://tnfs.tngou.net/image" + searchBean.getImg()).into(ivBg, new Callback() {
                @Override
                public void onSuccess() {
                    BitmapDrawable drawable = (BitmapDrawable) ivBg.getDrawable();
                    Bitmap bitmap = drawable.getBitmap();
                    ivBg.setImageBitmap(Blur.apply(bitmap));
                }

                @Override
                public void onError() {

                }
            });
        }
        setSupportActionBar(toolbar);
    }

    @Override
    public void cookDetail(DetailCookBean bean) {
        this.detailCookBean = bean;
        if (!TextUtils.isEmpty(bean.getFood())) {
            tvTitle.setText(bean.getFood());
        }
        if (!TextUtils.isEmpty(bean.getKeywords())) {
            tvKeyWord.setText(bean.getKeywords());
        }
        tvCount.setText(bean.getCount() + getString(R.string.search_count));
        tvFav.setText(bean.getFcount() + getString(R.string.search_fav));
        if(!TextUtils.isEmpty(bean.getMessage())){
            tvMsg.setText(Html.fromHtml(bean.getMessage()));
        }
    }

    @Override
    public void error() {

    }
}
