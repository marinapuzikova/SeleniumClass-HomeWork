package com.syntax.class06.HomeWork06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
    /*
    HW1:goto
http://syntaxprojects.com/javascript-alert-box-demo.php
handle all alerts one by one
1.simple
2.confirmaton
3.prompt
     */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://syntaxprojects.com/javascript-alert-box-demo.php");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        //     handling simple alert
        WebElement simpleAlertButton = driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']"));

        simpleAlertButton.click();
        Thread.sleep(2000);

// we are getting object of Alert Interface
        Alert simpleAlert = driver.switchTo().alert();//this is how we switch our Selenium  focus to alert.
        simpleAlert.accept();


//        handling confirmation alert
        WebElement confirmatioAlert = driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']"));
        confirmatioAlert.click();
        Alert confirmationAlert = driver.switchTo().alert();
        confirmationAlert.accept();//once we switch->we perform the action
        Thread.sleep(2000);


//       handling prompt alert
        WebElement promptAlertButton = driver.findElement(By.xpath("//button[@onclick='myPromptFunction()']"));
        promptAlertButton.click();
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("Hello from the other side");
        promptAlert.accept();


    }
}

