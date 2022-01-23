package com.syntax.pages;

import com.syntax.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageWithPageFactory extends CommonMethods {
    //@FindBy -->annotation hellps to locate and identify elements
    //in FrameWork we use this format of locating  elements
    @FindBy(id = "txtUsername")
    public WebElement username; //we are creating variables

    @FindBy(xpath = "//input[@id = 'txtPassword']")
    public WebElement password;

    @FindBy(css = "input#btnLogin")
    public WebElement loginBtn;
//we initializing variables through Constructor



    public LoginPageWithPageFactory() {
                                //driver -->is an Object which initialize all elements
                                //this -->what variables(or which Page) we need to initialize
        PageFactory.initElements(driver, this);
   }
}
