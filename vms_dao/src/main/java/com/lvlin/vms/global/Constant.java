package com.lvlin.vms.global;

import java.util.ArrayList;
import java.util.List;

public class Constant {
    public static List<String> getItems(){
        List<String>list = new ArrayList<String>();
        list.add("admin");
        list.add("ordinary");
        return list;
    }
    public static List<String> getStatus(){
        List<String>list = new ArrayList<String>();
        list.add("正常");
        list.add("过期");
        return list;
    }

}
