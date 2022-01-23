package com.syntax.test;

import com.syntax.pages.LoginPage;
import com.syntax.pages.LoginPageWithPageFactory;
import com.syntax.testBase.BaseClass;
import com.syntax.utils.CommonMethods;
import org.openqa.selenium.WebElement;

public class LoginPageTestWrongPassword {
    public static void main(String[] args) {

        BaseClass.openWithSpecificUrl("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/dashboard");
        //locate the element on LoginPage and send the username and password
        LoginPageWithPageFactory login = new LoginPageWithPageFactory();
        WebElement user=login.username;
        CommonMethods.sendText(user, "Admin");//one way to use sendText method

        CommonMethods.sendText(login.password, "HUMMM@nhrm123");//another way to use sendText method
        login.loginBtn.click();
        //take screensots
        CommonMethods.takeTheScreenShot("wrongPassword");

        BaseClass.tearDown();
    }
}
