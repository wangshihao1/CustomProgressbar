package com.bawei.wangshihao0107.bean;

import java.util.List;

public class RightBean {


    /**
     * msg : 获取子分类成功
     * code : 0
     * data : [{"cid":"6","list":[{"icon":"http://120.27.23.105/images/icon.png","name":"连衣裙","pcid":18,"pscid":112},{"icon":"http://120.27.23.105/images/icon.png","name":"性感连衣裙","pcid":18,"pscid":113},{"icon":"http://120.27.23.105/images/icon.png","name":"蕾丝连衣裙","pcid":18,"pscid":114},{"icon":"http://120.27.23.105/images/icon.png","name":"长袖连衣裙","pcid":18,"pscid":115},{"icon":"http://120.27.23.105/images/icon.png","name":"吊带连衣裙","pcid":18,"pscid":116},{"icon":"http://120.27.23.105/images/icon.png","name":"一字肩","pcid":18,"pscid":117},{"icon":"http://120.27.23.105/images/icon.png","name":"半身裙","pcid":18,"pscid":118}],"name":"裙装","pcid":"18"},{"cid":"6","list":[{"icon":"http://120.27.23.105/images/icon.png","name":"针织衫","pcid":19,"pscid":119},{"icon":"http://120.27.23.105/images/icon.png","name":"卫衣","pcid":19,"pscid":120},{"icon":"http://120.27.23.105/images/icon.png","name":"T恤","pcid":19,"pscid":121},{"icon":"http://120.27.23.105/images/icon.png","name":"短外套","pcid":19,"pscid":122},{"icon":"http://120.27.23.105/images/icon.png","name":"风衣","pcid":19,"pscid":123},{"icon":"http://120.27.23.105/images/icon.png","name":"百搭衬衫","pcid":19,"pscid":124},{"icon":"http://120.27.23.105/images/icon.png","name":"打底衫","pcid":19,"pscid":125},{"icon":"http://120.27.23.105/images/icon.png","name":"羽绒服","pcid":19,"pscid":126},{"icon":"http://120.27.23.105/images/icon.png","name":"小西装","pcid":19,"pscid":127}],"name":"上装","pcid":"19"},{"cid":"6","list":[{"icon":"http://120.27.23.105/images/icon.png","name":"牛仔裤","pcid":20,"pscid":128},{"icon":"http://120.27.23.105/images/icon.png","name":"休闲裤","pcid":20,"pscid":129},{"icon":"http://120.27.23.105/images/icon.png","name":"哈伦裤","pcid":20,"pscid":130},{"icon":"http://120.27.23.105/images/icon.png","name":"阔腿裤","pcid":20,"pscid":131},{"icon":"http://120.27.23.105/images/icon.png","name":"喇叭裤","pcid":20,"pscid":132},{"icon":"http://120.27.23.105/images/icon.png","name":"铅笔裤","pcid":20,"pscid":133},{"icon":"http://120.27.23.105/images/icon.png","name":"背带裤","pcid":20,"pscid":134},{"icon":"http://120.27.23.105/images/icon.png","name":"破洞牛仔裤","pcid":20,"pscid":135}],"name":"下装","pcid":"20"}]
     */

    public String msg;
    public String code;
    public List<DataBean> data;



    public static class DataBean {
        /**
         * cid : 6
         * list : [{"icon":"http://120.27.23.105/images/icon.png","name":"连衣裙","pcid":18,"pscid":112},{"icon":"http://120.27.23.105/images/icon.png","name":"性感连衣裙","pcid":18,"pscid":113},{"icon":"http://120.27.23.105/images/icon.png","name":"蕾丝连衣裙","pcid":18,"pscid":114},{"icon":"http://120.27.23.105/images/icon.png","name":"长袖连衣裙","pcid":18,"pscid":115},{"icon":"http://120.27.23.105/images/icon.png","name":"吊带连衣裙","pcid":18,"pscid":116},{"icon":"http://120.27.23.105/images/icon.png","name":"一字肩","pcid":18,"pscid":117},{"icon":"http://120.27.23.105/images/icon.png","name":"半身裙","pcid":18,"pscid":118}]
         * name : 裙装
         * pcid : 18
         */


        public String name;
        public String pcid;
        public List<ChildData> list;

        public class ChildData {
            public String icon;
            public String name;
        }
    }



}
