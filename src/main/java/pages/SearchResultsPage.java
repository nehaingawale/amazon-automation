package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class SearchResultsPage {
    WebDriver driver;

    By results = By.cssSelector(".s-main-slot .s-result-item");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductDisplayed(String keyword) {
        return driver.getPageSource().toLowerCase().contains(keyword.toLowerCase());
    }

    public void clickNthProduct(int index) {
        List<WebElement> items = driver.findElements(results);
        if (items.size() > index) {
            items.get(index).click();
        }
    }
}
