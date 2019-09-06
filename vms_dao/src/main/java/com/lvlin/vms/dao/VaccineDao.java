package com.lvlin.vms.dao;

import com.lvlin.vms.entity.Vaccine;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("vaccineDao")
public interface VaccineDao {
    void insert(Vaccine vaccine);
    void update(Vaccine vaccine);
    void delete(int id);
    void deleteList(Integer[] ids);
    Vaccine select(int id);
    Vaccine selectByRfidSn(String rfidSn);
    List<Vaccine> selectAll();
}
