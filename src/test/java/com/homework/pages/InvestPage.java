package com.homework.pages;

import com.homework.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @Project: automation
 * @Author: 54540
 * @Create: 2021-05-21 10:57
 * @Desc：
 **/
public class InvestPage extends BasePage {
    //投资输入框
    By ketouBy = By.className("invest-unit-investinput");
    //投标按钮
    By buttonBy = By.xpath("//button[text()='投标']");
    //投标成功文本
    By successBy = By.xpath("//div[text()='投标成功！']");
    //关闭按钮
    By closeBy = By.xpath("//div[@class='layui-layer-content']//div[@class='close_pop']/img");
    //剩余金额
    By shengyuBy = By.className("mo_span4");

    //输入投资金额方法
    public double inputKeTou(){
        //String ktAmount = driver.findElement(ketouBy).getAttribute("data-amount");
        return Double.parseDouble(attribute(ketouBy,"投资页面_输入框金额","data-amount"))*10000;
    }

    //返回投标成功文本
    public String getSuccess(){

        //return driver.findElement(successBy).getText();
        String text = getText(successBy, "投资页面_弹窗成功");
        return text;
    }
    //点击关闭按钮
    public void getClose(){

        //driver.findElement(closeBy).click();
        click(closeBy,"投资页面_关闭按钮");
    }
    //获得剩余金额
    public double getShengYu(){
        //String text = driver.findElement(shengyuBy).getText();
        return Double.parseDouble(getText(shengyuBy,"投资页面_剩余金额"));
    }
    //投标操作
    public void invest(String amount){

        //driver.findElement(ketouBy).sendKeys(amount);
        //driver.findElement(buttonBy).click();
        input(ketouBy,"投资页面_输入投标金额",amount);
        click(buttonBy,"投资页面_点击投标按钮");
    }
}
