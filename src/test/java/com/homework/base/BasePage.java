package com.homework.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @Project: automation
 * @Author: 54540
 * @Create: 2021-05-23 08:01
 * @Desc：二次封装
 **/
public class BasePage {
    Logger logger = Logger.getLogger(BasePage.class);

    /**
     * 点击二次封装
     * @param by
     * @param desc
     */
    public void click(By by,String desc){
        try{
            BaseTest.driver.findElement(by).click();
            logger.info("点击了元素【"+desc+"】");
        }catch (Exception e){
            logger.info("定位元素异常【"+desc+"】");
            logger.info(e);
            throw e;
        }
    }

    /**
     *输入二次封装
     * @param by
     * @param desc
     * @param data
     */
    public void input(By by,String desc,String data){
        try{
            BaseTest.driver.findElement(by).sendKeys(data);
            logger.info("往元素【"+desc+"】输入了【"+data+"】");
        }catch (Exception e){
            logger.info("定位元素异常【"+desc+"】");
            logger.info(e);
            throw e;
        }
    }

    /**
     * 获取文本二次封装
     * @param by
     * @param desc
     */

    public String getText(By by,String desc){
        String text = null;
        try{
            //显示等待
            WebDriverWait webDriverWait = new WebDriverWait(BaseTest.driver,8);
            WebElement element = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
            text = element.getText();
            logger.info("获取元素【"+desc+"】的文本值【"+text+"】");
        }catch (Exception e){
            logger.info("定位元素异常【"+desc+"】");
            logger.info(e);
            throw e;
        }
        return text;
    }

    /**
     * 获取元素的属性值
     * @param by
     * @param desc
     * @param data
     * @return
     */
    public String attribute(By by,String desc,String data){
        String value = null;
        try{
            WebElement element = BaseTest.driver.findElement(by);
            value = element.getAttribute(data);
            logger.info("获取元素【"+desc+"】");
        }catch (Exception e){
            logger.info("定位元素异常【"+desc+"】");
            logger.info(e);
            throw e;
        }
        return value;
    }
}
