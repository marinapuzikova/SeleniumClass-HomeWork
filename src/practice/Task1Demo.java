package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Task1Demo {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://syntaxprojects.com/window-popup-modal-demo.php");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        String mainPageHandle = driver.getWindowHandle();
        WebElement instagramBtn = driver.findElement(By.xpath("//a[@title='Follow @syntaxtech on Instagram']"));
        WebElement facebookBtn = driver.findElement(By.xpath("//a[@title='Follow @syntaxtech on Facebook']"));
        WebElement faceAndInsta = driver.findElement(By.linkText("Follow Instagram & Facebook"));
        instagramBtn.click();
        facebookBtn.click();
        faceAndInsta.click();
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println(allWindowHandles.size());
        Iterator<String> it = allWindowHandles.iterator();
        while (it.hasNext()) { //we are iterating through handles
            String handle = it.next();//getting the next handle
            if (!mainPageHandle.equals(handle)) {
                driver.switchTo().window(handle);//switching to a window which is not equal to main page handle
                String title = driver.getTitle();
                System.out.println(title);
                driver.close();
            }
        }
        driver.switchTo().window(mainPageHandle);//switching back to main window
        instagramBtn.click();
    }
}
