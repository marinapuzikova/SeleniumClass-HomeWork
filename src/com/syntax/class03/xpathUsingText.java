package com.syntax.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class xpathUsingText {
    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://syntaxprojects.com/");
        driver.manage().window().maximize();
        //driver.findElement(By.xpath("//a[text()='erAlts & Modals']"));//this going to find element
        WebElement allertLink =driver.findElement(By.xpath("//a[text()='erAlts & Modals']"));//
        allertLink.click();

    }
}
