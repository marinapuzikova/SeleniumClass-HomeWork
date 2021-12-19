package com.syntax.class05.HomeWork05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Task2 {
    /*
    HRMS Application Negative Login:
Open chrome browser
Go to “http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login”
Enter valid username
Leave password field empty
Click on login button
Verify error message with text “Password cannot be empty” is displayed.
     */
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        WebElement userName= driver.findElement(By.cssSelector("input#txtUsername"));
        userName.sendKeys("admin");
        WebElement loginButton=driver.findElement(By.cssSelector("input#btnLogin"));
        loginButton.click();
        WebElement noPassword=driver.findElement(By.cssSelector("span#spanMessage"));
        if (noPassword.isDisplayed()){
            System.out.println("Password cannot be empty");
            System.out.println("Test passed");
        }
        driver.quit();
    }
}
