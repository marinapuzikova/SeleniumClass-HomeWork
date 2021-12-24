package com.syntax.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.uitestpractice.com/Students/Switchto");
        driver.manage().window().maximize();

//     handling simple alert
//     enable the alert
        driver.findElement(By.cssSelector("button#alert")).click();
        Thread.sleep(2000);
//        switch the focus of selenium
        Alert simpleAlert = driver.switchTo().alert();//this is how we switch our focus to alert
        simpleAlert.accept();


//        handling confirmation alert
//        enabling the confirmation alert
        driver.findElement(By.cssSelector("button#confirm")).click();

//        switch the focus
        Alert confirmationAlert = driver.switchTo().alert();
//        get the text from this alert
        System.out.println(confirmationAlert.getText());

//        cancel the alert
        confirmationAlert.dismiss();


        Thread.sleep(2000);
//        prompt alert
//        enable
        driver.findElement(By.cssSelector("button#prompt")).click();

//        switch focus
        Alert promptAlert = driver.switchTo().alert();


        promptAlert.sendKeys("Hello we need to sleep");


        // accept
        promptAlert.accept();


    }
}
