package com.faquan.controller;

import com.faquan.pojo.people;
import com.faquan.pojo.support.FlagCode;
import com.faquan.pojo.support.result;
import com.faquan.service.peopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peopleInfo")
public class peopleInfoControl {

    @Autowired
    private peopleService ps;

    @GetMapping("/{username}")
    public result getByUserName(@PathVariable String username) {
        result result = new result();
        people by = ps.getByUsername(username);
        if (by == null) {
            result.setFlag(FlagCode.GET_FAILED);
            return result;
        } else {
            result.setFlag(FlagCode.GET_SUCCESS);
            result.setData(by);
            return result;
        }
    }
    @PostMapping
    public result getByRole(@RequestBody people people) {
        String role = people.role;
        result result = new result();
        List<people> byRole = ps.getByRole(role);
        if (byRole.isEmpty()) {
            result.setFlag(FlagCode.GET_FAILED);
        } else {
            result.setFlag(FlagCode.GET_SUCCESS);
            result.setData(byRole);
        }
        return result;
    }
}
