package com.controller;

import com.domain.Roles;
import com.domain.UserInfo;
import com.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.management.relation.Role;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private IUserService service;

    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userInfos = service.findAll();
        mv.addObject("userList", userInfos);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/save")
    public String save(UserInfo userInfo) {
        service.save(userInfo);
        return "redirect:findAll";
    }

    @RequestMapping("/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true) Integer id){
        ModelAndView mv=new ModelAndView();
        List<Roles> rolesList=service.findUserByIdAndAllRole(id);
        mv.addObject("userId",id);
        mv.addObject("roleList",rolesList);
        mv.setViewName("user-role-add");
        return mv;

    }
    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(@RequestParam(name = "userId")Integer userId,@RequestParam(name = "ids") Integer[]roleIds){
              service.addRoleToUser(userId,roleIds);
              return "redirect:findAll";
    }
    @RequestMapping("/changePassword")
    public String ChangePassword(@RequestParam(name = "username",required = true)String username
    , @RequestParam(value = "password",required = true)String password,@RequestParam(value = "newPassword",required = true)String newPassword)
    {
        String res=service.changePassword(username,password,newPassword);
        return "redirect:"+res;
    }
    @RequestMapping("/findById")
    public ModelAndView findById(Integer id){
        ModelAndView mv=new ModelAndView();
        UserInfo userInfo=service.findById(id);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return mv;
    }
}