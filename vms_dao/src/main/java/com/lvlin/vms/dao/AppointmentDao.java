package com.lvlin.vms.dao;

import com.lvlin.vms.entity.Appointment;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository(value = "appointmentDao")
public interface AppointmentDao {
    void insert(Appointment appointment);
    void update(Appointment appointment);
    void deleteByName(String name);
    void delete(int id);
    void deleteList(Integer[] ids);
    Appointment select(int id);
    Appointment selectByName(String name);
    List<Appointment> selectAll();
}
