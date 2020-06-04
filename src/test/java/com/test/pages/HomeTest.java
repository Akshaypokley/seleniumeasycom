package com.test.pages;



import com.qc.pages.HomePage;
import com.qc.reportutils.ExtentReportUtils;
import com.qc.util.SendMailSSLWithAttachment;
import com.qc.util.ZipFiles;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Priority;
import org.jsoup.helper.HttpConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import static com.qc.reportutils.TakeScreenshot.capture;

public class HomeTest extends HomePage {
    HomePage homePage;
    ExtentReports extent ;
    String screenShotPath;
    ExtentTest extentTest;
   ZipFiles zipFiles;

    @BeforeClass
    public void BrowserTest() {
        extent=ExtentReportUtils.CreatextenReport();
        BrowserFun("CHROME");
        getUrl("https://www.seleniumeasy.com/");
        homePage = new HomePage();
    }

    @Test(priority = 1)
    public  void HomePageTest() throws Exception {      extentTest=extent.startTest("HomePageTest");
        try {

    try{
        if (homePage.getHomelogo().isDisplayed()) ;
        extentTest.log(LogStatus.INFO,"Validate Home page logo.");
    }
    catch (NoSuchElementException n)
     {
    extentTest.log(LogStatus.FAIL,"TestCase Fail "+n.getMessage());
    extentTest.log(LogStatus.FAIL, "Snapshot below: " + extentTest.addScreenCapture("./screenshots/" + capture(driver)));

    }

        String txt = homePage.getDemolink().getText();
                System.out.println("Link Name::" + txt);
                extentTest.log(LogStatus.INFO,"Compaired Acutual link with Expected value.");
                Assert.assertEquals(txt, "Demo Website!", "Demo Link Not availbale ");
                extentTest.log(LogStatus.INFO,"Click on Demo link");
                homePage.clickDemolink();
                extentTest.log(LogStatus.PASS,"HomePage test case passed befour Click on "+txt+"link");


        }  catch (AssertionError ae) {
            System.out.println(ae.getMessage());
            extentTest.log(LogStatus.FAIL,"TestCase Fail "+ae.getMessage());
        }
        catch (Exception e) {
            extentTest.log(LogStatus.FAIL,"TestCase Fail "+e.getMessage());
        }


    }

    @Test(priority = 2)
    public void ValidateDemoPage() throws Exception {
         extentTest=extent.startTest("ValidateDemoPage");

        try {
            extentTest.log(LogStatus.INFO,"Validate Demo page txt with exepectd value .");
            Thread.sleep(8000);
            try {
                String demotxt = homePage.getLogoTXT().getText();
                System.out.println(demotxt);
                System.out.println(demotxt);
                Thread.sleep(8000);
                Assert.assertEquals(demotxt, "Complete Testing Tutorials");
            }catch (NoSuchElementException n)
            {
                extentTest.log(LogStatus.FAIL,"TestCase Fail "+n.getMessage());
                extentTest.log(LogStatus.FAIL, "Snapshot below: " + extentTest.addScreenCapture("./screenshots/" + capture(driver)));

            }

        } catch (NoSuchElementException e) {
            extentTest.log(LogStatus.FAIL,"TestCase Fail "+e.getMessage());
            extentTest.log(LogStatus.FAIL, "Snapshot below: " + extentTest.addScreenCapture("./screenshots/" + capture(driver)));
        } catch (AssertionError ae) {
            System.out.println(ae);
            extentTest.log(LogStatus.FAIL,"TestCase Fail "+ae.getMessage());
           extentTest.log(LogStatus.FAIL, "Snapshot below: " + extentTest.addScreenCapture("./screenshots/" + capture(driver)));
        }catch (Exception d)
        {

            extentTest.log(LogStatus.FAIL,"TestCase Fail "+d.getMessage());
            extentTest.log(LogStatus.FAIL, "Snapshot below: " + extentTest.addScreenCapture("./screenshots/" + capture(driver)));

        }



    }

    @Test(priority = 3,enabled = false)
    public void FindoutBrokenLinks() throws Exception

    {

        extentTest=extent.startTest("FindoutBrokenLinks");
        extentTest.log(LogStatus.INFO,"Get the all links ");

        Thread.sleep(4000);
        try {
            try{
                String DemopageTitle=driver.getTitle();
                extentTest.log(LogStatus.INFO,"Get Title of Demo Page "+DemopageTitle);
                Assert.assertEquals(DemopageTitle,"Selenium Easy - Best Demo website to practice Selenium Webdriver Online");

                List<WebElement> alllinks = driver.findElements(By.tagName("a"));
                alllinks.add(driver.findElement(By.tagName("img")));
                extentTest.log(LogStatus.INFO, "Size of Links are" + alllinks.size());
                List<WebElement> Activelinks=new ArrayList<WebElement>();
                for (WebElement links : alllinks) {
                            int i=0;
                    if(links.getAttribute("href")!=null &&(!links.getAttribute("href").contains("javascripts")))
                    {
                        Activelinks.add(links);
                            i++;
                            if (i>alllinks.size()) {
                            break;
                        }else {
                            HttpURLConnection connection= (HttpURLConnection) new URL(links.getAttribute("href")).openConnection();
                            connection.connect();
                            String responces=connection.getResponseMessage();
                            connection.disconnect();
                            String Altxt=links.getText();
                            extentTest.log(LogStatus.INFO, "Size of Links are" +Altxt+"::"+responces);
                            System.out.println(Altxt+"::"+responces);
                            }
                    }
                }

            }catch (AssertionError s)
            {
                extentTest.log(LogStatus.FAIL,"Test Case fail due to the "+s.getMessage());
                extentTest.log(LogStatus.FAIL,"Snapshot below:" +extentTest.addScreenCapture("./screenshots/" + capture(driver)));
            }
            }catch (NoSuchElementException e)
            {
                extentTest.log(LogStatus.FAIL,"Test Case fail due to the "+e.getMessage());
                extentTest.log(LogStatus.FAIL,"Snapshot below:" +extentTest.addScreenCapture("./screenshots/" + capture(driver)));

            }

        catch (Exception d)
        {

            extentTest.log(LogStatus.FAIL,"TestCase Fail "+d.getMessage());
            extentTest.log(LogStatus.FAIL, "Snapshot below: " + extentTest.addScreenCapture("./screenshots/" + capture(driver)));

        }
    }
    @Test(priority = 4)
    public void SkipedTestCases()
    {
        extentTest=extent.startTest("SkipedTestCases");
        extentTest.log(LogStatus.SKIP,"Method Not ready for testing ---SkipedTestCases");
        throw new SkipException("Method Not ready for testing ---SkipedTestCases");


    }



    @AfterClass
    public void tearDown() throws Exception {

        driver.quit();
        extent.endTest(extentTest); //ending test and ends the current test and prepare to create html report
        extent.flush();
        zipFiles=new ZipFiles();
        zipFiles.ZipfolderFun();

        }

    }



