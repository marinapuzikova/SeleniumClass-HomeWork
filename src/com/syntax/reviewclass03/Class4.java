package com.syntax.reviewclass03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class4 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//        navigate to syntax checkbox demo and check the first chekbox
        driver.get("https://demoqa.com/frames");

        driver.switchTo().frame("frame1");

        WebElement text = driver.findElement(By.xpath("//*[@id='sampleHeading']"));
        String actualText = text.getText();
        System.out.println(actualText);

        driver.quit();
    }
}
