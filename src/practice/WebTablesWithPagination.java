package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebTablesWithPagination {
    public static String url = "http://syntaxprojects.com/table-pagination-demo.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        List<WebElement> tableRows = driver.findElements(By.xpath("//table[@class = 'table table-hover']/tbody/tr"));
        //we identify next button elemen
        WebElement nextButton = driver.findElement(By.xpath("//a[@class = 'next_link']"));
        boolean flag = true;

        while (flag) {//while loop is going help us to click on next button
            for (WebElement tableRow : tableRows) {//for loop is iterating through the rows
                String rowText = tableRow.getText();
                if (rowText.contains("Archy J")) {//we are looking for this condition
                    flag = false;//when condition is met we set flag to false
                    System.out.println(rowText);//getting text of the rows
                    break;
                }
            }
            if (flag) {//if condition is not met we going out of the lool and clicking next btn
                nextButton.click();//and we starting while loop again in order to get back to for loop
            }}}}


