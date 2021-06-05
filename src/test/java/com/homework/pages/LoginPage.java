package com.homework.pages;

import com.homework.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @Project: automation
 * @Author: 54540
 * @Create: 2021-05-21 10:18
 * @Desc：
 **/
public class LoginPage extends BasePage {
    //账号
    By phoneBy = By.name("phone");
    //密码
    By pwdBy = By.name("password");
    //登录
    By loginBy = By.xpath("//button[text()='登录']");
    //输入框TIPS
    By inputTipsBy = By.xpath("//div[text()='请输入正确的手机号']");
    //中间弹窗TIPS
    By centerTipsBy = By.xpath("//div[text()='帐号或密码错误!']");


    //登录方法
    public void login(String phone,String pwd){
        input(phoneBy,"登录页面_手机号码输入框",phone);
        input(pwdBy,"登录页面_密码输入框",pwd);
        click(loginBy,"登录页面_点击按钮");
    }
    //判断输入框弹出
    public String inputTips(){
        //String text = driver.findElement(inputTipsBy).getText();
        return getText(inputTipsBy,"登陆页面_输入框的提示信息");
    }
    //判断中间框弹出
    public String centerTips(){
        //String text = driver.findElement(centerTipsBy).getText();
        return getText(centerTipsBy,"登陆页面_中间弹窗的提示信息");
    }

}
