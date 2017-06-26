package com.xy.studyapp.security;

import org.springframework.context.ApplicationContext;

/**
 * Created by xy on 2017/6/23.
 */
public class Appctx {
    public static ApplicationContext ctx=null;
    public static Object getObject(String string){
        return ctx.getBean(string);
    }
}
