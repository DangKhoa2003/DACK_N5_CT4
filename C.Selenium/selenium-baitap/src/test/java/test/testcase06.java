package test;

import driver.driverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

@Test
public class testcase06 {
    public static void testcase06() {
        /*Chức năng đặt hàng
            B1: vào trang web Yame
            B2. vào gu tối giản
            B3. chọn 1 sản phẩm thêm vào giỏ hàng
            B4: Click vào icon giỏ hàng trên header
            B5. nhập thông tin đặt hàng
            B6. Click vào dặt hàng
            B7: Chup kết quả

        *
        * */
        WebDriver driver = driverFactory.getChromeDriver();
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            //        B1: vào trang web Yame
            driver.get("https://yame.vn/home/v2022");

            //B2: Click vào icon user
//            WebElement iconUser = driver.findElement(By.xpath("//span[@class='icon-user-o']"));
//            iconUser.click();

//        B3:  Nhập số điện thoại, xong đăng nhap
//            WebElement numberPhone = driver.findElement(By.xpath("//input[@id='userPhone']"));
//            numberPhone.sendKeys("0373365530");


//            WebElement register = driver.findElement(By.xpath("//button[@type='submit']"));
//            register.click();

            //B5: Xác nhận mã OTP
//            WebElement codeOTP = driver.findElement(By.xpath("//input[@id='otpInput']"));
//            codeOTP.sendKeys("000000");


            //5. vào gu tối giản
            WebElement homePage = driver.findElement(By.xpath("//ul[@class='site-menu js-clone-nav d-none d-lg-block']//a[contains(text(),'GU TỐI GIẢN')]"));
            homePage.click();
            Thread.sleep(5500);

            //6. chọn 1 sản phẩm thêm vào giỏ hàng
            WebElement product = driver.findElement(By.xpath("//body/div[@class='site-wrap']/div[@class='container-fluid mb-4']/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]/img[1]"));
            product.click();
            Thread.sleep(3000);

            //nhấn thêm
            WebElement Addtocart = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/form[1]/a[1]/i[1]"));
            Addtocart.click();
            Thread.sleep(3000);

//          7: Click vào icon giỏ hàng trên header
            WebElement emptyCartLink = driver.findElement(By.xpath("//span[@class='icon-shopping-bag']"));
            emptyCartLink.click();
            Thread.sleep(2000);

            //8. nhập thông tin đặt hàng
//          tên
            WebElement enterName = driver.findElement(By.cssSelector("#txtCustomerName"));
            enterName.sendKeys("đắng khoa");

//          số điện thoại
            WebElement enterPhone = driver.findElement(By.cssSelector("#txtPhone"));
            enterPhone.sendKeys("012345678");

//          cách thức nhận hàng
            WebElement toShip = driver.findElement(By.cssSelector("input[value='shipToHome']"));
            toShip.click();

//          nơi nhận hàng
            WebElement enterAddress = driver.findElement(By.cssSelector("#txtAddressLine"));
            enterAddress.sendKeys("HCM , Q7 , Phú mỹ hưng");
//
//          ghi chú
            WebElement enterNote = driver.findElement(By.cssSelector("#txtNote"));
            enterNote.sendKeys("không");

//            //9. Click vào dặt hàng
            WebElement order = driver.findElement(By.cssSelector(".js-btnPlaceOrder.btn.btn-info.fw"));
            order.click();
            Thread.sleep(3000);

//          lấy mã đơn hàng
            String codeOrders = driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > h4:nth-child(5)")).getText();
            System.out.println(codeOrders);
//          check đặt hàng
            String expectedOder = "Đặt hàng thành công";
            WebElement successOder = driver.findElement(By.cssSelector("strong[class='text-black']"));
            String actualOder = successOder.getText();
            if (actualOder.equals(expectedOder)) {
                System.out.println("Oder thành công.");
            } else {
                System.out.println("Oder thất bại.");
            }
              // 10: Chụp màn hình
            TakesScreenshot screenshot = ((TakesScreenshot) driver);
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            File destFile = new File(".\\src\\test\\java\\test\\testcase06.png");
            FileHandler.copy(srcFile, destFile);
            Thread.sleep(2000);
            driver.quit();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}