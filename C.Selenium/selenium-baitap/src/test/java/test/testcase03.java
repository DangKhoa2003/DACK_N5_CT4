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
public class testcase03 {
    public static void testcase03() {
        /*Chức năng thêm sản phẩm vao giỏ hàng
            B1: vào trang web Yame
            B2: Click vào bộ sưu tập
            B3: Click vào Y2010 ORIGINALS
            B4: Click vào sản phẩm
            B5: Ân thêm vào giỏ hàng
            B6: Click vào icon giỏ hàng trên header
            B7: Nhập số lượng 1000 và ấn update
            B8 Chụp màn hình

        *
        * */
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //  B1: vào trang web Yame
            driver.get("https://yame.vn/home/v2022");
//            B2: Click vào bộ sưu tập
            By leftClickPlace = By.xpath("//ul[@class='site-menu js-clone-nav d-none d-lg-block']//a[contains(text(),'Bộ Sưu Tập')]");
            WebElement leftClickPlaceElem = driver.findElement(leftClickPlace);
            leftClickPlaceElem.click();

//          B3: Click vào Y2010 ORIGINALS
            By clickOriginals = By.xpath("//a[normalize-space()='Y2010 ORIGINALS']");
            WebElement clickY2010 = driver.findElement(clickOriginals);
            clickY2010.click();
            Thread.sleep(2000);
            // B4: Click vào sản phẩm

            WebElement TShirt = driver.findElement(By.xpath("//body/div[@class='site-wrap']/div[@class='container-fluid mb-4']/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]/img[1]"));


            TShirt.click();
            Thread.sleep(5000);

//           B5: Ân thêm vào giỏ hàng
            WebElement NonYAddToCartButton = driver.findElement(By.xpath("//i[@class='fa fa-plus-circle']"));
            NonYAddToCartButton.click();
            Thread.sleep(2000);
//              B6: Click vào icon giỏ hàng trên header
            WebElement emptyCartLink = driver.findElement(By.xpath("//span[@class='icon-shopping-bag']"));
            emptyCartLink.click();
            Thread.sleep(2000);

//             B7: Nhập số lượng 1000 và ấn update
            WebElement qtyInputBox = driver.findElement(By.xpath("//input[@name='__QtyUpdate']"));
            qtyInputBox.clear();
            qtyInputBox.sendKeys("1000");
            WebElement updateButton = driver.findElement(By.xpath("//button[@type='submit']"));
            updateButton.click();
            Thread.sleep(2000);


            //  B8 Chụp màn hình
            TakesScreenshot screenshot = ((TakesScreenshot) driver);
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            File destFile = new File(".\\src\\test\\java\\test\\testcase03.png");
            FileHandler.copy(srcFile, destFile);
            Thread.sleep(2000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            // Close web-driver
            driver.quit();
        }
    }
}
