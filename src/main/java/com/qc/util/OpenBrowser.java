package com.qc.util;

import com.qc.reportutils.ExtentReportUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class OpenBrowser {
    public static WebDriver driver;
    public void BrowserFun(String BrowserName)
    {
        switch(BrowserName){

               case "CHROME":

                   System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
                   //Above statement for removing --[SEVERE]: Timed out receiving message from renderer: 0.100
                   System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
                   driver=new ChromeDriver();
                   driver.manage().window().maximize();
                 break;
            case "MOZILA":
                System.setProperty("","");
                driver=new ChromeDriver();
                break;
            default:
                System.out.println("No Browser Found ");

        }


    }


    public void getUrl(String Url)
    {
        driver.get(Url);
    }
}
