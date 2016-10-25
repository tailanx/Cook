package com.taijielan.cookbook.baes.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.taijielan.cookbook.R;
import com.taijielan.cookbook.base.u.IsFullName;
import com.taijielan.cookbook.base.u.ViewUtil;


/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/21 18 51
 * @修改者 admin
 * @修改日期 2016/10/21 18 51
 * @修改内容
 */

public class TaijielanEditView extends RelativeLayout implements View.OnClickListener {
    private int hintText;
    private int rightIcon;
    @ViewInject(R.id.iv_delete)
    private ImageView ivDelete;
    @ViewInject(R.id.et_content)
    private EditText etView;
    private Context context;
    private SearchCallBack searchCallBack;
    private OnEditViewClick onEditViewClick;

    public void setHintText(String hintText) {
        etView.setText("");
        etView.setCursorVisible(false);
        etView.setHint(hintText);
    }

    public void setOnEditViewClick(OnEditViewClick onEditViewClick) {
        this.onEditViewClick = onEditViewClick;
    }

    public void setSearchCallBack(SearchCallBack searchCallBack) {
        this.searchCallBack = searchCallBack;
    }

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
        this.context = contxt;
        this.removeAllViews();
        View view = LayoutInflater.from(contxt).inflate(R.layout.custom_editview, null);
        ViewUtils.inject(this, view);
        if (0 != hintText) {
            etView.setHint(hintText);
        }
        etView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (0 == s.length()) {
                    ivDelete.setVisibility(View.GONE);
                } else {
                    ivDelete.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etView.setOnKeyListener((v, keyCode, event) -> {
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                ViewUtil.hideSoftInput(contxt, TaijielanEditView.this);
                seachClick();
            }
            return false;
        });
        this.addView(view);
    }

    @OnClick({R.id.iv_back, R.id.tv_search, R.id.iv_delete, R.id.et_content})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_delete:
                etView.setText("");
                break;
            case R.id.tv_search:
                seachClick();
                break;
            case R.id.iv_back:
                ((Activity) context).finish();
                break;
            case R.id.et_content:
                if(null != onEditViewClick){
                    onEditViewClick.onEditViewClick();
                }
                break;
            default:
                break;
        }
    }

    /**
     * 搜索事件
     */
    private void seachClick() {
        if (IsFullName.isNotNullSearch(context, etView.getText().toString().trim())) {
            if (null != searchCallBack) {
                searchCallBack.onClick(etView.getText().toString().trim());
            }
        }
    }

    public String getContent() {
        return etView.getText().toString();
    }

    public interface OnEditViewClick {
        void onEditViewClick();
    }

    public interface SearchCallBack {
        void onClick(String s);
    }

    public void setShowCusor(){
        if(null != etView && 0 != hintText){
            etView.setCursorVisible(true);
            etView.setHint(hintText);
        }
    }
}
