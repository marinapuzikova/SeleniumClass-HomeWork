package com.syntax.class02.HomeWork02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWorkTask02 {
    /*
    navigate to fb.com
click on create new account
fill up all the textboxes
click on sign up button
close the pop up
close the browser
     */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fb.com");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Create new account")).click();
        Thread.sleep(3000);
        driver.findElement(By.name("firstname")).sendKeys("John");
        driver.findElement(By.name("lastname")).sendKeys("Whit");
        driver.findElement(By.name("reg_email__")).sendKeys("john.white@gmail.com");
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("john.white@gmail.com");
        driver.findElement(By.id("password_step_input")).sendKeys("john87569");
        driver.findElement(By.name("websubmit")).click();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//*[@id=\"u_6_9_VF\"]")).click();
        driver.quit();
    }
}
