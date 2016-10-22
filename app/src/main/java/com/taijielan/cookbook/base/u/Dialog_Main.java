package com.taijielan.cookbook.base.u;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

/**
 * 目前用于清空缓存弹窗
 * <p>
 * Description:自定义Dialog（参数传入Dialog样式文件，Dialog布局文件）
 *
 * @author 　　　门前大桥下 ❀
 */
public class Dialog_Main extends Dialog {

    private View view;

    /**
     * 自定义主题及布局的构造方法
     *
     * @param context
     * @param theme
     */
    public Dialog_Main(Context context, int theme, View view) {
        super(context, theme);
        this.view = view;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(view);
    }
}