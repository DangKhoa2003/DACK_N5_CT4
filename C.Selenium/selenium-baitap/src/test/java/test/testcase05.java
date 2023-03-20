package test;

import driver.driverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
@Test
public class testcase05 {
    public static void testcase05() throws InterruptedException, IOException {
        /*Chức năng thêm sản phẩm vao giỏ hàng
            B1: vào trang web Yame
            B2: Click vào icon user
            B3: Nhập số điện thoại, xong đăng nhap
            B4: Chụp màn hình
            B5: Xác nhận mã OTP
            B6: Click vào bộ sưu tập
            B7: Click vào Y2010 ORIGINALS
            B8: Click vào sản phẩm
            B9: Ân thêm vào giỏ hàng
            B10: Click vào icon giỏ hàng trên header
        *
        * */
//        B1: vào trang web Yame
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("https://yame.vn/home/v2022");

        //B2: Click vào icon user
        WebElement iconUser = driver.findElement(By.xpath("//span[@class='icon-user-o']"));
        iconUser.click();

//        B3:  Nhập số điện thoại, xong đăng nhap
        WebElement numberPhone = driver.findElement(By.xpath("//input[@id='userPhone']"));
        numberPhone.sendKeys("0373365530");


        WebElement register = driver.findElement(By.xpath("//button[@type='submit']"));
        register.click();

        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(".\\src\\test\\java\\test\\testcase05.png");
        FileHandler.copy(srcFile, destFile);
        Thread.sleep(2000);


        //B5: Xác nhận mã OTP
        WebElement codeOTP = driver.findElement(By.xpath("//input[@id='otpInput']"));
        codeOTP.sendKeys("000000");
        Thread.sleep(5000);
//         B6: Click vào bộ sưu tập
        By leftClickPlace = By.xpath("//ul[@class='site-menu js-clone-nav d-none d-lg-block']//a[contains(text(),'Bộ Sưu Tập')]");
        WebElement leftClickPlaceElem = driver.findElement(leftClickPlace);
        leftClickPlaceElem.click();

//         B7: Click vào Y2010 ORIGINALS
        By clickOriginals = By.xpath("//a[normalize-space()='Y2010 ORIGINALS']");
        WebElement clickY2010 = driver.findElement(clickOriginals);
        clickY2010.click();
        Thread.sleep(2000);
//         B8: Click vào sản phẩm

        WebElement TShirt = driver.findElement(By.xpath("//body/div[@class='site-wrap']/div[@class='container-fluid mb-4']/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]/img[1]"));


        TShirt.click();
        Thread.sleep(5000);

        //            B9: Ân thêm vào giỏ hàng
        WebElement NonYAddToCartButton = driver.findElement(By.xpath("//i[@class='fa fa-plus-circle']"));
        NonYAddToCartButton.click();
        Thread.sleep(2000);
//            B10: Click vào icon giỏ hàng trên header
        WebElement emptyCartLink = driver.findElement(By.xpath("//span[@class='icon-shopping-bag']"));
        emptyCartLink.click();
        Thread.sleep(2000);
    }
}