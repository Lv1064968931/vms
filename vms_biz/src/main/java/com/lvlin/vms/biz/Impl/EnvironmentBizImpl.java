package com.lvlin.vms.biz.Impl;

import com.lvlin.vms.biz.EnvironmentBiz;
import com.lvlin.vms.dao.EnvironmentDao;
import com.lvlin.vms.entity.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "environmentBiz")
public class EnvironmentBizImpl implements EnvironmentBiz {
    @Autowired
    private EnvironmentDao environmentDao;
    public List<Environment> getAll() {
        return environmentDao.selectAll();
    }
}
