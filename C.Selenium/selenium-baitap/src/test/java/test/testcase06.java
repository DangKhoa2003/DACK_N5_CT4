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
        WebDriver driver = driverFactory.getChromeDriver();
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            //1. Goto http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");

            //2. Click on my account link
            WebElement myaccountlink = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[4]/ul[1]/li[1]/a[1]"));
            myaccountlink.click();

            //3. Login in application using previously created credential
            WebElement email = driver.findElement(By.cssSelector("#email"));
            email.sendKeys("llhuong7102002@gmail.com");

            WebElement password = driver.findElement(By.cssSelector("#pass"));
            password.sendKeys("07102002");
            Thread.sleep(2000);

            WebElement login = driver.findElement(By.cssSelector(("#send2")));
            login.click();
            Thread.sleep(2000);


            //4. Click on MY WISHLIST link
            WebElement mywishlistlink = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[8]/a[1]"));
            mywishlistlink.click();

            //5. In next page, Click ADD TO CART link
            WebElement btn = driver.findElement(By.cssSelector("button[title='Add to Cart']"));
            btn.click();

            //6. Enter general shipping country, state/province and zip for the shipping cost estimate
            WebElement shippingcountry = driver.findElement(By.cssSelector("#country"));
            Select selectOption = new Select(shippingcountry);
            selectOption.selectByVisibleText("Vietnam");
            Thread.sleep(2000);

            WebElement postcode = driver.findElement(By.cssSelector("#postcode"));
            postcode.sendKeys("1");

            //7. Click Estimate
            WebElement estimate = driver.findElement(By.cssSelector("button[title='Estimate']"));
            estimate.click();

            //8. Verify Shipping cost generated
            String cost = "$5.00";
            WebElement cost2 = driver.findElement(By.cssSelector("label[for='s_method_flatrate_flatrate'] span[class='price']"));
            Assert.assertEquals(cost2.getText(), cost);

            //9. Select Shipping Cost, Update Total
            WebElement shippingcode = driver.findElement(By.cssSelector("#s_method_flatrate_flatrate"));
            shippingcode.click();
            WebElement update = driver.findElement(By.cssSelector("button[title='Update Total']"));
            update.click();

            //10. Verify shipping cost is added to total
            WebElement price = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/span[1]"));
            WebElement total = driver.findElement(By.cssSelector("strong span[class='price']"));
            Assert.assertNotEquals(price, total);

            //11. Click "Proceed to Checkout"
            WebElement ptc = driver.findElement(By.cssSelector("button[title='Proceed to Checkout']"));
            ptc.click();

            //12. Enter Billing Information, and click Continue
            WebElement inputStreet = driver.findElement(By.cssSelector("input[title='Street Address']"));
            WebElement inputCity =driver.findElement(By.cssSelector("input[title='City']"));
            WebElement inputPC = driver.findElement(By.cssSelector("input[title='Zip']"));
            WebElement inputTel = driver.findElement(By.cssSelector("input[title='Telephone']"));

            Select select2 = new Select(driver.findElement(By.cssSelector("select[title='Country']")));
            inputStreet.sendKeys("TPHCM");
            inputCity.sendKeys("TPHCM");
            inputPC.sendKeys("7000");
            inputTel.sendKeys("0794329089");
            select2.selectByVisibleText("Vietnam");

            //12. Enter Shipping Information, and click Continue
            WebElement continueclick = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button[title='Continue']"))));
            continueclick.click();

            //13. In Shipping Method, Click Continue
            WebElement continueclick2 = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#shipping-method-buttons-container button"))));
            continueclick2.click();
            Thread.sleep(2000);

            //14. In Payment Information select 'Check/Money Order' radio button. Click Continue
            WebElement radio = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='p_method_checkmo']"))));
            radio.click();
            WebElement continueclick3 = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button[onclick='payment.save()']"))));
            continueclick3.click();
            Thread.sleep(2000);

            //15. Click 'PLACE ORDER' button
            WebElement continueclick4 = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button[title='Place Order']"))));
            continueclick4.click();
            Thread.sleep(2000);

            //16. Verify Oder is generated. Note the order number
            WebElement orderNum = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/p[1]/a[1]"))));
            System.out.println(orderNum.getText());
            Thread.sleep(2000);

            //TakesSreenshot
            TakesScreenshot screenshot = ((TakesScreenshot) driver);
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            File destFile = new File("./src/test/java/test/testcase06.png");
            FileHandler.copy(srcFile, destFile);
            driver.quit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}