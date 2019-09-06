package com.lvlin.vms.biz;

import com.lvlin.vms.entity.Appointment;

import java.util.List;

public interface AppointmentBiz {
    //插入一条预约信息
    void add(Appointment appointment);
    //通过id查询一条信息
    Appointment get(int id);
    //通过名字查询一条信息
    Appointment getByName(String name);
    //修改预约信息
    void edit(Appointment appointment);
    //通过姓名修改一条预约信息
    void removeByName(String name);
    //删除一条信息
    void remove(int id);
    //批量删除预约信息
    void removemany(Integer[] ids);
    //查询所有预约信息
    List<Appointment> getAll();
}
