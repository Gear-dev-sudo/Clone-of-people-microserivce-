package com.faquan.service;

import com.faquan.dao.UserDao;
import com.faquan.pojo.people;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class peopleService {
    @Autowired
    public UserDao userDao;

    public List<people> getByAll() {
        return userDao.selectList(null);
    }

    public people getById(int id) {
        return userDao.selectById(id);
    }

    public people getByUsernameAndPassword(String username, String password) {
        return userDao.getByUsernameAndPassword(username, password);
    }

    public people getByUsername(String username) {
        return userDao.getByUsername(username);
    }

    public int deletById(int id) {
        return userDao.deleteById(id);
    }

    public int updateById(people people) {
        return userDao.updateById(people);
    }

    public int insert(people people) {
        String username = people.username;
        people byUsername = getByUsername(username);
        if (byUsername == null){
            return userDao.insert(people);
        }
        else {
            return 0;
        }

    }
    public List<people> getByRole(String role){
        return userDao.getByRole(role);
    }

}
