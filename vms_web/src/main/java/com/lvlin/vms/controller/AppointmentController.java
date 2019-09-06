package com.lvlin.vms.controller;

import com.alibaba.fastjson.JSONObject;
import com.lvlin.vms.biz.AppointmentBiz;
import com.lvlin.vms.entity.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;

@Controller("appointmentController")
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentBiz appointmentBiz;
    //查询所有的预约信息
    @RequestMapping("/list")
    public String vaccineList(Map<String,Object> map){
        map.put("appointmentlist",appointmentBiz.getAll());
        return "appointment_list";
    }
    //客户端预约方法
    @RequestMapping(value = "/client_appointment",method = RequestMethod.POST)
    public void clientRegister(HttpServletResponse response, String name, String phoneNum, String vaccineName, String location)throws IOException {
        Appointment appointment = new Appointment();
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
//        Appointment appointment3=appointmentBiz.getByName(name);

            appointment.setName(name);
            appointment.setPhoneNum(phoneNum);
            appointment.setVaccineName(vaccineName);
            appointment.setLocation(location);

            try {
                appointmentBiz.add(appointment);
                json.put("status", "1");
            } catch (Exception e) {
                json.put("status", "0");
                System.out.println(name);
                e.printStackTrace();
            }
            out.write(json.toString());
            out.flush();
            out.close();

    }
    //客户端通过接种人姓名查询预约信息
    @RequestMapping(value = "/client_selectByname",method = RequestMethod.POST)
    public void clientSelectByname(HttpServletResponse response,String name)throws IOException{
        Appointment appointment = appointmentBiz.getByName(name);
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        if(appointment!=null){
            out.write(JSONObject.toJSONString(appointment));
            out.flush();
            out.close();
        }else{
            json.put("status","0");
            out.write(json.toString());
            out.flush();
            out.close();
        }
    }
    //客户端通过接种人姓名删除一条预约信息
    @RequestMapping(value = "/client_removeByName",method = RequestMethod.POST)
    public void clientDeleteByName(HttpServletResponse response,String name)throws IOException{
        Appointment appointment = appointmentBiz.getByName(name);
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        if(appointment!=null){
        appointmentBiz.removeByName(name);
        json.put("status","1");
        }else {
            json.put("status","0");
        }
        out.write(json.toString());
        out.flush();;
        out.close();
    }

    //修改预约信息
    @RequestMapping("/to_update")
    public String toUpdate(int id,Map<String,Object> map){
        map.put("appointment",appointmentBiz.get(id));
        return "appointment_update";
    }
    @RequestMapping("/update")
    public String update(Appointment appointment){
        appointmentBiz.edit(appointment);
        return "redirect:list";
    }
    //删除一条预约信息
    @RequestMapping("/remove")
    public String remove(int id){
        appointmentBiz.remove(id);
        return "redirect:list";
    }
    //批量删除预约信息
    @RequestMapping("/remove_many")
    @ResponseBody
    public String removeMany(Integer[] ids){
        try{
            appointmentBiz.removemany(ids);
        }catch (Exception e){
            return "error";
        }
        return "ok";
    }
}
