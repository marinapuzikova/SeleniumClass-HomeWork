package com.syntax.test;

import com.syntax.pages.LoginPage;
import com.syntax.testBase.BaseClass;
import com.syntax.utils.CommonMethods;

public class LoginPageTest {
    public static void main(String[] args) {
        //open the browser and navigate to http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/dashboard
        BaseClass.openWithSpecificUrl("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/dashboard");

        LoginPage loginPage = new LoginPage();//to get access to webElements from LoginPage class we need to create an object of that class
        //locate the Element and send keys
        loginPage.userNameField.sendKeys("Admin");
        loginPage.passwordField.sendKeys("Hum@nhrm123");
        loginPage.loginButton.click();
        //CommonMethods.sendText(loginPage.userNameField, "Admin");

        //CommonMethods.sendText(loginPage.passwordField, "Hum@nhrm123");
        //loginPage.loginButton.click();
        BaseClass.tearDown();
    }

}
