package com.taijielan.cookbook.baes.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.taijielan.cookbook.R;

/**
 * @author 作者  admin
 * @类名 底部切换
 * @实现的主要功能
 * @创建日期 2016/10/17 14 21
 * @修改者 admin
 * @修改日期 2016/10/17 14 21
 * @修改内容
 */

public class TaijielanBottomView extends LinearLayout implements View.OnClickListener {
    private MyOnClickView onClickView;

    public void setOnClickView(MyOnClickView onClickView) {
        this.onClickView = onClickView;
    }

    public TaijielanBottomView(Context context) {
        this(context, null);
    }

    public TaijielanBottomView(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public TaijielanBottomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_bottom, null);
        view.findViewById(R.id.rb_main).setOnClickListener(this);
        view.findViewById(R.id.rb_friend).setOnClickListener(this);
        view.findViewById(R.id.rv_me).setOnClickListener(this);
        this.addView(view);
    }

    @Override
    public void onClick(View v) {
        if (null != onClickView) {
            onClickView.oncClick(v);
        }

    }

    public interface MyOnClickView {
        void oncClick(View view);
    }
}
