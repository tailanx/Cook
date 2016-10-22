package com.taijielan.cookbook.base.u;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.taijielan.cookbook.R;


/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/21 18 10
 * @修改者 admin
 * @修改日期 2016/10/21 18 10
 * @修改内容
 */

public class PicassoImageView extends ImageView {
    private boolean isAttach;
    private String url;
    private int width;
    private int height;

    public PicassoImageView(Context context) {
        super(context);
    }

    public PicassoImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PicassoImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        isAttach = true;
        setImageUrl(url, width, height);
    }

    public void setImageUrl(String url, int width, int height) {
        if (!TextUtils.isEmpty(url)) {
            this.width = width;
            this.height = height;
            this.url = url;
            if (0 != width) {
                Picasso.with(getContext()).load(url).placeholder(R.drawable.picasso_hold_pic).resize(width, width).centerCrop().into(this);
            } else {
                Picasso.with(getContext()).load(url).fit().into(this);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Drawable drawable = getDrawable();
                drawable.mutate().setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                clearFilter();
                break;
        }
        return super.onTouchEvent(event);
    }

    public void reset() {
        clearFilter();
    }

    private void clearFilter() {
        Drawable drawable = getDrawable();
        if (null != drawable) {
            drawable.clearColorFilter();
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Picasso.with(getContext()).cancelRequest(this);
        isAttach = false;
        setImageDrawable(null);
    }
}
