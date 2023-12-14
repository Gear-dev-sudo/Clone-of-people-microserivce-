package com.faquan.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class people {

    public int id;
    public String username;
    @TableField(select = false)
    public String password;
    public String role;

}
