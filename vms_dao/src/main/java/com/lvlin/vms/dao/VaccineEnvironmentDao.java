package com.lvlin.vms.dao;

import com.lvlin.vms.entity.VaccineEnvironment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("vaccineEnvironmentDao")
public interface VaccineEnvironmentDao {
    void insert(VaccineEnvironment vaccineEnvironment);
    void update(VaccineEnvironment vaccineEnvironment);
    void delete(int id);
    VaccineEnvironment select(int id);
    void deleteList(Integer[] ids);
    List<VaccineEnvironment> selectAll();
}
