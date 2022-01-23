package com.syntax.Class11;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class JsExecutorDemo2 {
    public static String url = "http://amazon.com";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);


        JavascriptExecutor js= (JavascriptExecutor) driver;
//        scrool down
        js.executeScript("window.scrollBy(0,4000)");
//wait
        Thread.sleep(2000);
        //        scrool up
        js.executeScript("window.scrollBy(0,-4000)");

//        scroll till the element is in view
        WebElement backtoTop = driver.findElement(By.cssSelector("span.navFooterBackToTopText"));

        js.executeScript("arguments[0].scrollIntoView(true)",backtoTop);

        js.executeScript("arguments[0].click()",backtoTop);


    }
}

