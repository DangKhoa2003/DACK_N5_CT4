/*Verify you are able to change or reorder previously added product
        *  Test Data = QTY = 10
        Test Steps:
        1. Go to http://live.techpanda.org/
        2. Click on my account link
        3. Login in application using previously created credential
        4. Click on 'REORDER' link , change QTY & click Update
        5. Verify Grand Total is changed
        6. Complete Billing & Shipping Information
        7. Verify order is generated and note the order number

        Expected outcomes:
        1) Grand Total is Changed
        2) Order number is generated

 */
package test;

import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

@Test
public class testcase8 {
    public static void testcase08() {
        /*Chức năng nhập mã giảm giá (vì trang k có nên đã thay thế bằng chức năng tìm size phù hợp với mua)
            B1: vào trang web Yame
            B2: Click vào bộ sưu tập
            B3: Click vào Y2010 ORIGINALS
            B4: Click vào sản phẩm
            B5: Ân thêm vào giỏ hàng
            B6: Click vào icon giỏ hàng trên header
            B7: Lấy giá trị ban đầu của tổng tiền
            B8: Nhập số lượng 1000 và ấn update
            B9: Lấy giá trị tổng tiền sau khi cập nhật
            B10: Điền các thông tin cần thiết
            B11: Click đặt hàng
            B12: Chụp kết quả
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
//              B7: Lấy giá trị ban đầu của tổng tiền
            WebElement totalOld = driver.findElement(By.cssSelector("div[id='grandTotal'] b"));
            String textTotalOld = totalOld.getText();
//             B8: Nhập số lượng 10 và ấn update
            WebElement qtyInputBox = driver.findElement(By.xpath("//input[@name='__QtyUpdate']"));
            qtyInputBox.clear();
            qtyInputBox.sendKeys("10");
            WebElement updateButton = driver.findElement(By.xpath("//button[@type='submit']"));
            updateButton.click();
            Thread.sleep(2000);
//          B9: Lấy giá trị tổng tiền sau khi cập nhật
            WebElement totalNew = driver.findElement(By.cssSelector("div[id='grandTotal'] b"));
            String textTotalNew = totalNew.getText();

            if(textTotalNew != textTotalOld) {
                System.out.println("Cập nhật giá tiền thành công");
            } else {
                System.out.println("Chưa cập nhật được giá tiền");
            }
//            B10: Điền các thông tin cần thiết
            WebElement inputName = driver.findElement(By.xpath("//input[@id='txtCustomerName']"));
            inputName.clear();
            inputName.sendKeys("0123456789");

            WebElement inputPhone = driver.findElement(By.xpath("//input[@id='txtPhone']"));
            inputPhone.clear();
            inputPhone.sendKeys("0123456789");

            WebElement inputAddress = driver.findElement(By.xpath("//input[@id='txtAddressLine']"));
            inputAddress.clear();
            inputAddress.sendKeys("IT Tester");
//            B11: Click đặt hàng
            WebElement btnOrder = driver.findElement(By.xpath("//button[@class='js-btnPlaceOrder btn btn-info fw']"));
            btnOrder.click();
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        B12: Chụp kết quả
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("./src/test/java/test/testcase08.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
