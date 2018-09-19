package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ResultPage implements Helper {

    private WebDriver driver;

    public ResultPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void CheckResults() {

        WebDriverWait wait = new WebDriverWait(driver, 30);

        WebElement resultMonthly = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#analysisDiv > table > thead > tr:nth-child(1) > td")));
        Assert.assertEquals(resultMonthly.getText(), MONTHLY_RESULT);

        WebElement percentage = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#analysisDiv > table > thead > tr:nth-child(4) > td")));
        Assert.assertEquals(percentage.getText(), ANNUAL_RESULT);

        WebElement totalResult = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#analysisDiv > table > thead > tr:nth-child(7) > td")));
        Assert.assertEquals(totalResult.getText(), PAYMENTS_RESULT);
    }
}
