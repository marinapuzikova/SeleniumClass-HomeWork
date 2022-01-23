package com.syntax.test;

import com.syntax.pages.DashBoardPage;
import com.syntax.pages.LoginPageWithPageFactory;
import com.syntax.testBase.BaseClass;
import com.syntax.utils.CommonMethods;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class DashBoardTest {
    public static void main(String[] args)  {
        //we are calling method from Base Class to open browser
        BaseClass.openWithSpecificUrl("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/dashboard");

        LoginPageWithPageFactory loginPageWithPageFactory=new LoginPageWithPageFactory();  //create an object of loginPagewithPagefactory
        //after creating Object we have access to all elements from  LoginPageWithPageFactory and DashBoardPage pages
        loginPageWithPageFactory.username.sendKeys("Admin");
        loginPageWithPageFactory.password.sendKeys("Hum@nhrm123");
        loginPageWithPageFactory.loginBtn.click();

        DashBoardPage dashBoardPage=new DashBoardPage();//create an object of DashBoardPage
        String welcomeText = dashBoardPage.welcomeAdmin.getText();
        System.out.println(welcomeText);

        CommonMethods.takeTheScreenShot("welcomadmin");

        BaseClass.tearDown();
    }
}
