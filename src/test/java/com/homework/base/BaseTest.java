package com.homework.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

/**
 * @Project: automation
 * @Author: 54540
 * @Create: 2021-05-18 14:14
 * @Desc：浏览器驱动封装
 **/
public class BaseTest {
    static Logger logger = Logger.getLogger(BaseTest.class);
    public static WebDriver driver;
    /**
     * 统一浏览器封装
     * @param browserName 指定打开浏览器名
     */
    public static void openBrowser(String browserName){
        if("chrome".equalsIgnoreCase(browserName)){
            //执行打开chrome的代码
            System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
        }else if("firefox".equalsIgnoreCase(browserName)){
            //执行打开firefox的代码
            System.setProperty("webdriver.gecko.driver","src\\test\\resources\\geckodriver.exe");
            driver = new FirefoxDriver();
        }else if("ie".equalsIgnoreCase(browserName)){
            //执行打开ie的代码
            //取消IE安全设置（忽略IE的Protected Mode的设置）
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            //忽略掉浏览器缩放设置问题
            capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
            //表示让我们脚本使用对应的驱动程序iedriver.exe
            System.setProperty("webdriver.ie.driver","src\\test\\resources\\IEDriverServer.exe");
            driver = new InternetExplorerDriver(capabilities);
        }else {
            System.out.println("浏览器不支持，请确认你的浏览器名是否正确");

        }
    }
    //打开浏览器
    public static void toUrl(String url){
        driver.get(url);
        logger.info("打开【"+url+"】地址");
    }
    //窗口最大化
    public void maxBrowser(){
        driver.manage().window().maximize();
        logger.info("窗口最大化");
    }
    //隐式等待
    public void implicitlyWait(int timeouts){
        driver.manage().timeouts().implicitlyWait(timeouts,TimeUnit.SECONDS);
        logger.info("设置全局等待时间【"+timeouts+"】秒");
    }
    //刷新
    public void refresh(){
        driver.navigate().refresh();
        logger.info("刷新页面");
    }
    //获取url
    public String getCurrentUrl(){
        String currentUrl = driver.getCurrentUrl();
        logger.info("获取currentUrl【"+currentUrl+"】");
        return currentUrl;
    }
    //关闭浏览器
    public void quitBrowser(){
        driver.quit();
        logger.info("关闭浏览器");
    }

    /**
     * 生成字节数组截图的封装
     */
    public static byte[] getScreenshotAsByte(){
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        //1、file对象
        //2、字节数组
        byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        return screenshot;
    }
}
