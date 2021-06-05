package com.homework.testcases;

import com.homework.base.Assetion;
import com.homework.base.BaseTest;
import com.homework.data.Constants;
import com.homework.pages.IndexPage;
import com.homework.pages.InvestPage;
import com.homework.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * @Project: automation
 * @Author: 54540
 * @Create: 2021-05-21 10:13
 * @Desc：投标测试用例
 **/
public class InvestTest extends BaseTest {
    String addBid;
    @BeforeMethod
    public void setUp(){
        openBrowser(Constants.TEST_BROWSER);
        implicitlyWait(8);
        maxBrowser();
        //加标
        addBid = addBid();
        //打开加标页面
        toUrl(Constants.LOGIN_URL);
        //登录
        LoginPage loginTest = new LoginPage();
        loginTest.login(Constants.CORRECT_PHONE,Constants.CORRECT_PWD);

    }
    @Test
    public void invest() throws InterruptedException {
        //首页点击抢投标按钮
        IndexPage indexPage = new IndexPage();
        indexPage.investBid(addBid);
        //投标操作
        InvestPage investPage = new InvestPage();
        investPage.invest("200");
        //获取可投金额
        double inputKeTou = investPage.inputKeTou();
        //获取剩余金额
        double shengYu = investPage.getShengYu();
        //断言
        //Assert.assertEquals(investPage.getSuccess(driver),"投标成功！");
        Assetion.myAssertEquals(investPage.getSuccess(),"投标成功");
        Thread.sleep(1000);
        //点击关闭按钮
        investPage.getClose();

        //刷新
        refresh();
        //投标后的金额
        double afterKeTou = investPage.inputKeTou();
        double afterShengYu = investPage.getShengYu();
        //断言
        Assert.assertEquals(inputKeTou-afterKeTou,200.0);
        Assert.assertEquals(shengYu-afterShengYu,200.0);



    }
    @AfterMethod
    public void tearDown(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        quitBrowser();
    }



    public String addBid(){
        //访问后台页面的地址
        driver.get(Constants.BACKSTAGE_URL);
        //后台登录
        driver.findElement(By.name("admin_name")).sendKeys("lemon7");
        driver.findElement(By.name("admin_pwd")).sendKeys("lemonbest");
        driver.findElement(By.name("code")).sendKeys("hapi");
        driver.findElement(By.xpath("//button[text()='登陆后台']")).click();
        //后台首页-借款管理
        driver.findElement(By.xpath("//span[text()='借款管理']")).click();
        //加标(在iframe中，需要切换iframe)
        driver.switchTo().frame("mainFrame");
        driver.findElement(By.xpath("//span[text()='加标']")).click();
        driver.findElement(By.xpath("//td[text()='借款人:']/following-sibling::td/span/input[1]")).sendKeys("13323234444");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //按下方向下键
        driver.findElement(By.xpath("//td[text()='借款人:']/following-sibling::td/span/input[1]")).sendKeys(Keys.ARROW_DOWN);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //按下Enter键
        driver.findElement(By.xpath("//td[text()='借款人:']/following-sibling::td/span/input[1]")).sendKeys(Keys.ENTER);
        String loanTitle = "测试"+System.currentTimeMillis();
        driver.findElement(By.xpath("//td[text()='贷款标题:']/following-sibling::td/input")).sendKeys(loanTitle);
        driver.findElement(By.xpath("//td[text()='年利率利息:']/following-sibling::td/input")).sendKeys("10");
        driver.findElement(By.xpath("//td[text()='借款期限:']/following-sibling::td/input")).sendKeys("6");
        driver.findElement(By.xpath("//td[text()='借款额度:']/following-sibling::td/input")).sendKeys("1000000");
        driver.findElement(By.xpath("//td[text()='竞标期限:']/following-sibling::td/input")).sendKeys("5");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//span[text()='风控评测']")).click();
        driver.findElement(By.xpath("//td[text()='评估价值:']/following-sibling::td/input")).sendKeys("2000000");
        driver.findElement(By.xpath("//span[text()='项目录入']")).click();
        driver.findElement(By.xpath("//td[text()='籍贯:']/following-sibling::td/input")).sendKeys("湖南长沙");
        driver.findElement(By.xpath("//td[text()='职业:']/following-sibling::td/input")).sendKeys("测试工程师");
        driver.findElement(By.xpath("//td[text()='年龄:']/following-sibling::td/input")).sendKeys("20");
        driver.findElement(By.xpath("//span[text()='提交']")).click();
        //三次审核
        for (int i=0; i<3;i++){
            //点击选择对应项目
            //这里需要通过Thread.sleep等待，因为表格数据需要得到服务器的返回才能加载出来，但是表格元素已经存在，如果不等待会报错
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.findElement(By.xpath("//div[text()='"+loanTitle+"']")).click();
            driver.findElement(By.xpath("//span[text()='审核']")).click();
            driver.findElement(By.xpath("//span[text()='审核通过']")).click();
        }
        return loanTitle;

    }
}
