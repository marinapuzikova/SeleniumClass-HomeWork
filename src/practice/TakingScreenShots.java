package practice;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class TakingScreenShots {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
        driver.manage().window().maximize();
        WebElement username = driver.findElement(By.id("ctl00_MainContent_username"));
        username.sendKeys("Tester", Keys.TAB);
        WebElement password = driver.findElement(By.name("ctl00$MainContent$password"));
        password.sendKeys("test", Keys.ENTER);
        //TakesScreeShot comes from Selenium
        TakesScreenshot ts = (TakesScreenshot) driver;//we creating an object of TakesScreenShot interface by downcasting it to the webdriver
       //File comes from Java
       File sourceFile= ts.getScreenshotAs(OutputType.FILE);// we are taking screenshot of a Type of File and storing it in a variable
         try {
             //FileUtils comes from commons.io.jar
             //destination of a new file// screenshots & Smartbear folders will be created automatically,png is extention to our file
             FileUtils.copyFile(sourceFile, new File("sceenshots/Smartbear/adminLogin.png"));//we are coping file we created on line 20
             //we should always go for png format
             //if we wont change the name of the file(adminLogin.png) it will get overriden everytime we run
         //throing IO(input ,output exception)
         }catch(IOException e){
             e.printStackTrace();
         }}}




