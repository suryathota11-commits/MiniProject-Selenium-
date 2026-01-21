package org.example.miniproject;
import org.openqa.selenium.*;
import java.io.IOException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class AlertHandling extends CommonCode {
    @Test
    public void test1() throws InterruptedException, IOException {
        WebDriver driver=new ChromeDriver();
        implicitWait(driver);
        driver.get("https://mail.rediff.com/");
        driver.manage().window().maximize();
        takeScreenShot(driver,"Navigated to the given site");
        WebElement signInBtn = driver.findElement(By.linkText("Sign in"));
        click(signInBtn,driver);
        takeScreenShot(driver,"sign in button clicked");
        WebElement logInBtn=driver.findElement(By.xpath("//*[text()='Log In']"));
        click(logInBtn,driver);
        String signin=alertGetText(driver);
        if(!signin.equals("Please enter a valid user name")){
            alertAccept(driver);
            driver.close();
        }
        alertAccept(driver);
        WebElement forgetPass=driver.findElement(By.linkText("Forgot password?"));
        click(forgetPass,driver);
        takeScreenShot(driver,"forget button clicked");
        WebElement nxtBtn=driver.findElement(By.xpath("//*[text()='Next']"));
        click(nxtBtn,driver);

        String email=alertGetText(driver);
        if(!email.equals("Please enter your email ID")){
            alertAccept(driver);
            driver.quit();
        }
        alertAccept(driver);
        WebElement logInBack=driver.findElement(By.linkText("Back to Login"));
        click(logInBack,driver);
        takeScreenShot(driver,"Back to login button clicked");
        WebElement logoClick=driver.findElement(By.xpath("//*[@class='logo']"));
        click(logoClick,driver);
        takeScreenShot(driver,"clicked on logo to return to the home page");
        JavascriptExecutor js=(JavascriptExecutor) driver;
        WebElement privacyPolicyLnk=driver.findElement(By.linkText("Privacy Policy"));
        actionsMoveToElement(driver,privacyPolicyLnk);
        scrollToBottom(driver);
        takeScreenShot(driver,"scrolled down to the privacy policy web element");
        String mainWindow=getWindowHandle(driver);
        expWaitLinkTxt("Privacy Policy",driver);
        Thread.sleep(1000);
        privacyPolicyLnk.click();
        takeScreenShot(driver,"clicked on privacy policy");
        String newTab=getWindowHandle(driver);
        takeScreenShot(driver,"opened privacy policy");
        if(mainWindow.equals(newTab)){
            System.out.println("No new Tab,Privacy policy is opened in the same tab");
        }
        else{
            System.out.println("Privacy policy is opened in the new Tab");
        }
        driver.quit();
    }
}

