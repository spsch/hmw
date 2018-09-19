package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ResultPage implements Helper {

    private WebDriver driver;

    @FindBy(css=".table > thead:nth-child(1) > tr:nth-child(1) > th:nth-child(1)") private WebElement MonthlyPrincipalIntText;
    @FindBy(css=".table > thead:nth-child(1) > tr:nth-child(1) > td:nth-child(2)") private WebElement MonthlyPrincipalIntValue;
    @FindBy(css=".table > thead:nth-child(1) > tr:nth-child(4) > th:nth-child(1)") private WebElement LoanToValueRatioText;
    @FindBy(css=".table > thead:nth-child(1) > tr:nth-child(4) > td:nth-child(2)") private WebElement LoanToValueRatioValue;
    @FindBy(css=".table > thead:nth-child(1) > tr:nth-child(7) > th:nth-child(1))") private WebElement TotalMonthlyPaymentText;
    @FindBy(css=".table > thead:nth-child(1) > tr:nth-child(7) > td:nth-child(2))") private WebElement TotalMonthlyPaymentValue;

    public ResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void CheckResults(){
        WebDriverWait tableWait = new WebDriverWait(driver, 60);
        WebElement expMPIT = tableWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"analysisDiv\"]/table/thead/tr[7]/th")));
        WebElement expLTVT = tableWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#analysisDiv > table > thead > tr:nth-child(4) > th")));
        WebElement expTMPT = tableWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#analysisDiv > table > thead > tr:nth-child(7) > th")));

        System.out.println("TAk co to je kurva: " + MonthlyPrincipalIntText.toString());

        Assert.assertEquals(expMPIT, MONTHLY_RESULT_TEXT);
        Assert.assertEquals(expLTVT, LOANTOVALUERATIO_TEXT);
        Assert.assertEquals(expTMPT, TOTAL_MTHLY_PAYMENTS_TEXT);
    }




}
