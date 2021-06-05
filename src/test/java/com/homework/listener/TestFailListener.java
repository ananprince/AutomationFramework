package com.homework.listener;

import com.homework.base.BaseTest;
import io.qameta.allure.Attachment;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

/**
 * @Project: automation
 * @Author: 54540
 * @Create: 2021-05-26 10:42
 * @Desc：
 **/
public class TestFailListener implements IHookable {
    @Override
    public void run(IHookCallBack iHookCallBack, ITestResult iTestResult) {
        System.out.println("当前是IHookable接口的run方法执行");
        iHookCallBack.runTestMethod(iTestResult);
        if(iTestResult.getThrowable()!=null){
            //生成字节数组格式的截图
            byte[] screenshot = BaseTest.getScreenshotAsByte();
            //怎么嵌入到Allure报表中？？
            saveScreenshotToAllure(screenshot);
        }
    }
    @Attachment
    public byte[] saveScreenshotToAllure(byte[] data){
        return data;
    }
}
