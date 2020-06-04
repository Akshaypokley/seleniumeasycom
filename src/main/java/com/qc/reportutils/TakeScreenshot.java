package com.qc.reportutils;

import com.qc.util.SendMailSSLWithAttachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TakeScreenshot {
    public static String capture(WebDriver driver) throws Exception
    {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        SimpleDateFormat sd = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        String DateStr = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
        String imageName = "screenshot"+DateStr+".png";
        String imagePath="test-output/Extent-report/screenshots/"+imageName;
        FileUtils.copyFile(scrFile, new File(imagePath));

        return imageName;
    }
}
