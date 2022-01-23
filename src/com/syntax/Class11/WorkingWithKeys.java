package com.syntax.Class11;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class WorkingWithKeys {
    public static String url = "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
//locate the user name
        WebElement username = driver.findElement(By.id("ctl00_MainContent_username"));
//locate the password
        WebElement password = driver.findElement(By.name("ctl00$MainContent$password"));

//        username
        username.sendKeys("Testers", Keys.BACK_SPACE);//first we deliting any text in text box
        username.sendKeys(Keys.TAB);

//password
        password.sendKeys("test", Keys.ENTER);


        TakesScreenshot ts = (TakesScreenshot) driver;
//        to take the screen shot, this step takes the screen shot
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

//      save the screen shot in our computer
        try {
//            copy the screen shot to a new directory inside the project and
//            give the path to that particular screenshot
            FileUtils.copyFile(sourceFile, new File("screenshot/smartBear/adminlogin2.png"));//we should always go for png format
                                                                                 //if we wont change the name of the file it will get overriden

       } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
