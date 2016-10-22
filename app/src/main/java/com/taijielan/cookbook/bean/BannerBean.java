package com.taijielan.cookbook.bean;

import java.io.Serializable;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/18 17 38
 * @修改者 admin
 * @修改日期 2016/10/18 17 38
 * @修改内容
 */

public class BannerBean implements Serializable {
    private String image;
    private String title;
    private String imageUrl;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
