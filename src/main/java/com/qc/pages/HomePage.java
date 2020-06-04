package com.qc.pages;

import com.qc.util.OpenBrowser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends OpenBrowser{

    @FindBy(xpath = "//*[@id='logo']/a/img")
    WebElement homelogo;

    @FindBy(linkText = "Demo Website!")
    WebElement Demolink;

    @FindBy(id = "site-slogan")
    WebElement LogoTXT;


    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public WebElement getHomelogo() {
        return homelogo;
    }

    public WebElement getDemolink() {
        return Demolink;
    }

    public void clickDemolink() {
        Demolink.click();
    }

    public WebElement getLogoTXT()
    {
        return LogoTXT;
    }
}


