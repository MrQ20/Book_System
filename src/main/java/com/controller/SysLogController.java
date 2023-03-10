package com.controller;

import com.domain.SysLog;
import com.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/syslog")
public class SysLogController {
    @Autowired
    ISysLogService sysLogService;
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView mv=new ModelAndView();
       List<SysLog> sysLogs= sysLogService.findAll();
        mv.addObject("syslogList",sysLogs);
        mv.setViewName("syslog-list");
        return mv;
    }
    @RequestMapping("/delete")
    public String delete(Integer id){
        sysLogService.delete(id);
        return "redirect:findAll";
    }
    @RequestMapping("/deleteAll")
    public String delete(){
        sysLogService.deleteAll();
        return "redirect:findAll";
    }
}
