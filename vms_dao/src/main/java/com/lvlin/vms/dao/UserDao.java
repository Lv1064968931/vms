package com.lvlin.vms.dao;

import com.lvlin.vms.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "userDao")
public interface UserDao {
    void insert(User user);
    void update(User user);
    void delete(String account);
    void deleteList(String[] accounts);
    User select(String account);
    List<User> selectAll();
}
