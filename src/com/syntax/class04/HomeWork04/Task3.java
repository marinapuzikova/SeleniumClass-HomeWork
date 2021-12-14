package com.syntax.class04.HomeWork04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3 {
    /*
    task3:(use css)
goto:http://syntaxprojects.com/input-form-demo.php
fill in all the textboxes in the form (edited)
     */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://syntaxprojects.com/input-form-demo.php");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input.form-control")).sendKeys("Alex");
        driver.findElement(By.cssSelector("input[placeholder *='Last']")).sendKeys("White");
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("alexwhite@gmail.com");
        driver.findElement(By.cssSelector("input[data-bv-field *='pho']")).sendKeys("3475003322");
        driver.findElement(By.cssSelector("input[data-bv-field *='addre']")).sendKeys("102 street");
        driver.findElement(By.cssSelector("input[name='city']")).sendKeys("Rego Park");
        driver.findElement(By.cssSelector("select[name='state']")).sendKeys("NY");
        driver.findElement(By.cssSelector("input[placeholder *='Zip']")).sendKeys("11374");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[placeholder *='Web']")).sendKeys("alexwhite.com");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("textarea[name='comment']")).sendKeys("Alex White project");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[onclick='resetForm();']")).click();
        Thread.sleep(2000);
        driver.quit();


    }
}
