package com.syntax.test;

import com.syntax.pages.LoginPageWithPageFactory;
import com.syntax.testBase.BaseClass;
import com.syntax.utils.CommonMethods;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class LoginPageTestWithPageFactory {
    public static void main(String[] args)  {
        //we are calling method from Base Class to open browser
        BaseClass.openWithSpecificUrl("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/dashboard");

        //create an object of loginPagewithPagefactory

        LoginPageWithPageFactory loginPageWithPageFactory=new LoginPageWithPageFactory();
        //after creating Object we have access to all elements from  LoginPageWithPageFactory page
        loginPageWithPageFactory.username.sendKeys("Admin");
        loginPageWithPageFactory.password.sendKeys("Hum@nhrm123");
        loginPageWithPageFactory.loginBtn.click();

       /* TakesScreenshot ts=(TakesScreenshot)BaseClass.driver;//driver is a static variable thats why we dont need to create an object of that class
        File sourceFile=ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(sourceFile,new File("screenshots/HRMS/dashboard.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        BaseClass.tearDown();
    }
}
