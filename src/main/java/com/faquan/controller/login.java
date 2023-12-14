package com.faquan.controller;

import com.faquan.pojo.people;
import com.faquan.pojo.support.FlagCode;
import com.faquan.pojo.support.result;
import com.faquan.service.peopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.faquan.service.message.publishWithErrorHandlerExample;

@RestController
@RequestMapping("/login")
public class login {


    @Autowired
    private peopleService ps;

    @PostMapping()
    public result getByUsernameAndPassword(@RequestBody people people) {
        // TODO: Replace these variables before running the sample.
        String projectId = "pubsubtest846";
        String topicId = "my-topic";
        result result = new result();
        System.out.println(people);
        String username = people.username;
        String password = people.password;
        people byUsernameAndPassword = ps.getByUsernameAndPassword(username, password);
        System.out.println(byUsernameAndPassword);
        if (byUsernameAndPassword == null) {
            result.setFlag(FlagCode.GET_FAILED);
        } else {
            result.setFlag(FlagCode.GET_SUCCESS);
            try {
                publishWithErrorHandlerExample(projectId, topicId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}

