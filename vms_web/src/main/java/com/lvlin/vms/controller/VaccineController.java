package com.lvlin.vms.controller;

import com.lvlin.vms.biz.VaccineBiz;
import com.lvlin.vms.entity.Vaccine;
import com.lvlin.vms.global.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller("vaccineController")
@RequestMapping("/vaccine")
public class VaccineController {
    @Autowired
    private VaccineBiz vaccineBiz;
    String Tmsg = "regular";
    //查询所有的疫苗信息
    @RequestMapping("/list")
    public String vaccineList(Map<String,Object> map,HttpSession session){
        map.put("vaccinelist",vaccineBiz.getAll());
        if(Tmsg.equals("regular")){
            session.setAttribute("warning","环境正常，无需调整");
        }else {
            switch (Tmsg) {
                case "1":
                    session.setAttribute("warning", "温度正常，光照过低，已自动调整，请检查疫苗是否失效");
                    break;
                case "2":
                    session.setAttribute("warning", "温度正常，光照过高，已自动调整，请检查疫苗是否失效");
                    break;
                case "4":
                    session.setAttribute("warning", "温度过高，光照正常，已自动调整，请检查疫苗是否失效");
                    break;
                case "5":
                    session.setAttribute("warning", "温度过高，光照过低，已自动调整，请检查疫苗是否失效");
                    break;
                case "6":
                    session.setAttribute("warning", "温度过高，光照过高，已自动调整，请检查疫苗是否失效");
                    break;
                case "8":
                    session.setAttribute("warning", "温度过低，光照正常，已自动调整，请检查疫苗是否失效");
                    break;
                case "9":
                    session.setAttribute("warning", "温度过低，光照过低，已自动调整，请检查疫苗是否失效");
                    break;
                case "10":
                    session.setAttribute("warning", "温度过低，光照过高，已自动调整，请检查疫苗是否失效");
                    break;

            }
        }
        return "vaccine_list";
    }
    //通过RFID编号查询一条疫苗信息
    @RequestMapping("/vaccine_rfid_msg")
    public String vaccine_Rfid(HttpSession session,String rfidSn,Map<String,Object> map){
        if(vaccineBiz.getByRfidSn(rfidSn)==null){
            session.setAttribute("rfid_warning","该卡对应的信息不存在，请保存后在查询！");
            return "rfid_warning";
        }
        map.put("vaccine_rfid",vaccineBiz.getByRfidSn(rfidSn));
        return "vaccine_rfid_msg";
    }
    //添加一条疫苗信息
    @RequestMapping("/to_add")
    public String toAdd(Map<String,Object> map){
        map.put("vaccine",new Vaccine());
        map.put("status", Constant.getStatus());
        return "vaccine_add";
    }
    @RequestMapping("/add")
    public String add(Vaccine vaccine){
        vaccineBiz.add(vaccine);
        return "redirect:list";
    }
    //修改疫苗信息
    @RequestMapping("/to_update")
    public String toUpdate(int id,Map<String,Object> map){
        map.put("status", Constant.getStatus());
        map.put("vaccine",vaccineBiz.get(id));
        return "vaccine_update";
    }
    @RequestMapping("/update")
    public String update(Vaccine vaccine){
        vaccineBiz.edit(vaccine);
        return "redirect:list";
    }
    //删除一条疫苗信息
    @RequestMapping("/remove")
    public String remove(int id){
        vaccineBiz.remove(id);
        return "redirect:list";
    }
    //批量删除疫苗信息
    @RequestMapping("/remove_many")
    @ResponseBody
    public String removeMany(Integer[] ids){
        try{
            vaccineBiz.removemany(ids);
        }catch (Exception e){
            return "error";
        }
        return "ok";
    }
    //环境变化警告
    @RequestMapping("/warning_msg")
    public void warningMsg(HttpServletResponse response, HttpSession session, String msg){
        if(msg!=null){
        Tmsg=msg;}
}
}
