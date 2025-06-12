package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    WebDriver driver;

    By addToCart = By.id("add-to-cart-button");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));
        driver.findElement(By.id("add-to-cart-button")).click();
    }
}

