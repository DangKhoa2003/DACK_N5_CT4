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
        // Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            // Step 1. Go to https://yame.vn/home/v2022
            driver.get("https://yame.vn/home/v2022");

            By leftClickPlace = By.xpath("//ul[@class='site-menu js-clone-nav d-none d-lg-block']//a[contains(text(),'Bộ Sưu Tập')]");
            WebElement leftClickPlaceElem = driver.findElement(leftClickPlace);
            leftClickPlaceElem.click();


            By clickOriginals = By.xpath("//a[normalize-space()='Y2010 ORIGINALS']");
            WebElement clickY2010 = driver.findElement(clickOriginals);
            clickY2010.click();
            Thread.sleep(2000);
            // Step 3. In the list of all mobile , read the cost of Sony Xperia mobile (which is $100)

            WebElement TShirt = driver.findElement(By.xpath("//body/div[@class='site-wrap']/div[@class='container-fluid mb-4']/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]/img[1]"));

            WebElement TShirtPrice = driver.findElement(By.cssSelector(".price span:nth-child(1)"));
            String expectedPrice = TShirtPrice.getText();

            System.out.println("Price of Sony Xperia: " + expectedPrice);
            Thread.sleep(2000);

            // Step 4. Click on Sony Xperia mobile
            TShirt.click();
            Thread.sleep(5000);
            // Step 5. Read the Sony Xperia mobile from detail page.
            WebElement detailPrice = driver.findElement(By.xpath("//h5[@class='price mb-2']"));
            String actualPrice = detailPrice.getText();
            System.out.println("Price of Sony Xperia on Detail page: " + actualPrice);
            Thread.sleep(2000);
//
//            // Step 6. Compare Product value in list and details page should be equal ($100).
            Assert.assertEquals(actualPrice, expectedPrice);
            Thread.sleep(2000);
//
//            // TakesScreenshot
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