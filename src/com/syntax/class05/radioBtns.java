package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class radioBtns {
    public static void main (String[] args) {

        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("http://syntaxprojects.com/basic-radiobutton-demo.php");

        //getting the radio btn webElement
        WebElement femaleRadioBtn = driver.findElement(By.xpath("//input[@value='Female'][@name='optradio']"));
        //click the radio btn Female
//        femaleRadioBtn.click();

//        check if the radio btn is displayed
        boolean isDisplayed = femaleRadioBtn.isDisplayed();
        System.out.println("The female radio Btn is displayed on the webPage   :" +isDisplayed);

//        check if the radio btn is enabled
        boolean isEnabled = femaleRadioBtn.isEnabled();
        System.out.println("The female   radio Btn is Enabled on the webPage  :" +isEnabled);

//        check if the female radio btn is Selected
        boolean isSelected=femaleRadioBtn.isSelected();
        System.out.println("The female   radio Btn is Selected on the webPage  :" +isSelected);


//         Select the female radio btn only if its Enabled
        if(isEnabled){
            femaleRadioBtn.click();
        }

//        after clicking the btn print if its Selected or not
        isSelected=femaleRadioBtn.isSelected();
        System.out.println("The female   radio Btn is Selected on the webPage  :" +isSelected);


    }
}
