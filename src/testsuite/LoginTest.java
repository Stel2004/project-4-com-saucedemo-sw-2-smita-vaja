package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import project_4_browserfactory.BaseTest;

import java.util.List;

/**
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userSholdLoginSuccessfullyWithValid Credentials
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “PRODUCTS”
 * 2. verifyThatSixProductsAreDisplayedOnPage
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify that six products are displayed on
 * page
 */
public class LoginTest extends BaseTest {

    static String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUpBrowser(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValid(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        //driver.findElement(By.xpath("//input[@name='user-name']")).sendKeys("standard_user");
        String expectedText = "Products";
        String actualText = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals("User is not logged in.", actualText, expectedText);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        int expectedText = 6;
        List<WebElement> productList = driver.findElements(By.cssSelector(".inventory_item"));
        int actualText = productList.size();
        Assert.assertEquals(" Six product not shown in page. ",actualText, expectedText);

    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
