package com.homework.pages;

import com.homework.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @Project: automation
 * @Author: 54540
 * @Create: 2021-05-21 10:58
 * @Desc：
 **/
public class IndexPage {
    //获取退出按钮
    By quitBy = By.linkText("退出");
    //获取我的账户
    By myAccountBy = By.xpath("//a[contains(text(),'我的帐户')]");

    //返回退出
    public boolean getQuit(){
        WebElement element = BaseTest.driver.findElement(quitBy);
        boolean isDisplayQuit = element.isDisplayed();
        return isDisplayQuit;
    }
    //返回我的账户
    public boolean getAccount(){

        WebElement element = BaseTest.driver.findElement(myAccountBy);
        boolean isDisplayAccount = element.isDisplayed();
        return isDisplayAccount;
    }
    //抢投标
    public void investBid(String loanTitle){
        BaseTest.driver.findElement(By.xpath("//span[contains(text(),'"+loanTitle+"')]/parent::div/parent::a/following-sibling::div[1]//a")).click();
    }
}
