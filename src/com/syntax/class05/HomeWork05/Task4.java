package com.syntax.class05.HomeWork05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Task4 {
    /*
    Go to ebay.com
get all the categories and print them in the console
select Computers/Tablets & Networking
click on search
verify the title of page
     */
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        List<WebElement> allCategories= driver.findElements(By.cssSelector("select#gh-cat"));
        String selectCategory="Computers/Tablets & Networking";
        for(WebElement categories:allCategories){
            String categoriesText= categories.getText();
            System.out.println(categoriesText);
            if(categoriesText.equalsIgnoreCase(selectCategory)){

                categories.click();
            }
        }
        Thread.sleep(3000);
        WebElement searchButton= driver.findElement(By.cssSelector("input#gh-btn"));
        searchButton.click();
        System.out.println("Title of the page "+driver.getTitle());
    }
}
