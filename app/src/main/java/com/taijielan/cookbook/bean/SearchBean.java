package com.taijielan.cookbook.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author 作者  admin
 * @类名
 * @实现的主要功能
 * @创建日期 2016/10/18 17 45
 * @修改者 admin
 * @修改日期 2016/10/18 17 45
 * @修改内容
 */

public class SearchBean implements Serializable {


    /**
     * status : true
     * tngou : [{"count":26,"description":"产品特点：螺肉鲜嫩，开胃爽口烹制要领：烹饪时放少许白醋，去除腥味产品说明：田螺素有\u201c盘中明珠\u201d的美誉，肉质丰腴细腻、味道鲜美，它富含蛋白蛋、维生素和人体必需的氨基酸和微量元素，是典型的高蛋白、低脂肪、高钙质的天然动物性保健食品","fcount":0,"food":"大田螺,香菇,指天椒,紫苏,辣,鲜露,胡椒粉,酱油,白醋,料酒","id":105599,"images":"","img":"/cook/default.jpg","keywords":"田螺 维生素 洞庭湖 大片 白醋 ","message":"<h2>材料<\/h2><hr/><p>洞庭湖野生大田螺，贡椒香菇100克，指天椒50克，紫苏10克，辣鲜露5克，胡椒粉5克，龙牌酱油5克、白醋5克、料酒10克<\/p><h2>做法<\/h2><hr/><p>1、将王栏树贡椒花甲预制菜自然解冻后拆包待用。<\/p><p>2、将田螺肉用酱油，料酒煸香。<\/p><p>3、放入佐料和大片田螺，炒熟即可。<\/p><p>产品特点：螺肉鲜嫩，开胃爽口<\/p><p>烹制要领： 烹饪时放少许白醋，去除腥味<\/p><p>产品说明：<\/p><p>田螺素有\u201c盘中明珠\u201d的美誉，肉质丰腴细腻、味道鲜美，它富含蛋白蛋、维生素和人体必需的氨基酸和微量元素，是典型的高蛋白、低脂肪、高钙质的天然动物性保健食品。<\/p><p>王栏树大片田螺是精选的洞庭湖大田螺，手工清洗、精挑细选，干净卫生、无沙而且肉质鲜嫩！螺肉含有丰富的维生素A、蛋白质、铁和钙，非常的适合肥胖症、高脂血症、冠心病、动脉硬化、脂肪肝者食用。<\/p>","name":"田螺","rcount":0}]
     */

    private boolean status;
    /**
     * count : 26
     * description : 产品特点：螺肉鲜嫩，开胃爽口烹制要领：烹饪时放少许白醋，去除腥味产品说明：田螺素有“盘中明珠”的美誉，肉质丰腴细腻、味道鲜美，它富含蛋白蛋、维生素和人体必需的氨基酸和微量元素，是典型的高蛋白、低脂肪、高钙质的天然动物性保健食品
     * fcount : 0
     * food : 大田螺,香菇,指天椒,紫苏,辣,鲜露,胡椒粉,酱油,白醋,料酒
     * id : 105599
     * images :
     * img : /cook/default.jpg
     * keywords : 田螺 维生素 洞庭湖 大片 白醋
     * message : <h2>材料</h2><hr/><p>洞庭湖野生大田螺，贡椒香菇100克，指天椒50克，紫苏10克，辣鲜露5克，胡椒粉5克，龙牌酱油5克、白醋5克、料酒10克</p><h2>做法</h2><hr/><p>1、将王栏树贡椒花甲预制菜自然解冻后拆包待用。</p><p>2、将田螺肉用酱油，料酒煸香。</p><p>3、放入佐料和大片田螺，炒熟即可。</p><p>产品特点：螺肉鲜嫩，开胃爽口</p><p>烹制要领： 烹饪时放少许白醋，去除腥味</p><p>产品说明：</p><p>田螺素有“盘中明珠”的美誉，肉质丰腴细腻、味道鲜美，它富含蛋白蛋、维生素和人体必需的氨基酸和微量元素，是典型的高蛋白、低脂肪、高钙质的天然动物性保健食品。</p><p>王栏树大片田螺是精选的洞庭湖大田螺，手工清洗、精挑细选，干净卫生、无沙而且肉质鲜嫩！螺肉含有丰富的维生素A、蛋白质、铁和钙，非常的适合肥胖症、高脂血症、冠心病、动脉硬化、脂肪肝者食用。</p>
     * name : 田螺
     * rcount : 0
     */

    private List<TngouEntity> tngou;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<TngouEntity> getTngou() {
        return tngou;
    }

    public void setTngou(List<TngouEntity> tngou) {
        this.tngou = tngou;
    }

    public static class TngouEntity implements Serializable {
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
    }
}
