package com.syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        String url=driver.getCurrentUrl();
        System.out.println("current url: "+url);
        String title= driver.getTitle();
        System.out.println("title of the page is: "+title);
        driver.close();
    }
}
