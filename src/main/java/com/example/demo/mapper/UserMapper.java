package com.example.demo.mapper;

import com.example.demo.entity.Role;
import com.example.demo.entity.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    @Select("select * from user where username = #{username}")
    UserInfo getUserByUsername(String username);

    @Insert("insert into user (username, password) value (#{username}, #{password})")
    int insertUserInfo(UserInfo userInfo);

    @Select("select * from role where id in (select rid from user_role where uid=#{id})")
    List<Role> getRolesById(int id);
}
