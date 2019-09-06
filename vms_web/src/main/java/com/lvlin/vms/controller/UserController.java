package com.lvlin.vms.controller;

import com.alibaba.fastjson.JSONObject;
import com.lvlin.vms.biz.UserBiz;
import com.lvlin.vms.entity.User;
import com.lvlin.vms.global.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("userController")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserBiz userBiz;
    //浏览器登录方法
    @RequestMapping("/to_login")
    public String toLogin(){
        return "login";
    }
    @RequestMapping("/login")
    public String Login(HttpSession session, @RequestParam String account, @RequestParam String password){
        User user = userBiz.login(account,password);
        if (user==null){
            session.setAttribute("error","登录失败，请检查账号或者密码是否正确！");
        }
        session.setAttribute("user",user);
        return "redirect:self";
    }
    //客户端登录方法
    @RequestMapping(value = "/client_login",method = RequestMethod.POST)
    public void clientLogin(HttpServletResponse response,String account,String password)throws IOException{
        User user = userBiz.clientLogin(account,password);
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        if(user==null){
            json.put("status","0");
        }else{
            json.put("status","1");
        }
        out.write(json.toString());
        out.flush();;
        out.close();
    }
    @RequestMapping("/self")
    public String self(){
        return "self";
    }
    //浏览器注册方法
    @RequestMapping("/to_register")
    public String toRegister(Map<String,Object> map){
        map.put("user",new User());
        map.put("type", Constant.getItems());
        return "register";
    }
    @RequestMapping("/register")
    public String register(User user){
        userBiz.register(user);
        return "redirect:to_login";
    }
    //客户端注册方法
    @RequestMapping(value = "/client_register",method = RequestMethod.POST)
    public void clientRegister(HttpServletResponse response,String account,String password,String type)throws IOException{
        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setType(type);
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        try{
            userBiz.register(user);
            json.put("status","1");
        } catch (Exception e) {
            json.put("status","0");
            e.printStackTrace();
        }
        out.write(json.toString());
        out.flush();;
        out.close();
    }
    //浏览器修改密码方法
    @RequestMapping("/to_change_password")
    public String toChangePassword(){
        return "change_password";
    }
    @RequestMapping("change_password")
    public String changePassword(HttpSession session,@RequestParam String old,@RequestParam String new1,@RequestParam String new2){
        User user = (User)session.getAttribute("user");
        if(user.getPassword().equals(old)){
            if(new1.equals(new2)){
                user.setPassword(new1);
                userBiz.changePassword(user);
                return "redirect:self";
            }
        }
        return "redirect:to_change_password";
    }
    //客户端修改密码方法
    @RequestMapping(value = "/client_change_password",method = RequestMethod.POST)
    public void clientChangePassword(HttpServletResponse response,String account,String old,String new1,String new2)throws IOException{
        User user = userBiz.selectByAccount(account);
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        if(user.getPassword().equals(old)){
            if(new1.equals(new2)){
                user.setPassword(new1);
                userBiz.changePassword(user);
                json.put("status","1");
            }else {
                json.put("status","0");
            }
        }else {
            json.put("status","0");
        }
        out.write(json.toString());
        out.flush();;
        out.close();
    }
    //退出
    @RequestMapping("/quit")
    public String quit(HttpSession session){
        session.setAttribute("employee",null);
        return "redirect:to_login";
    }
    //查询所有用户信息
    @RequestMapping("/user_list")
    public String userList(Map<String,Object> map){
        map.put("userlist",userBiz.getAll());
        return "user_list";
    }

    //添加一个用户
    @RequestMapping("/to_add")
    public String toAdd(Map<String,Object> map){
        map.put("user",new User());
        map.put("type", Constant.getItems());
        return "user_add";
    }
    @RequestMapping("/add")
    public String add(User user){
        userBiz.add(user);
        return "redirect:user_list";
    }

    //删除一个用户
    @RequestMapping("/remove")
    public String remove(String account){
        userBiz.remove(account);
        return "redirect:user_list";
    }
    //批量删除用户信息
    @RequestMapping("/remove_many")
    @ResponseBody
    public String removeMany(String[] accounts){
        try{
            userBiz.removemany(accounts);
        }catch (Exception e){
            return "error";
        }
        return "ok";
    }
}
