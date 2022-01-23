package com.syntax.reviewclass03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Class5 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//        navigate to syntax checkbox demo and check the first chekbox
        driver.get("http://syntaxprojects.com/dynamic-data-loading-demo.php");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement newUserOption = driver.findElement(By.xpath("//*[@id='save']"));
        newUserOption.click();

        driver.quit();

    }
}
