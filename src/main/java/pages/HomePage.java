package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;


    By searchBox = By.id("twotabsearchtextbox");
    By searchButton = By.id("nav-search-submit-button");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void searchProduct(String product) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Close location popup if it appears
        try {
            WebElement closePopup = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-main")));
        } catch (Exception ignored) {}

        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(product);
        driver.findElement(searchButton).click();
    }

}
