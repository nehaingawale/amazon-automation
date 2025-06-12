package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

public class AmazonTests {
    WebDriver driver;
    HomePage home;
    SearchResultsPage results;
    ProductPage product;
    CartPage cart;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        home = new HomePage(driver);
        results = new SearchResultsPage(driver);
        product = new ProductPage(driver);
        cart = new CartPage(driver);
    }

    @Test(priority = 1)
    public void testSearchNonExistingProduct() {
        home.searchProduct("ld345tsxslfer");
        Assert.assertTrue(driver.getPageSource().contains("No results"), "No results not displayed");
    }

    @Test(priority = 2)
    public void testSearchExistingProduct() {
        home.searchProduct("Laptop");
        Assert.assertTrue(results.isProductDisplayed("Laptop"), "Laptop not found in results");
    }

    @Test(priority = 3)
    public void testAddProductToCart() throws InterruptedException {
        home.searchProduct("Laptop");

        Thread.sleep(3000); // optional fallback
        results.clickNthProduct(3);

        // Switch to new tab
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        product.addToCart();
        Assert.assertTrue(Integer.parseInt(cart.getCartCount()) > 0, "Product not added to cart");
    }

    @Test(priority = 4)
    public void testUpdateQuantity() {
        driver.get("https://www.amazon.in/gp/cart/view.html");
        cart.updateQuantity("2");
    }

    @Test(priority = 5)
    public void testRemoveFromCart() {
        driver.get("https://www.amazon.in/gp/cart/view.html");
        cart.removeItem();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

