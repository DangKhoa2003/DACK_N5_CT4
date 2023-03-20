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

@Test
public class testcase02 {
    public static void testcase02() {
        /*Chức năng so sánh giá sản phẩm
            B1: vào trang web Yame
            B2: Click vào bộ sưu tập
            B3: Click vào Y2010 ORIGINALS
            B4: Click vào sản phẩm
            B5: Tiến hành so sánh giá
            B6 Chụp màn hình
        *
        * */
        WebDriver driver = driverFactory.getChromeDriver();
        try {
//            B1: vào trang web Yame
            driver.get("https://yame.vn/home/v2022");
//            B2: Click vào bộ sưu tập
            By leftClickPlace = By.xpath("//ul[@class='site-menu js-clone-nav d-none d-lg-block']//a[contains(text(),'Bộ Sưu Tập')]");
            WebElement leftClickPlaceElem = driver.findElement(leftClickPlace);
            leftClickPlaceElem.click();

//            B3: Click vào Y2010 ORIGINALS
            By clickOriginals = By.xpath("//a[normalize-space()='Y2010 ORIGINALS']");
            WebElement clickY2010 = driver.findElement(clickOriginals);
            clickY2010.click();
            Thread.sleep(2000);

//          B4: Click vào sản phẩm
            WebElement TShirt = driver.findElement(By.xpath("//body/div[@class='site-wrap']/div[@class='container-fluid mb-4']/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]/img[1]"));
            TShirt.click();
            Thread.sleep(5000);
//             B5: Tiến hành so sánh giá
            try{
                WebElement SpanCost = driver.findElement(By.className("price"));
                String Cost = SpanCost.getText();

                if (Cost.equals("157,000 đ")) {
                    System.out.println("Giá trị Sản phẩm đúng bằng");
                } else {
                    System.out.println("Giá trị Sản phẩm Không bằng");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
//             B6 Chụp màn hình
            TakesScreenshot screenshot = ((TakesScreenshot) driver);
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            File destFile = new File(".\\src\\test\\java\\test\\testcase02.png");
            FileHandler.copy(srcFile, destFile);
            Thread.sleep(2000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // Quit browser session
        driver.quit();
    }
}