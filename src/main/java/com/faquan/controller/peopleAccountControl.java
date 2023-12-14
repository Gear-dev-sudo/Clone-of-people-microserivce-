package com.faquan.controller;

import com.faquan.pojo.people;
import com.faquan.pojo.support.FlagCode;
import com.faquan.pojo.support.result;
import com.faquan.service.peopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peopleAccount")
public class peopleAccountControl {

    @Autowired
    private peopleService ps;

    @GetMapping
    public result getById(@RequestBody people people) {
        int id = people.id;
        result result = new result();
        people byId = ps.getById(id);
        if (byId == null) {
            result.setFlag(FlagCode.GET_FAILED);
            return result;
        } else {
            result.setFlag(FlagCode.GET_SUCCESS);
            result.setData(byId);
            return result;
        }
    }

    @GetMapping("/all")
    public result getAll() {
        result result = new result();
        List<people> byAll = ps.getByAll();
        if (byAll.isEmpty()) {
            result.setFlag(FlagCode.GET_FAILED);
            return result;
        } else {
            result.setFlag(FlagCode.GET_SUCCESS);
            result.setData(byAll);
            return result;
        }
    }

    @GetMapping("/usernameAndPassword")
    public result getByUsernameAndPassword(@RequestBody people people) {
        result result = new result();
        System.out.println(people);
        String username = people.username;
        String password = people.password;
        people byUsernameAndPassword = ps.getByUsernameAndPassword(username, password);
        if (byUsernameAndPassword == null) {
            result.setFlag(FlagCode.GET_FAILED);
        } else {
            result.setFlag(FlagCode.GET_SUCCESS);
        }
        return result;
    }

    @PutMapping
    public result updateById(@RequestBody people people) {
        result byId = getById(people);
        result result = new result();
        if (byId.getFlag() == FlagCode.GET_FAILED) {
            result.setFlag(FlagCode.UPDATE_FAILED);
            return result;
        } else {
            int i = ps.updateById(people);
            result.setFlag(FlagCode.UPDATE_SUCCESS);
            return result;
        }
    }

    @DeleteMapping
    public result deleteById(@RequestBody people people) {
        int id = people.id;
        result result = new result();
        int i = ps.deletById(id);
        if (i > 0) {
            result.setFlag(FlagCode.DELETE_SUCCESS);
            return result;
        } else {
            result.setFlag(FlagCode.DELETE_FAILED);
            return result;
        }
    }

    @PostMapping
    public result insert(@RequestBody people people) {
        result result = new result();
        int insert = ps.insert(people);
        if (insert != 0) {
            result.setFlag(FlagCode.POST_SUCCESS);
        } else {
            result.setFlag(FlagCode.POST_FAILED);
        }
        return result;
    }

}
