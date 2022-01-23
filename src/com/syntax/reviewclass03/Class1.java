package com.syntax.reviewclass03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//        navigate to syntax checkbox demo and check the first chekbox
        driver.get("http://syntaxprojects.com/basic-radiobutton-demo.php");

        WebElement radioButton = driver.findElement(By.xpath("(//*[@value='Male'])[2]"));
        System.out.println(radioButton.isDisplayed());

        System.out.println(radioButton.isEnabled());

        if(radioButton.isEnabled()){
            radioButton.click();
        }

        driver.quit();

    }
}
