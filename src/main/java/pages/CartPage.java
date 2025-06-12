package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    WebDriver driver;

    By cartCount = By.id("nav-cart-count");
    By quantityDropdown = By.cssSelector("select[name='quantity']");
    By deleteButton = By.xpath("//input[@value='Delete']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCartCount() {
        return driver.findElement(cartCount).getText();
    }

    public void updateQuantity(String quantity) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(quantityDropdown));
        dropdown.sendKeys(quantity);    }

    public void removeItem() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement delete = wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        delete.click();
    }
}
