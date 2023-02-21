package com.utils;

import com.domain.SysLog;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {
    private static BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
    public static String encodePassword(String password){
     return bCryptPasswordEncoder.encode(password);
    }
    public static void main(String[]args){

    String password=encodePassword("123456");
    String password2=encodePassword("123456");
       System.out.println(password);
               System.out.println(password2);
               System.out.println(bCryptPasswordEncoder.matches("123456",password));
               System.out.println(bCryptPasswordEncoder.matches("123456",password2));
               }
               }
