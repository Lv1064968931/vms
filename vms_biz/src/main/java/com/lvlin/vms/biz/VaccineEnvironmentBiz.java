package com.lvlin.vms.biz;

import com.lvlin.vms.entity.VaccineEnvironment;

import java.util.List;

public interface VaccineEnvironmentBiz {
    //插入一条疫苗信息
    void add(VaccineEnvironment vaccineEnvironment);
    //通过id查询一条信息
    VaccineEnvironment get(int id);
    //修改疫苗信息
    void edit(VaccineEnvironment vaccineEnvironment);
    //删除一条信息
    void remove(int id);
    //批量删除疫苗环境信息
    void removemany(Integer[] ids);
    //查询所有疫苗环境信息
    List<VaccineEnvironment> getAll();
}
