package com.syntax.class04.HomeWork04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task02 {
    /*
    Task2:(use advance xpath)
RMS Application Negative Login:
Open chrome browser
Go to “http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login”
Enter valid username
enter wrong password
Click on login button
Verify error message with text “Invalid Credenitals” is displayed.
     */
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement username = driver.findElement(By.xpath("//span[text()='Username']/preceding-sibling::input"));
        username.sendKeys("Admin");
        Thread.sleep(2000);
        WebElement password = driver.findElement(By.xpath("//span[text()='Password']/preceding-sibling::input"));
        password.sendKeys("Admin001");
        WebElement loginButton = driver.findElement(By.xpath("//div[@id='divLoginButton']/child::input"));
        loginButton.click();
        WebElement invalidCredentials = driver.findElement(By.xpath("//input[@id='btnLogin']/following-sibling::span"));
        System.out.println("User entered " + invalidCredentials.getText());
        driver.quit();


    }
}
