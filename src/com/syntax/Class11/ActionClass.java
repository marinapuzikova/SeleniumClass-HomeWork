package com.syntax.Class11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class ActionClass {
    public static String url = "https://jqueryui.com/droppable/";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
//        switch to the iframe
        driver.switchTo().frame(0);
//       locate the draggable
        WebElement draggable = driver.findElement(By.cssSelector("div#draggable"));
//        locate the dropoff location
        WebElement dropoff = driver.findElement(By.cssSelector("div#droppable"));

        Actions action =new Actions(driver);
//          drag the source to drop off
       //action.dragAndDrop(draggable,dropoff).perform();

//        whenerver more then two methods use build
        action.clickAndHold(draggable).moveToElement(dropoff).release().build().perform();

    }
}
