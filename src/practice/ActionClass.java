package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass {
    public static String url = "http://amazon.com";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement accountsAndLists = driver.findElement(By.id("nav-link-accountList"));//we locating the element we will be interacting with
        //We are creating an Action class object
        Actions action=new Actions(driver);//driver is our execution object,this what we perform actions with(clicking,sending keys and etc)
                              //we specifing the element we want to interact with (accountsAndLists)
        action.moveToElement(accountsAndLists).perform();
    }
}
