package com.lvlin.vms.controller;

import com.alibaba.fastjson.JSONObject;
import com.lvlin.vms.biz.VaccineFunctionBiz;
import com.lvlin.vms.entity.VaccineFunction;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@Controller("vaccineFunctionController")
@RequestMapping("/vaccine_function")
public class VaccineFunctionController {
   @Autowired
  private VaccineFunctionBiz vaccineFunctionBiz;
   //查询一条信息
    @RequestMapping("/detail")
    public String vaccineFunctionDetaill(int id,Map<String,Object> map){
        map.put("vaccine_function_detail",vaccineFunctionBiz.get(id));
        return "vaccine_function_detail";
    }
   //查询所有信息
   @RequestMapping("/list")
   public String vaccineFunctionList(Map<String,Object> map){
        map.put("vaccinefunctionlist",vaccineFunctionBiz.getAll());
        return "vaccine_function_list";
   }
   //客户端查询所有疫苗功能信息
    @RequestMapping(value = "/client_list",method = RequestMethod.POST)
    public void clientVaccineFunctionList(HttpServletResponse response)throws IOException {
        List<VaccineFunction> vaccineFunctions = vaccineFunctionBiz.getAll();
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.write(JSONObject.toJSONString(vaccineFunctions));
        out.flush();
        out.close();
    }
    //添加一条疫苗功能信息
    @RequestMapping("/to_add")
    public String toAdd(Map<String,Object> map){
        map.put("vaccine_function",new VaccineFunction());
        return "vaccine_function_add";
    }
    @RequestMapping("/add")
    public String add(VaccineFunction vaccineFunction){
        vaccineFunctionBiz.add(vaccineFunction);
        return "redirect:list";
    }
    //批量删除疫苗功能信息
    @RequestMapping("/remove_many")
    @ResponseBody
    public String removeMany(Integer[] ids){
        try{
            vaccineFunctionBiz.removemany(ids);
        }catch (Exception e){
            return "error";
        }
        return "ok";
    }
}
