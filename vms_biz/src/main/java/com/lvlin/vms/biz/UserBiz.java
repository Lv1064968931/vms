package com.lvlin.vms.biz;

import com.lvlin.vms.entity.User;

import java.util.List;

public interface UserBiz {
    //注册方法
    void register(User user);
    //登录方法
    User login(String account,String password);
    //客户端登录方法
    User clientLogin(String account,String password);
    //修改密码
    void changePassword(User user);
    //通过账号查询一条用户信息
    User selectByAccount(String account);
    //查询所有用户
    List<User> getAll();
    //添加一个用户
    void add(User user);
    //删除一个用户
    void remove(String account);
    //批量删除
    void removemany(String[] accounts);
}
