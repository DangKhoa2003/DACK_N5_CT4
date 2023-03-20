package test;

import driver.driverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Test
public class testcase04 {
    public static void testcase04() {
        /*Chức năng so sánh 2 sản phẩm
            B1: vào trang web Yame
            B2: Click vào bộ sưu tập
            B3: Click vào Y2010 ORIGINALS
            B4: Click vào sản phẩm
            B5: Click vào sản phẩm liên quan để so sánh
            B6: Chụp màn hình

        *
        * */
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //  B1: vào trang web Yame
            driver.get("https://yame.vn/home/v2022");

            //B2: Click vào bộ sưu tập
            By leftClickPlace = By.xpath("//ul[@class='site-menu js-clone-nav d-none d-lg-block']//a[contains(text(),'Bộ Sưu Tập')]");
            WebElement leftClickPlaceElem = driver.findElement(leftClickPlace);
            leftClickPlaceElem.click();

//         B3: Click vào Y2010 ORIGINALS
            By clickOriginals = By.xpath("//a[normalize-space()='Y2010 ORIGINALS']");
            WebElement clickY2010 = driver.findElement(clickOriginals);
            clickY2010.click();
            Thread.sleep(2000);
//         B4: Click vào sản phẩm

            WebElement TShirt = driver.findElement(By.xpath("//body/div[@class='site-wrap']/div[@class='container-fluid mb-4']/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]/img[1]"));


            TShirt.click();
            Thread.sleep(2000);
//           B5: Click vào sản phẩm liên quan để so sánh
            WebElement nonChuY = driver.findElement(By.xpath("//img[@class='img-responsive']"));
            nonChuY.click();
            Thread.sleep(2000);

            // B6: Chụp màn hình
            TakesScreenshot screenshot = ((TakesScreenshot) driver);
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            File destFile = new File(".\\src\\test\\java\\test\\testcase04.png");
            FileHandler.copy(srcFile, destFile);
            Thread.sleep(2000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            //Close the driver after test execution
            driver.quit();
        }
    }
}