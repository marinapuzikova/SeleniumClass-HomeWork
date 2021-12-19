package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class checkBoxes {
    public static void main (String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//        navigate to syntax checkbox demo and check the first chekbox
        driver.get("https://syntaxprojects.com/basic-checkbox-demo.php");

//        locate the webElement checkBox
        WebElement singleCheckBox = driver.findElement(By.cssSelector("input#isAgeSelected"));
//        check the check Box
        singleCheckBox.click();
        Thread.sleep(2000);

//        uncheck the check box
        singleCheckBox.click();


//        Task2 check all the text boxes simultaneously
//        Select a xpath that has common attribute value for all the checkboxes
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@class='cb1-element']"));
//        print the number of checkBoxes
        int size = checkBoxes.size();
        System.out.println("The total number of checkboxes is : "+ size);


//        iterate through each WebElement
        for(WebElement checkBox :checkBoxes){

//           select the check box with the text  Option 3
//          get the attribute "value" of all checkbox

            String valueofAttribute = checkBox.getAttribute("value");
            System.out.println(valueofAttribute);

//            check only whose value is "Option-3"
            if(valueofAttribute.contains("Option-3")){
//                click on the checkbox whose attribute value nis Option-3
                checkBox.click();
            }

        }



    }
}
