package com.lvlin.vms.biz.Impl;

import com.lvlin.vms.biz.VaccineEnvironmentBiz;
import com.lvlin.vms.dao.VaccineEnvironmentDao;
import com.lvlin.vms.entity.VaccineEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "vaccineEnvironmentBiz")
public class VaccineEnvironmentBizImpl implements VaccineEnvironmentBiz {
    @Autowired
    private VaccineEnvironmentDao vaccineEnvironmentDao;

    public void add(VaccineEnvironment vaccineEnvironment) {
        vaccineEnvironmentDao.insert(vaccineEnvironment);
    }

    public VaccineEnvironment get(int id) {
        return vaccineEnvironmentDao.select(id);
    }

    public void edit(VaccineEnvironment vaccineEnvironment) {
        vaccineEnvironmentDao.update(vaccineEnvironment);
    }

    public void remove(int id) {
        vaccineEnvironmentDao.delete(id);
    }

    public void removemany(Integer[] ids) {
        vaccineEnvironmentDao.deleteList(ids);
    }

    public List<VaccineEnvironment> getAll() {
        return vaccineEnvironmentDao.selectAll();
    }
}
