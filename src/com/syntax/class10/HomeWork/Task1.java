package com.syntax.class10.HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task1 {
    /*the example done in class
you have to extend the same code
and write down the code to check the checkbox associated with the id that we found
share screen shot of the output
     */
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
        WebElement PIM = driver.findElement(By.cssSelector("a#menu_pim_viewPimModule"));
        PIM.click();
//        click on EmployeeList
        WebElement EmployeeList = driver.findElement(By.cssSelector("a#menu_pim_viewEmployeeList"));
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

//        decalre a boolean that will be a flag to control
//        the refilling of our list with new enteries of the next page
//        until we have found the desired row or entery
        boolean flag = true;
        while (flag) {
//            relocate the rows after the page is refreshed to avaoid stale element exception
            //00.   Locate the table and get the rows
            List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
            for (int i = 0; i < tableRows.size(); i++) {
                String text = tableRows.get(i).getText();

//            check if the row contains the id we are looking for
                if (text.contains("26335A")) {
                    System.out.println("We found text: " + text);

                    flag = false;
                    WebElement checkBox = driver.findElement(By.xpath("//input[@name='chkSelectRow[]']"));
                    checkBox.click();
                    break;
                }
            }

            if (flag) {
                WebElement nextButton = driver.findElement(By.xpath("(//a[text()='Next'])[1]"));
                nextButton.click();
            }

        }


    }

}




