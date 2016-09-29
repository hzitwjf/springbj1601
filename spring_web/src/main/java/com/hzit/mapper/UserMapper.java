package com.hzit.mapper;

import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/9/26.
 */
@Repository
public class UserMapper {
    public UserMapper(){
        System.out.println("我是UserMapper，专门用来调用数据的数据访问层");
    }
}
