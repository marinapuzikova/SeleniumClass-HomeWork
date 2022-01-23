package com.syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandle {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://accounts.google.com/signup/v2/webcreateaccount?flowName=GlifWebSignIn&flowEntry=SignUp");
        driver.manage().window().maximize();
        //        get the address/handle of the page/window
        String signUpPageHandle = driver.getWindowHandle();
        System.out.println("The window handle for signup page is : "+signUpPageHandle);
//      locate the btns help,Terms,Privacy
        WebElement helpBtn = driver.findElement(By.xpath("//a[text()='Help']"));
        WebElement termBtn=driver.findElement(By.xpath("//a[text()='Terms']"));
        WebElement privacyBtn=driver.findElement(By.xpath("//a[text()='Privacy']"));

//        click on them to open up new Windows
        helpBtn.click();
        termBtn.click();
        privacyBtn.click();

//        we havent switched the focus so it is still on the main/home/signup page
//        to get all the windows handles
        Set<String> allWindowHandles = driver.getWindowHandles();
//        print the size of allWindowHandles
        System.out.println("number of window handles is    :"+ allWindowHandles.size());

//        inorder to print all window handles we need to iterate over the SET
        Iterator<String> it= allWindowHandles.iterator();
//        iterate through each window handle
        while(it.hasNext()){
//            switch to terms page
            String handle = it.next();
//            now switch to this particular handle/window
            driver.switchTo().window(handle);
//            i need to make sure this is my desired window/tab
            String title = driver.getTitle();
//            if condition
            if(title.equalsIgnoreCase("Google Account Help")) {
                System.out.println(title);
                break;
            }
        }



//        String signUpPageHandler=it.next();
//        String helpPageHandle = it.next();
//        String termPageHandle=it.next();
//        String privacyPageHandle=it.next();
//
//        System.out.println("The handle for signup page is :"+ signUpPageHandler);
//        System.out.println("The handle for helpPage page is :"+ helpPageHandle);
//        System.out.println("The handle for termpage is :"+ termPageHandle);
//        System.out.println("The handle for Privacypage is :"+ privacyPageHandle);

//        swtich to help page page

//        driver.switchTo().window(privacyPageHandle);
//        System.out.println(driver.getTitle());


    }
}
