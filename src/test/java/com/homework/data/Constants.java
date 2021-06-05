package com.homework.data;

/**
 * @Project: automation
 * @Author: 54540
 * @Create: 2021-05-18 14:56
 * @Desc： 数据常量
 **/
public class Constants {
    //项目BaseUrl 测试环境-->预发布环境
    public static final String BASE_URL="http://8.129.91.152:8765";
    //登录页面地址
    public static final String LOGIN_URL = BASE_URL+"/Index/login.html";
    //正确的前台登录手机号码
    public static final String CORRECT_PHONE="13323234545";
    //正确的前台登录密码
    public static final String CORRECT_PWD="lemon123456";
    //配置测试浏览器
    public static final String TEST_BROWSER="chrome";
    //后台账号
    public static final String USER_NAME = "lemon7";
    //后台密码
    public static final String PASS_WORD = "lemonbest";
    //后台验证码
    public static final String VERIFICATION = "hapi";
    //投标后台
    public static final String BACKSTAGE_URL = BASE_URL+"/Admin/Index/login.html";
}
