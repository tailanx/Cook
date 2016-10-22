package com.taijielan.cookbook.baes.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.taijielan.cookbook.R;


/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/21 18 51
 * @修改者 admin
 * @修改日期 2016/10/21 18 51
 * @修改内容
 */

public class TaijielanEditView extends RelativeLayout {
    private int hintText;
    private int rightIcon;

    public TaijielanEditView(Context context) {
        this(context, null);
    }

    public TaijielanEditView(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public TaijielanEditView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.customeditview);
        hintText = array.getResourceId(R.styleable.customeditview_hinttext, 0);
        rightIcon = array.getResourceId(R.styleable.customeditview_righticon, 0);
        array.recycle();
        initView(context);
    }
    private void initView(Context contxt){
        View view = LayoutInflater.from(contxt).inflate(R.layout.)
    }
}
