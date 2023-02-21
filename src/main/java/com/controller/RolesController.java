package com.controller;

import com.domain.Roles;
import com.service.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/roles")
public class RolesController {
    @Autowired
    private IRolesService service;
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView mv=new ModelAndView();
        List<Roles> roles=service.findAll();
        mv.addObject("roleList",roles);
        mv.setViewName("role-list");
        return mv;

    }
    @RequestMapping("/save")
    public String save(Roles role){
        service.save(role);
        return "redirect:findAll";
    }
}
