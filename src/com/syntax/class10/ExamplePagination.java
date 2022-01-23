package com.syntax.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ExamplePagination {
    public static String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

//        login code     username:Admin  password :Hum@nhrm123
//        for username
        driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");

//        for password
        driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("Hum@nhrm123");

//        for login btn
        WebElement loginBtn = driver.findElement(By.cssSelector("input#btnLogin"));
//        click login btn
        loginBtn.click();

//        click on PIM
        WebElement PIM=driver.findElement(By.cssSelector("a#menu_pim_viewPimModule"));
        PIM.click();
//        click on EmployeeList
        WebElement EmployeeList=driver.findElement(By.cssSelector("a#menu_pim_viewEmployeeList"));
        EmployeeList.click();

//        ------------------------------- dealing with the table------------------------
//AS STALE ELEMENT EXCEPTION IS THERE SO ITS REQUIRED TO FIND THESE ELEMENTS INSIDE THE LOOP EVERY TIME
//        *******************************
//        look for id 26335A
////1.   Locate the table and get the rows
//        List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
//1.2   locate the next btn
//        WebElement nxtBtn = driver.findElement(By.xpath("(//a[text()='Next'])[1]"));
//        ***********************************

//2.    iterate through the list and look for the requied id  26335A

//        declare a boolean that will be a flag to control
//        the refilling of our list with new enteries of the next page
//        until we have found the desired row or entery
        boolean notFound=true;
        while(notFound) {
//            relocate the rows after the page is refreshed to avaoid stale element exception
            //00.   Locate the table and get the rows
            List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
            for (int i = 0; i < tableRows.size(); i++) {

//            get the text out of the WebElement in list
                String text = tableRows.get(i).getText();

//            check if the row contains the id we are looking for
                if (text.contains("26335A")) {
                    System.out.println("the index of the id in table is : "+i);
                    String xpath="//table[@id='resultTable']/tbody/tr[" + (i + 1)+ "]/td/input";
                    WebElement checkbox = driver.findElement(By.xpath(xpath));
                    System.out.println("the xpath to the checkbox is : " +xpath);
                    checkbox.click();

//                  we found the desried row so we need to end the while loop
                    notFound=false;
//                 we found the desrie row so we donot want to iterate the rest
//                 of the list of webElements and waste our time
                   break;
                }
            }
//    click on next btn once the loop has traversed
//    the whole list (which contains all the eneteries of the current page)
//      but only click on next if you still havent found the required id
            if(notFound) {
                WebElement nxtBtn = driver.findElement(By.xpath("(//a[text()='Next'])[1]"));
                nxtBtn.click();
            }
        }


    }

}

//check the check  box associated with the id

