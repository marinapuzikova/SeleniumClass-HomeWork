package com.syntax.class05.HomeWork05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        /*
        HW1: Amazon link count:
Open chrome browser
Go to “https://www.amazon.com/”
Get all links
Get number of links that has text
Print to console only the links that has text
         */

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("The number of all links on amazon " + allLinks.size());

        for(WebElement link:allLinks){
            String linkText=link.getText();

            if(!linkText.isEmpty()) {
                System.out.println(linkText);
                String linkAddress= link.getAttribute("href");
                System.out.println(linkAddress);
            }
        }
        driver.quit();

    }
}
