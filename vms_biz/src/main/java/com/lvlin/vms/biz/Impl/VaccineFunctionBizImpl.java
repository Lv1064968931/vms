package com.lvlin.vms.biz.Impl;

import com.lvlin.vms.biz.VaccineFunctionBiz;
import com.lvlin.vms.dao.VaccineFunctionDao;
import com.lvlin.vms.entity.VaccineFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "vaccineFunctionBiz")
public class VaccineFunctionBizImpl implements VaccineFunctionBiz {
    @Autowired
    private VaccineFunctionDao vaccineFunctionDao;

    public void add(VaccineFunction vaccineFunction) {
        vaccineFunctionDao.insert(vaccineFunction);
    }

    public void removemany(Integer[] ids) {
        vaccineFunctionDao.deleteList(ids);
    }

    public VaccineFunction get(int id) {
        return vaccineFunctionDao.select(id);
    }

    public List<VaccineFunction> getAll() {
        return vaccineFunctionDao.selectAll();
    }
}
