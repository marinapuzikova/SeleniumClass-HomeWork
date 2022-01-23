package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
    public static String url="https://jqueryui.com/droppable/";
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get(url);
        driver.switchTo().frame(0);
        //we are locating elements we will be interacting with
        WebElement dragable= driver.findElement(By.id("draggable"));
        WebElement drop= driver.findElement(By.xpath("//div[@class='ui-widget-header ui-droppable']"));
        //We are creating an Action class object
        Actions action =new Actions(driver);//driver is our execution object,
        // this what we perform actions with(clicking,sending keys and etc)
        //we specifing the element we want to interact with

        //action.dragAndDrop(dragable,drop).perform(); //we specifing the element we want to interact with(dragable,drop)
        action.clickAndHold(dragable).moveToElement(drop).release().build().perform();
        //when we using Action class and we have more than one action,we need to use build() method
        //after last action and before perform() method
        //it builds all action in the one and then perform
    }}

