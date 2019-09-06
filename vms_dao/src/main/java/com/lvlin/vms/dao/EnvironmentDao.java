package com.lvlin.vms.dao;

import com.lvlin.vms.entity.Environment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "environmentDao")
public interface EnvironmentDao {
    List<Environment> selectAll();
}
