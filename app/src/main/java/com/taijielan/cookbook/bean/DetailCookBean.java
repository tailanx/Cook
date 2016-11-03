package com.taijielan.cookbook.bean;

import java.io.Serializable;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/24 18 08
 * @修改者 admin
 * @修改日期 2016/10/24 18 08
 * @修改内容
 */

public class DetailCookBean implements Serializable {


    /**
     * count : 28
     * description : 材料杭椒五花肉葱姜蒜鸡精味精一品鲜料酒做法五花肉煸炒至干倒出放入葱姜蒜煸炒倒入杭椒煸炒至熟倒入煸好的五花肉放鸡精味精一品鲜料酒翻炒半分钟即可
     * fcount : 0
     * food : 杭椒,五花肉,葱姜蒜,鸡精,味精,一品鲜,料酒
     * id : 87392
     * images :
     * img : /cook/080403/8293ecc0923a667883a1b58b6b1af894.jpg
     * keywords : 五花肉 味精 一品 姜蒜 鸡精
     * message : <h2>材料 </h2><hr>
     * <p>杭椒 五花肉 葱姜蒜 鸡精味精 一品鲜 料酒</p>   <h2>做法 </h2><hr>
     * <p>五花肉煸炒至干倒出放入葱姜蒜煸炒倒入杭椒煸炒至熟倒入煸好的五花肉放鸡精味精一品鲜料酒翻炒半分钟即可</p>
     * name : 小抄肉
     * rcount : 0
     * status : true
     * url : http://www.tngou.net/cook/show/87392
     */

    private int count;
    private String description;
    private int fcount;
    private String food;
    private int id;
    private String images;
    private String img;
    private String keywords;
    private String message;
    private String name;
    private int rcount;
    private boolean status;
    private String url;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFcount() {
        return fcount;
    }

    public void setFcount(int fcount) {
        this.fcount = fcount;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRcount() {
        return rcount;
    }

    public void setRcount(int rcount) {
        this.rcount = rcount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
