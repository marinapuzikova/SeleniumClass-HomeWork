package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class driverCommands {


    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        //go to the website Ebay.com
        driver.get("http://ebay.com");

//       get all the links that are there on ebay.com
//        as we have multiple elements with tag name 'a' so we use driver.findElements
//        as there are multiple elements so we need to store it in list of WebElements
        List<WebElement> links = driver.findElements(By.tagName("a"));

//        print the size of list
        System.out.println("The size of list containing links is : " + links.size());

//        print  the text of all the links

        for (WebElement link : links) {
//            get the text out of the webElement link
            String linkText = link.getText();
//     only print the links that have some text and ignore the rest
//            !not
            if (!linkText.isEmpty()) {
                System.out.println(linkText);
//             print all the links also along with the text
//             use the method .getAtrribute to have the value of a particular attribute in the tag

//               <a href"htpps://link.com">linktext<a>
                String linkAddress = link.getAttribute("href");
//               print the attribute "href" value
                System.out.println(linkAddress);

                System.out.println("------------------------");
            }

        }
    }
}


