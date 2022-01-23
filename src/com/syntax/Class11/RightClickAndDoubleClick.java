package com.syntax.Class11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class RightClickAndDoubleClick {
    public static String url = "http://demo.guru99.com/test/simple_context_menu.html";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);


//    WebElement rightclick = driver.findElement(By.xpath("//span[text()='right click me']"));
        Actions action= new Actions(driver);
//        action.contextClick(rightclick).perform();


//        locate double click
        WebElement doubleclick= driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
        action.doubleClick(doubleclick).perform();


    }
}
