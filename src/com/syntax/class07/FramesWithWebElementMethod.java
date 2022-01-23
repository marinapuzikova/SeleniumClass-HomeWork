package com.syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesWithWebElementMethod {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/frames");
        driver.manage().window().maximize();
        //      Switch to the desired frame1 using WebElement
        WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='frame1']"));
        driver.switchTo().frame(frame1);


//            switch to default
        driver.switchTo().defaultContent();
//            switch to the frame using index
        driver.switchTo().frame(3);
        System.out.println(driver.findElement(By.cssSelector("h1#sampleHeading")).getText());

    }
}
