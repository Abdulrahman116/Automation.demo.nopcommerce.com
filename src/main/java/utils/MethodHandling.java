package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class MethodHandling {

    protected WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    Select select;

    public MethodHandling(WebDriver driver) {
        this.driver = driver;
    }

    // 🔹 Generic wait for a single locator
    private void waitForElement(By locator, int seconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOfElementLocated(locator),
                ExpectedConditions.presenceOfElementLocated(locator)
        ));
    }

    // 🔹 Generic wait for a clickable element
    private void waitForClickable(By locator, int seconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOfElementLocated(locator),
                ExpectedConditions.elementToBeClickable(locator),
                ExpectedConditions.presenceOfElementLocated(locator)
        ));
    }

    //  Wait for two elements (e.g., drag & drop)
    private void waitForTwoElements(By locator1, By locator2, int seconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOfElementLocated(locator1),
                ExpectedConditions.presenceOfElementLocated(locator1),
                ExpectedConditions.visibilityOfElementLocated(locator2),
                ExpectedConditions.presenceOfElementLocated(locator2)
        ));
    }

    // ================================ Methods using new waits ======================================

    protected void normalClick(By locator) {
        driver.findElement(locator).click();
    }
    protected void clickWithJS(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    protected void sendKeys(By locator, String text) {
        waitForElement(locator, 10);
        driver.findElement(locator).sendKeys(text);
    }

    protected String getText(By locator) {
        waitForElement(locator, 10);
        return driver.findElement(locator).getText();
    }

    protected void dragAndDrop(By locator1, By locator2) {
        waitForTwoElements(locator1, locator2, 10);
        actions = new Actions(driver);
        actions.dragAndDrop(driver.findElement(locator1), driver.findElement(locator2)).build().perform();
    }

    protected void dragAndDrop2(By locator1, By locator2) {
        waitForTwoElements(locator1, locator2, 10);
        actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(locator1)).moveToElement(driver.findElement(locator2)).release().build().perform();
    }

    protected void selectFromDropdownList(By locator, String visibleText) {
        waitForElement(locator, 10);
        select = new Select(driver.findElement(locator));
        select.selectByVisibleText(visibleText);
    }

    protected void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    protected void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    protected void sendKeyToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
        driver.switchTo().alert().accept();
    }

    protected void closeTheAd(By locator1, By locator2) {
        waitForTwoElements(locator1, locator2, 10);
        driver.findElement(locator2).click();
    }

    protected FigureCaption hoverOverFigure(int index, By locator1, By locator2) {
        actions = new Actions(driver);
        WebElement figureImage = driver.findElements(locator1).get(index - 1);
        actions.moveToElement(figureImage).build().perform();
        return new FigureCaption(figureImage.findElement(locator2));
    }

    protected void switchToFrame(String frameName) {
        driver.switchTo().frame(frameName);
    }

    protected void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

    protected void switchToNewTab(String url) {

        ((JavascriptExecutor) driver).executeScript("window.open()");
        java.util.ArrayList<String> tabs = new java.util.ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
        driver.get(url);
    }

    protected void scrollBy(int x, int y) {
        ((JavascriptExecutor) driver).
                executeScript("window.scrollBy(" + x + "," + y + ")");
    }

    protected void scrollToElement(By locator) {
        waitForElement(locator, 10);
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).
                executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void scrollToBottom() {

        ((JavascriptExecutor) driver).
                executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    protected void scrollToTop() {

        ((JavascriptExecutor) driver).
                executeScript("window.scrollTo(0, 0)");
    }


    protected void typeText(By locator, String text) {
        waitForElement(locator, 10);
        driver.findElement(locator).sendKeys(text);
    }

    protected void clearText(By locator) {
        waitForElement(locator, 10);
        driver.findElement(locator).clear();
    }

    /*protected void clickElement(By locator) {
        waitForClickable(locator, 10);
        driver.findElement(locator).click();
    }*/

    protected void click(By locator) {
        waitForClickable(locator, 10);
        try {
            normalClick(locator);
        } catch (Exception e) {
            clickWithJS(locator);
        }
    }

    protected void uploadFileMain(By locator, String filePath) {
        waitForElement(locator, 10);
        WebElement uploadElement = driver.findElement(locator);

        try {
            uploadElement.sendKeys(filePath);
        } catch (Exception e) {
            try {
                ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", uploadElement);
                uploadElement.sendKeys(filePath);
            } catch (Exception jsEx) {
                throw new RuntimeException("❌ File upload failed for locator: " + locator + " with path: " + filePath, jsEx);
            }
        }
    }

}
