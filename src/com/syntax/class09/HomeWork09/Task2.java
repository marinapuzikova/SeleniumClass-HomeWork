package com.syntax.class09.HomeWork09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task2 {
    /*goto http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/default.aspx
   and delete all the entries which have product mymoney and lives in us state*/
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/default.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        // Login to the website
        driver.findElement(By.cssSelector("input#ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.cssSelector("input#ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.cssSelector("input#ctl00_MainContent_login_button")).click();
        //get all the rows
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr"));
        //print all the rows
        for (int i = 1; i < rows.size(); i++) {
            //get the text
            String rowText = rows.get(i).getText();
            //Check the checkbox if the row has the product screensaver
            if (rowText.contains("MyMoney")) {
                List<WebElement> checkboxes = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[1]"));
                checkboxes.get(i - 1).click();
            }
        }
        WebElement deleteBtn= driver.findElement(By.cssSelector("input#ctl00_MainContent_btnDelete"));
        deleteBtn.click();

        driver.quit();
    }
}
