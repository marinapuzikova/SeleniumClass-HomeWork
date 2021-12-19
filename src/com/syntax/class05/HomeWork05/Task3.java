package com.syntax.class05.HomeWork05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Task3 {
    /*
    Go to facebook
click on create new account  page
Fill out the whole form
Click signup
     */
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fb.com");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        WebElement newAccount = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        newAccount.click();
        Thread.sleep(1000);
        WebElement firstName=driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys("Ann");
        Thread.sleep(1000);
        WebElement lastName=driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Klein");
        WebElement email= driver.findElement(By.xpath("//input[@name='reg_email__']"));
        email.sendKeys("annklein123@gmail.com");
        Thread.sleep(1000);
        WebElement emailConfirm= driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
        emailConfirm.sendKeys("annklein123@gmail.com");
        Thread.sleep(1000);
        WebElement password=driver.findElement(By.xpath("//input[@autocomplete='new-password']"));
        password.sendKeys("ann37618");
        WebElement dropDownMonth = driver.findElement(By.cssSelector("select#month"));
        Select selectMonth=new Select(dropDownMonth);//use the Select class to select from drop down
        selectMonth.selectByIndex(6);
        Thread.sleep(1000);

        WebElement drobDownDay=driver.findElement(By.xpath("//select[@name='birthday_day']"));
        Select selectDay=new Select(drobDownDay);
        selectDay.selectByValue("1");
        Thread.sleep(1000);

        WebElement dropDownYear=driver.findElement(By.cssSelector("select#year"));
        Select selectYear=new Select(dropDownYear);
        selectYear.selectByValue("1990");
        Thread.sleep(1000);

        WebElement radioButton=driver.findElement(By.xpath("//input[@value='1']"));
        radioButton.click();
        Thread.sleep(2000);
        WebElement submitButton=driver.findElement(By.xpath("//button[@name='websubmit']"));
        submitButton.click();

    }
}
