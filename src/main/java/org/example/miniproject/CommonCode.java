package org.example.miniproject;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
public class CommonCode {
    private static JavascriptExecutor js = null;
    public static void implicitWait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    public static void expWait(String ele, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ele)));
 }
 public static void expWaitLinkTxt(String ele, WebDriver driver){
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
     wait.until(ExpectedConditions.elementToBeClickable(By.linkText(ele)));
 }
    public static void click(WebElement ele,WebDriver driver) {
        ele.click();
    }
    public static void alertAccept(WebDriver driver) {
        Alert a = driver.switchTo().alert();
        a.accept();
    }
    public static String alertGetText(WebDriver driver) {
        Alert a = driver.switchTo().alert();
        String alerText=a.getText();
        return alerText;
    }

    public static void actionsMoveToElement(WebDriver driver,WebElement ele) {
        Actions act = new Actions(driver);
        act.moveToElement(ele).build().perform();
    }
    public static void scrollToBottom(WebDriver driver) {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    public static String getWindowHandle(WebDriver driver){
        String s= driver.getWindowHandle();
        return s;
    }
    public static void takeScreenShot(WebDriver driver, String name) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),
                    new File(System.getProperty("user.dir") + "/screenshots1/" + name + ".jpeg"));
            System.out.println(name + ": Screenshot has been captured.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
