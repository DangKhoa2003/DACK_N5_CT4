package test;

import driver.driverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

@Test
public class testcase01 {
    public static void testcase01() {
//
        /*Chức năng lọc sản phẩm (vì trang web k có chức năng lọc nên thay thế bằng vào danh mục sản phẩm)
            B1: vào trang web Yame
            B2: Xác minh tiêu đề của tranng
            B3: Click vào bộ sưu tập
            B4: Click vào Y2010 ORIGINALS
            B5 Chụp màn hình
        *
        * */
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            // Step 1. Go to https://yame.vn/home/v2022
            driver.get("https://yame.vn/home/v2022");

            // Step 2. Verify Title of the page
            String pageURL = driver.getCurrentUrl();
            String pageTitle = driver.getTitle();
            System.out.println(pageURL);
            System.out.println(pageTitle);

            // Step 3. Click vào bộ sưu tập
            By leftClickPlace = By.xpath("//ul[@class='site-menu js-clone-nav d-none d-lg-block']//a[contains(text(),'Bộ Sưu Tập')]");
            WebElement leftClickPlaceElem = driver.findElement(leftClickPlace);
            leftClickPlaceElem.click();

            // Step 4. Click vào Y2010 ORIGINALS
            By clickOriginals = By.xpath("//a[normalize-space()='Y2010 ORIGINALS']");
            WebElement clickY2010 = driver.findElement(clickOriginals);
            clickY2010.click();

            // Debug purpose only
            Thread.sleep(2000);

            // Step 5. Chụp màn hình
            TakesScreenshot screenshot =((TakesScreenshot)driver);
            File srcFile= screenshot.getScreenshotAs(OutputType.FILE);
            File destFile = new File(".\\src\\test\\java\\test\\testcase01.png");
            FileHandler.copy(srcFile, destFile);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Quit browser session
        driver.quit();
    }
}