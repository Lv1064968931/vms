package com.lvlin.vms.biz.Impl;

import com.lvlin.vms.biz.UserBiz;
import com.lvlin.vms.dao.UserDao;
import com.lvlin.vms.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userBiz")
public class UserBizImpl implements UserBiz {

    @Autowired
    private UserDao userDao;

    //注册
    public void register(User user) {

        userDao.insert(user);
    }
    //登录
    public User login(String account, String password) {
        User user = userDao.select(account);
        if(user!=null&&user.getPassword().equals(password)&&user.getType().equals("admin")){
            return user;
        }else {
            return null;
        }
    }
    //客户端登录方法
    public User clientLogin(String account, String password) {
        User user = userDao.select(account);
        if(user!=null&&user.getPassword().equals(password)&&user.getType().equals("ordinary")){
            return user;
        }else {
            return null;
        }
    }

    //修改密码
    public void changePassword(User user) {
        userDao.update(user);
    }
    //通过账号查询用户
    public User selectByAccount(String account){
        return userDao.select(account);
    }
    //查询所有用户
    public List<User> getAll() {
        return userDao.selectAll();
    }

    public void add(User user) {
        userDao.insert(user);
    }

    public void remove(String account) {
        userDao.delete(account);
    }

    public void removemany(String[] accounts) {
        userDao.deleteList(accounts);
    }
}
