package com.homework.testcases;

import com.homework.base.Assetion;
import com.homework.base.BaseTest;
import com.homework.data.Constants;
import com.homework.pages.IndexPage;
import com.homework.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * @Project: automation
 * @Author: 54540
 * @Create: 2021-05-22 21:18
 * @Desc：登录反向测试用例
 **/
public class LoginTest extends BaseTest {

    @BeforeMethod
    public void setUp(){
        openBrowser(Constants.TEST_BROWSER);
        //窗口最大化
        maxBrowser();
        //打开登录页面
        toUrl(Constants.LOGIN_URL);
        //隐式等待
        implicitlyWait(8);
    }
    @Test
    public void testSucessLogin(){
        //正常登录
        LoginPage loginPage = new LoginPage();
        loginPage.login(Constants.CORRECT_PHONE,Constants.CORRECT_PWD);

        //断言
        IndexPage indexPage = new IndexPage();
        //判断是否存在退出按钮
        //Assert.assertTrue(indexPage.getQuit(driver));
        Assetion.myAssertTrue(indexPage.getQuit());
        //判断是否存在我的账户
        //Assert.assertTrue(indexPage.getAccount(driver));
        Assetion.myAssertTrue(indexPage.getAccount());
        //判断url是否改变
        String currentUrl = getCurrentUrl();
        //Assert.assertEquals(currentUrl,"http://8.129.91.152:8765/Index/index");
        Assetion.myAssertEquals(currentUrl,"http://8.129.91.152:8765/Index/index");
    }
    @Test(dataProvider = "failDatas1")
    public void testFailedLogin1(String phone,String pwd,String tips){
        LoginPage loginPage = new LoginPage();
        loginPage.login(phone,pwd);
        //断言
        //Assert.assertEquals(loginPage.inputTips(driver),tips);
        Assetion.myAssertEquals(loginPage.inputTips(),tips);
    }
    @Test(dataProvider = "failDatas2")
    public void testFailedLogin2(String phone,String pwd,String tips){
        LoginPage loginPage = new LoginPage();
        loginPage.login(phone,pwd);
        //断言
        //Assert.assertEquals(loginPage.centerTips(driver),tips);
        Assetion.myAssertEquals(loginPage.centerTips(),tips);
    }

    @DataProvider
    public Object[][] failDatas1(){
        Object[][] arr = {
                {"1585901925","lemon123456","请输入正确的手机号"},
                {"158590192534","lemon123456","请输入正确的手机号"},
                {"1585901925%","lemon123456","请输入正确的手机号"}
                };
        return arr;
    }

    @DataProvider
    public Object[][] failDatas2(){
        Object[][] arr = {
                {"13323234545","LEMON123456","帐号或密码错误!"},
                {"13323234545","lemon1234567","帐号或密码错误!"},
                {"13323234545","lemon12345","帐号或密码错误!"},
                {"13323234545","lemon123456 ","帐号或密码错误!"}};
        return arr;
    }
    @AfterMethod
    public void tearDown(){
        quitBrowser();
    }
}
