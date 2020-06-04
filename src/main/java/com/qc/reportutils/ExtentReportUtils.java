package com.qc.reportutils;




import com.qc.util.OpenBrowser;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;


public class ExtentReportUtils extends OpenBrowser {

   public static WebDriver driver;

   static ExtentReports extent;
    static ExtentTest test;


    public static ExtentReports CreatextenReport() {


        extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/Extent-report/SeleniumeasytestReport.html", true);
        extent.addSystemInfo("Host Name", "Akshay WIN");
        extent.addSystemInfo("User Name", "Akshay Automation Labs");
        extent.addSystemInfo("Environment", "QA");
        return extent;

       /* htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/SeleniumeasytestReport.html");
        htmlReporter.config().setDocumentTitle("Selenium easy project tested by Automation tools");
        htmlReporter.config().setReportName("Functional Report");
        htmlReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("HostName", "LocalHost");
        extent.setSystemInfo("OS", "Windows 10");
        extent.setSystemInfo("Tester Name", "Akshay Pokley");
        extent.setSystemInfo("Browser Name", "Chrome");
        return extent;*/
    }






}
