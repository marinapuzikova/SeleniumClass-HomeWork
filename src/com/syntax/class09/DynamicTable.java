package com.syntax.class09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DynamicTable {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        // Login to the website
        driver.findElement(By.cssSelector("input#ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.cssSelector("input#ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.cssSelector("input#ctl00_MainContent_login_button")).click();
        //get all the rows
        List<WebElement> rows= driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr"));
        System.out.println(rows.size());
        //print all the rows
        //we start from 1 in the loop because we dont want to get names of columns
        for(int i=1;i< rows.size();i++){
            //get the text
            String rowText=rows.get(i).getText();
            System.out.println(rowText);
            //Check the checkbox if the row has the product screensaver
            if(rowText.contains("Canada")){
                List<WebElement>checkboxes=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[1]"));
                checkboxes.get(i-1).click();
            }
        }
    }
}
