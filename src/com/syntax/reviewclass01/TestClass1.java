package com.syntax.reviewclass01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass1 {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        String url = driver.getCurrentUrl();//in return we are getiing String data type
        System.out.println("The current URL loaded in browser is: "+url);
        String title = driver.getTitle();//title will always in the tab
        System.out.println("The current title of the page is : "+title);
        driver.quit();
    }
}
