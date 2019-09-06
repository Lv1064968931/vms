package com.lvlin.vms.controller;

import com.lvlin.vms.biz.EnvironmentBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller("environmentController")
@RequestMapping("/environment")
public class EnvironmentController {
    @Autowired
    private EnvironmentBiz environmentBiz;
    @RequestMapping("/environment_list")
    public String environmentList(Map<String, Object> map){
        map.put("environmentlist",environmentBiz.getAll());
        return "environment_list";
    }
}
