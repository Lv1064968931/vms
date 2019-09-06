package com.lvlin.vms.dao;

import com.lvlin.vms.entity.VaccineFunction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("vaccineFunctionDao")
public interface VaccineFunctionDao {
    void insert(VaccineFunction vaccineFunction);
    void deleteList(Integer[] ids);
    VaccineFunction select(Integer id);
    List<VaccineFunction> selectAll();
}
