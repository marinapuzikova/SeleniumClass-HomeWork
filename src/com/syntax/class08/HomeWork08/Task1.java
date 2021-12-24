package com.syntax.class08.HomeWork08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Task1 {
    /*
    goto http://syntaxprojects.com/window-popup-modal-demo.php
click on follow on instagram
get the title of new window and print it on the console
     */
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://syntaxprojects.com/window-popup-modal-demo.php");
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        WebElement instagramBtn= driver.findElement(By.linkText("Follow On Instagram"));
        instagramBtn.click();
        Set<String> allHandles = driver.getWindowHandles();
        Iterator<String> iterator= allHandles.iterator();
        while(iterator.hasNext()){
            String handler= iterator.next();
            driver.switchTo().window(handler);
            if(driver.getCurrentUrl().equalsIgnoreCase("https://www.instagram.com/accounts/login/")) {
                System.out.println(driver.getTitle());
            }
        }
        driver.quit();
    }
}
