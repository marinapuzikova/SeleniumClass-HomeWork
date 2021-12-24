package com.syntax.class07.HomeWork07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Task1 {
    /*
    goto the Website https://syntaxprojects.com/window-popup-modal-demo.php
click on follow on instagram
click on facebook.com
get all windows handles
     */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://syntaxprojects.com/window-popup-modal-demo.php");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement instagramBtn = driver.findElement(By.xpath("//a[@title='Follow @syntaxtech on Instagram']"));
        WebElement facebookBtn = driver.findElement(By.xpath("//a[@title='Follow @syntaxtech on Facebook']"));
        instagramBtn.click();
        Thread.sleep(2000);
        facebookBtn.click();
        Thread.sleep(2000);

        Set<String> allWindowsHandles=driver.getWindowHandles();
        System.out.println(allWindowsHandles.size());

        Iterator<String> it = driver.getWindowHandles().iterator();
        String mainWindowHandle = it.next();
        String instagramWindowHandle = it.next();
        String facebookWindowHandle = it.next();

        System.out.println("Main window handle: " + mainWindowHandle);
        System.out.println("Instagram window handle: " + instagramWindowHandle);
        System.out.println("Facebook window handle: " + facebookWindowHandle);



    }
}

