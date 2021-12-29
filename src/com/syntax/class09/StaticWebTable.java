package com.syntax.class09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class StaticWebTable {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://syntaxprojects.com/table-search-filter-demo.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        //print all the rows of the webtable in the console
        //1step locate all rows in the table using xpath and save it in the variable

        List<WebElement> tableRows=driver.findElements(By.xpath("//*[@id=\"task-table\"]/tbody/tr"));
        //print the number of rows
        System.out.println("Number of rows "+tableRows.size());
        //iterate
        for(WebElement row:tableRows){
            String text=row.getText();
            System.out.println(text);
        }

        //3 Step print all the headers
        List<WebElement> headers=driver.findElements(By.xpath("//*[@id='task-table']/thead/tr"));
        for(WebElement head:headers){
            String textHeader=head.getText();
            System.out.println(textHeader);
        }
        //same but using iterator
        List<WebElement> header= driver.findElements(By.xpath("//*[@id='task-table']/thead/tr"));
        Iterator<WebElement> it = header.iterator();
        while (it.hasNext()){
            WebElement next = it.next();
            String nextText = next.getText();
            System.out.println(nextText);
        }

//print just second column
        List<WebElement> col2=driver.findElements(By.xpath("//*[@id='task-table']/tbody/tr/td[2]"));
        for(WebElement column:col2){
            System.out.println("the data for column 2 is "+column.getText());
        }

    }

    }
