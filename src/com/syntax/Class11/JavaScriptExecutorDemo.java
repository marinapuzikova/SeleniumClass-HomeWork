package com.syntax.Class11;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecutorDemo {
    public static String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
//        login in code for the website
        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("Hum@nhrm123");
//        create an instance of JS Executor
        JavascriptExecutor js=(JavascriptExecutor) driver;
        //arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')

        //js.executeScript("arguments[0].style.border='2px solid orange'",username);
        js.executeScript("arguments[0]. setAttribute('style', 'border:2px solid blue; background:yellow')",username);
        js.executeScript("arguments[0].style.background='yellow'",password);

//        locate the element login button
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
//
//        loginButton.click();

        js.executeScript("arguments[0].click()",loginButton);


    }
}
