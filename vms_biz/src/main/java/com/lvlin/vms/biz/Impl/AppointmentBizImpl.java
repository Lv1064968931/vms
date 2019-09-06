package com.lvlin.vms.biz.Impl;

import com.lvlin.vms.biz.AppointmentBiz;
import com.lvlin.vms.dao.AppointmentDao;
import com.lvlin.vms.entity.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "appointmentBiz")
public class AppointmentBizImpl implements AppointmentBiz {
    @Autowired
    private AppointmentDao appointmentDao;

    public void add(Appointment appointment) {
        appointmentDao.insert(appointment);
    }

    public Appointment get(int id) {
        return appointmentDao.select(id);
    }

    public Appointment getByName(String name) {
        return appointmentDao.selectByName(name);
    }

    public void edit(Appointment appointment) {
        appointmentDao.update(appointment);
    }

    public void removeByName(String name) {
        appointmentDao.deleteByName(name);
    }

    public void remove(int id) {
        appointmentDao.delete(id);
    }

    public void removemany(Integer[] ids) {
        appointmentDao.deleteList(ids);
    }

    public List<Appointment> getAll() {
        return appointmentDao.selectAll();
    }
}
