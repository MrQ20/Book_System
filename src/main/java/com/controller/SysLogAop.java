package com.controller;

import com.domain.SysLog;
import com.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
@Aspect
@Component
public class SysLogAop {
    @Autowired
    private ISysLogService sysLogService;
    //在web.xml中配置，帮助我们注入
    @Autowired
    private HttpServletRequest request;
    private Date visteTime;//访问的时间
    private Class clazz;//访问的类
    private Method method;//访问的方法

    //前置通知，获取开始时间，执行的类是哪一个，执行的方法是哪一个
    @Before("execution(* com.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        visteTime=new Date();
        clazz=jp.getTarget().getClass();
        String methodName=jp.getSignature().getName();//获取方法名字
        Object[] args=jp.getArgs();//获取访问的方法参数
        //获取具体指定的method对象
        if(args==null ||args.length==0) {
            method = clazz.getMethod(methodName);//只能获取无参数的方法
        }
        else {
            Class [] classArgs=new Class[args.length];
            for(int i=0;i<args.length;i++){
                classArgs[i] =args[i].getClass();
            }
            clazz.getMethod(methodName,classArgs);
        }
    }
    //后置通知
    @After("execution(* com.controller.*.*(..))")
    public void doAfter(JoinPoint jp){
        //访问时长
        Long time=new Date().getTime()-visteTime.getTime();
        //获取访问路径url
        String url="";
        if(clazz!=null&&method!=null&&clazz!=SysLogAop.class&&clazz!=SysLogController.class){
            //1 获取类上RequestMapping的value
            RequestMapping clazzAnnotation= (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if(clazzAnnotation!=null){
                String[] classValues= clazzAnnotation.value();
                //2 获取方法上RequestMapping的value
                RequestMapping methodAnnotation= method.getAnnotation(RequestMapping.class);
                if(methodAnnotation!=null){
                    String[] methodValues=methodAnnotation.value();
                    url=classValues[0]+methodValues[0];
                    //获取Ip
                    String ip= request.getRemoteAddr();

                    //获取当前操作的用户
                    SecurityContext context= SecurityContextHolder.getContext();//从上下文获取当前操作的用户
                    User user= (User) context.getAuthentication().getPrincipal();
                    //获取当前用户名
                    String username= user.getUsername();
                    //将日志信息封装到SysLog对象中
                    SysLog sysLog=new SysLog();
                    //设置执行时间
                    sysLog.setExecutionTime(time);
                    sysLog.setIp(ip);
                    sysLog.setUrl(url);
                    sysLog.setUsername(username);
                    sysLog.setVisitTime(visteTime);
                    sysLog.setMethod(clazz.getName()+"."+method.getName());
                    //调用service完成数据存储
                    sysLogService.save(sysLog);
                }

            }
        }

    }
}
