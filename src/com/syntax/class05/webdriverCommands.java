package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class webdriverCommands {
    public static void main (String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//        get the url
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");

//        navigate to this website
//        fill the username  "AON"
//        delete the user name
//        fill the new user name "Tester"

//        find the WebElement
        WebElement userName = driver.findElement(By.cssSelector("input#ctl00_MainContent_username"));
//        send in the text AON
        userName.sendKeys("AON");
//        Delete the username entered
        Thread.sleep(2000);
        userName.clear();
//        Enter the new username
        Thread.sleep(2000);
        userName.sendKeys("Tester");

    }
}
