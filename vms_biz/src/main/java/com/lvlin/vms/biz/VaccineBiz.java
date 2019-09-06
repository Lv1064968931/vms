package com.lvlin.vms.biz;

import com.lvlin.vms.entity.Vaccine;

import java.util.List;

public interface VaccineBiz {
    //插入一条疫苗信息
    void add(Vaccine vaccine);
    //通过id查询一条信息
    Vaccine get(int id);
    //通过rfid卡号查询一条疫苗信息
    Vaccine getByRfidSn(String rfidSn);
    //修改疫苗信息
    void edit(Vaccine vaccine);
    //删除一条信息
    void remove(int id);
    //批量删除
    void removemany(Integer[] ids);
    //查询所有的信息
    List<Vaccine> getAll();
}
