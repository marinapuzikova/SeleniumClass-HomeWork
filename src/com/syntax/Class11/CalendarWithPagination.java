package com.syntax.Class11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CalendarWithPagination {
    public static String url = "https://www.sastaticket.pk/";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
//        locate the element calender and click on it
        WebElement calender = driver.findElement(By.xpath("(//span[@class='dt_label'])[1]"));
        calender.click();
//        locate the current month and year
        WebElement currentMonth = driver.findElement(By.xpath("(//div[@class='react-datepicker__current-month'])[1]"));//we using idex[1] cause we have 2 tables we are picking dates from
//      print the current month
        System.out.println(currentMonth.getText());

//        locate the next button
        WebElement nxtBtn = driver.findElement(By.xpath("//button[text()='Next Month']"));


//        loop through month till we reach our desired month
        boolean notFound=true;
        while(notFound){
            if(currentMonth.getText().equalsIgnoreCase("July 2022")){
                System.out.println(currentMonth.getText());
                notFound=false;

//                select the date
                List<WebElement> dates = driver.findElements(By.xpath("(//div[@class='react-datepicker__month'])[1]/div/div"));
//                loop throught the dates
                for(WebElement date :dates){
                    String dateText = date.getText();
                    if(dateText.equalsIgnoreCase("15")){
                        date.click();
                        break;
                    }
                }
            }
            else{
                nxtBtn.click();
            }

        }


    }
}
