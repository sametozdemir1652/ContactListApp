package utilities;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ReusableMethods {







        public static void wait(int saniye) {
            try {
                Thread.sleep(saniye * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public static void alertWait(int number) {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(number));
            wait.until(ExpectedConditions.alertIsPresent());

        }

        //Alert ACCEPT
        public static void alertAccept() {
            Driver.getDriver().switchTo().alert().accept();
        }

        //Alert DISMISS
        public static void alertDismiss() {
            Driver.getDriver().switchTo().alert().dismiss();
        }

        //Alert getText()
        public static void alertText() {
            Driver.getDriver().switchTo().alert().getText();
        }

        //Alert promptBox
        public static void alertprompt(String text) {
            Driver.getDriver().switchTo().alert().sendKeys(text);
        }





        //ScreenShot
        public static void allPageScreenShot() {
            String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
            String dosyaYolu = "TestOutput/screenshot/screenshot" + tarih + ".png";
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            try {
                FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


}
