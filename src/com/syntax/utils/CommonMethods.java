package com.syntax.utils;

import com.syntax.testBase.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

/**
 * sends text to a given Element
 * @param element-->WebElement
 * @param text-->the text that you want to send
 */

public class CommonMethods extends BaseClass {
    public static void sendText(WebElement element,String text){
        element.clear();

        element.sendKeys(text);
    }

    public void switchToFrame(int index){
        driver.switchTo().frame(index);

    }
    public static void takeTheScreenShot(String filename){
        //        take screen shot
        TakesScreenshot ts=(TakesScreenshot) driver;//driver is a static variable thats why we dont need to create an object of that class
//        take screen shot
        File screenShot = ts.getScreenshotAs(OutputType.FILE);
//        we need to save the screenshot file in our computer

//we are throwing an exception because if we cant create a file or cant get a screenshot of it and we are trying to cope
// not excisting file then it will throw us an exception
        try {

            FileUtils.copyFile(screenShot,new File("screenshots/HRMS/"+filename+".png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
