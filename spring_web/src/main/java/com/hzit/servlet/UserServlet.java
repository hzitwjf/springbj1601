/*
package com.hzit.servlet;

import com.hzit.entity.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

*/
/**
 * Created by Administrator on 2016/9/26.
 *//*

@Controller
public class UserServlet {
    public UserServlet(){
        System.out.println("我是UserServlet，作为控制器");
    }
    @RequestMapping("/shishi")
    @ResponseBody
    public Object zishu(){
        List<String> list=new ArrayList<String>();
        list.add("嘿嘿");
        list.add("呵呵");
        list.add("哈哈");
        System.out.println("控制器被调用");
        return list;
    }
    @RequestMapping("/login")
    public String login(){
        System.out.println("登录页面");
        return "index";
    }
    @RequestMapping("adduser")
    @ResponseBody
    public Object add(UserInfo userInfo){
        System.out.println("传入一个User对象");
        System.out.println(userInfo.toString());
       return userInfo;
    }
    @RequestMapping("add")
    @ResponseBody
    public Object zengjia(@RequestParam("name")String name,@RequestParam("pwd") String pwd){
        System.out.println(name+pwd);
        return "";
    }
}
*/
