/*Verify that you will be able to save previously placed order as a pdf file
        *
        *   Note: This TestCase7a version is due to the below amended steps.
        *
        Test Steps:
        1. Go to http://live.techpanda.org/
        2. Click on My Account link
        3. Login in application using previously created credential
        4. Click on 'My Orders'
        5. Click on 'View Order'
        6. *** note: After steps 4 and 5, step 6 "RECENT ORDERS" was not displayed
        Verify the previously created order is displayed in 'RECENT ORDERS' table and status is Pending
        7. Click on 'Print Order' link
        8. *** note: the link was not found.
        Click 'Change...' link and a popup will be opened as 'Select a destination' , select 'Save as PDF' link.
 */
package test;
import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

@Test
public class testcase7 {
    public static void testcase07() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //1: Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");

            //2. Click on my account link
            WebElement butacc = driver.findElement(By.cssSelector(".skip-link.skip-account"));
            butacc.click();
            WebElement butmyacc = driver.findElement(By.cssSelector("div[id='header-account'] a[title='My Account']"));
            butmyacc.click();

            //3. Login in application using previously created credential
            WebElement tk = driver.findElement(By.cssSelector("#email"));
            tk.clear();
            tk.sendKeys("llhuong7102002@gmail.com");
            WebElement mk = driver.findElement(By.cssSelector("#pass"));
            mk.clear();
            mk.sendKeys("07102002");
            WebElement login = driver.findElement(By.cssSelector("button[id='send2'] span span"));
            login.click();

            //4. Click on 'My Orders'
            WebElement myorder = driver.findElement(By.cssSelector("a[href='http://live.techpanda.org/index.php/sales/order/history/']"));
            myorder.click();


            //5. Click on 'View Order'
            WebElement vieworder = driver.findElement(By.cssSelector("a[href='http://live.techpanda.org/index.php/sales/order/view/order_id/18682/']"));
            vieworder.click();

            //7. Click on 'Print Order' link
            WebElement print = driver.findElement(By.xpath(".link-print"));
            print.click();

            //8. *** note: the link was not found.
            WebElement select = driver.findElement(By.xpath("//a[@class='link-print']"));
            select.click();
        } catch (Exception e) {
            e.printStackTrace();
        }

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("./src/test/java/test/testcase07.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
