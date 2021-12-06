package com.syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class launchingBrowser {
    public static void main(String[] args) {
        //the path to the driver,built in fiture,always
        //we will use this for chrome driver          // my folder,where drive located
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        // for windows add extension .exe
        // i am creating new inctance of the chrome browser
        WebDriver driver = new ChromeDriver(); // launching the browser
        driver.get("https://www.google.com/");//passing url of website which we want to open
        String url = driver.getCurrentUrl();//in return we are getiing String data type
        System.out.println("The current URL loaded in browser is: "+url);
        String title = driver.getTitle();//title will always in the tab
        System.out.println("The current title of the page is : "+title);
        driver.quit();
    }
}
