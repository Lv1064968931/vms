package com.lvlin.vms.controller;

import com.lvlin.vms.biz.VaccineEnvironmentBiz;
import com.lvlin.vms.entity.VaccineEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller("vaccineEnvironmentController")
@RequestMapping("/vaccine_environment")
public class VaccineEnvironmentController {
    @Autowired
    private VaccineEnvironmentBiz vaccineEnvironmentBiz;
    //查询所有的疫苗环境信息
    @RequestMapping("/list")
    public String vaccineEnvironmentList(Map<String,Object> map){
        map.put("vaccine_environmentlist",vaccineEnvironmentBiz.getAll());
        return "vaccine_environment_list";
    }
    //添加一条疫苗环境信息
    @RequestMapping("/to_add")
    public String toAdd(Map<String,Object> map){
        map.put("vaccine_environment",new VaccineEnvironment());
        return "vaccine_environment_add";
    }
    @RequestMapping("/add")
    public String add(VaccineEnvironment vaccineEnvironment){
        vaccineEnvironmentBiz.add(vaccineEnvironment);
        return "redirect:list";
    }
    //修改疫苗环境信息
    @RequestMapping("/to_update")
    public String toUpdate(int id,Map<String,Object> map){
        map.put("vaccine_environment",vaccineEnvironmentBiz.get(id));
        return "vaccine_environment_update";
    }
    @RequestMapping("/update")
    public String update(VaccineEnvironment vaccineEnvironment){
        vaccineEnvironmentBiz.edit(vaccineEnvironment);
        return "redirect:list";
    }
    //删除一条疫苗环境信息
    @RequestMapping("/remove")
    public String remove(int id){
        vaccineEnvironmentBiz.remove(id);
        return "redirect:list";
    }
    //批量删除疫苗环境信息
    @RequestMapping("/remove_many")
    @ResponseBody
    public String removeMany(Integer[] ids){
        try{
            vaccineEnvironmentBiz.removemany(ids);
        }catch (Exception e){
            return "error";
        }
        return "ok";
    }
}
