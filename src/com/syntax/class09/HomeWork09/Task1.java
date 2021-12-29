package com.syntax.class09.HomeWork09;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Task1 {
    /*
    goto https://chercher.tech/practice/explicit-wait
1.click on open an alert after 5 sec and then using explicit wait manage that alert
2.click on display button after 10 sec and once the button is displayed  print the status of isDisplayed() (edited)
     */
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://chercher.tech/practice/explicit-wait");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        WebElement openAlertBtn = driver.findElement(By.cssSelector("button#alert"));
        openAlertBtn.click();
        WebDriverWait wait1 = new WebDriverWait(driver, 20);
        wait1.until((ExpectedConditions.alertIsPresent()));
        Alert simpleAlert = driver.switchTo().alert();//this is how we switch our focus to alert
        simpleAlert.accept();
        WebElement displayButton = driver.findElement(By.cssSelector("button#display-other-button"));
        displayButton.click();
        WebDriverWait wait2 = new WebDriverWait(driver, 20);
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button#hidden")));
        WebElement hiddenBtn = driver.findElement(By.cssSelector("button#hidden"));
        System.out.println("Status of hidden button is " + hiddenBtn.isDisplayed());
        driver.quit();

    }
}
