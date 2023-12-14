package com.faquan;

import com.faquan.service.peopleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PeopleServiceApplicationTests {
    @Autowired
    public peopleService peopleService;
    @Test
    void contextLoads() {
        System.out.println(peopleService.getByRole("sales"));
    }

}
