package com.lvlivejp.shirodemo.utils;

public class ShiroThreadLocal {

    private static ThreadLocal<String> userNameThreadLocal = new ThreadLocal<>();

    public static void setUserName(String userName){
        userNameThreadLocal.set(userName);
    }

    public static String getUserName(){
        return userNameThreadLocal.get();
    }

    public static void  removeUserName(){
        userNameThreadLocal.remove();
    }
}
