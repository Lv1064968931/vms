package com.lvlin.vms.biz;

import com.lvlin.vms.entity.VaccineFunction;

import java.util.List;

public interface VaccineFunctionBiz {
    //插入一条疫苗功能信息
    void add(VaccineFunction vaccineFunction);
    //批量删除
    void removemany(Integer[] ids);
    //根据id查询一条信息
    VaccineFunction get(int id);
    //查询所有的信息
    List<VaccineFunction> getAll();
}
