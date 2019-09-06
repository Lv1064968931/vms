package com.lvlin.vms.biz.Impl;

import com.lvlin.vms.biz.VaccineBiz;
import com.lvlin.vms.dao.VaccineDao;
import com.lvlin.vms.entity.Vaccine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "vaccineBiz")
public class VaccineBizImpl implements VaccineBiz {
    @Autowired
    private VaccineDao vaccineDao;

    public void add(Vaccine vaccine) {
        vaccineDao.insert(vaccine);
    }

    public Vaccine get(int id) {
        return vaccineDao.select(id);
    }

    public Vaccine getByRfidSn(String rfidSn) {
        return vaccineDao.selectByRfidSn(rfidSn);
    }

    public void edit(Vaccine vaccine) {
        vaccineDao.update(vaccine);
    }

    public void remove(int id) {
        vaccineDao.delete(id);
    }

    public void removemany(Integer[] ids) {
        vaccineDao.deleteList(ids);
    }

    public List<Vaccine> getAll() {
        return vaccineDao.selectAll();
    }
}
