package com.faquan.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.faquan.pojo.people;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao extends BaseMapper<people> {
    @Select("select id,username,password,role from people where #{username} = username and #{password} = password")
    people getByUsernameAndPassword(String username, String password);

    @Select("select id,username,password,role from people where #{username} = username")
    people getByUsername(@Param("username") String username);

    @Select("select id,username,password,role from people where #{role} = role")
    List<people> getByRole(@Param("role") String role);
}
