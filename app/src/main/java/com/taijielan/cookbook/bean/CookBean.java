package com.taijielan.cookbook.bean;

import java.io.Serializable;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/21 10 32
 * @修改者 admin
 * @修改日期 2016/10/21 10 32
 * @修改内容
 */

public class CookBean implements Serializable {
    /**
     * 图片跳转的地址
     */
    private String herf;
    /**
     * 食品的名字
     */
    private String title;

    /**
     * 图片的地址
     */
    private String img;


    /**
     * srouce
     */
    private String source;

    /**
     * 评论人气
     */
    private String strOther;

    /**
     * 分几步
     */
    private String strStep;

    /**
     * 味道
     */
    private String strSmell;

    public String getHerf() {
        return herf;
    }

    public void setHerf(String herf) {
        this.herf = herf;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getStrOther() {
        return strOther;
    }

    public void setStrOther(String strOther) {
        this.strOther = strOther;
    }

    public String getStrStep() {
        return strStep;
    }

    public void setStrStep(String strStep) {
        this.strStep = strStep;
    }

    public String getStrSmell() {
        return strSmell;
    }

    public void setStrSmell(String strSmell) {
        this.strSmell = strSmell;
    }
}
