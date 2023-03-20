/*  Verify Discount Coupon works correctly

Test Case Description:
1. Go to http://live.techpanda.org/
2. Go to Mobile and add IPHONE to cart
3. Enter Coupon Code
4. Verify the discount generated

TestData:  Coupon Code: GURU50
Expected result:
1) Price is discounted by 5%
*/

package test;
import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

@Test
public class testcase9 {
    public static void testcase9(){
        /*Chức năng nhập mã giảm giá (vì trang k có nên đã thay thế bằng chức năng tìm size phù hợp với mua)
            B1: vào trang web Yame
            B2: Click vào bộ sưu tập
            B3: Click vào Y2010 ORIGINALS
            B4: Click vào sản phẩm
            B5:  Chọn size
            B6: Tìm
            B7: Chụp kết quả
        *
        * */
        WebDriver driver = driverFactory.getChromeDriver();
        try{
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
            WebElement TShirt = driver.findElement(By.xpath("//div[@class='col-6']//div[@class='owl-item active']//img[@alt='Áo Thun Cổ Tròn Đơn Giản Y Nguyên Bản Ver92']"));
            TShirt.click();
            Thread.sleep(2000);

            // B5:  Chọn size
            WebElement canNang = driver.findElement(By.xpath("//input[@id='txtCanNang']"));
            canNang.sendKeys("56");

            WebElement chieuCao = driver.findElement(By.xpath("//input[@id='txtChieuCao']"));
            chieuCao.sendKeys("170");
//            B6: Tìm
            WebElement timSize = driver.findElement(By.xpath("//button[@id='btnCheckSize']"));
            timSize.click();
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
//        B7: Chụp kết quả
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("./src/test/java/test/testcase09.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}

