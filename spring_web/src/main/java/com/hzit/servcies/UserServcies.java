package com.hzit.servcies;

import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/9/26.
 */
@Service
public class UserServcies {
   public UserServcies(){
      System.out.println("我是UserServices，专门用来处理业务逻辑的");
   }
   public String findAll(String context){
      return context;
   }
}
