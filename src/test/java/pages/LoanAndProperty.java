package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoanAndProperty extends LoadableComponent<LoanAndProperty> implements Helper {

    private final WebDriver driver;

    public LoanAndProperty(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void load() {
        driver.get(URL);
    }

    protected void isLoaded() throws Error {
        String CheckUrl = driver.getCurrentUrl();
        Assert.assertEquals(CheckUrl, URL);
    }

    //elements
    @FindBy(css="#calculator_widget_amount") private WebElement LoanAmount;
    @FindBy(css="#calculator_widget_interest") private WebElement InterestRate;
    @FindBy(css = "#calculator_widget_Length") private WebElement Length;
    @FindBy(css = "#calculator_widget_HomeValue") private WebElement HomeValue;
    @FindBy(css = ".next-button") private WebElement NextBtn;

    //methods

    public void CheckAndFillFields(String loanamount, String interestrate, String length, String homevalue) throws InterruptedException {
        WebDriverWait ElemWait = new WebDriverWait(driver, 60);
        WebElement expLoanAmount = ElemWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#calculator_widget_amount")));
        WebElement expInterestRate = ElemWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#calculator_widget_interest")));
        WebElement expLength = ElemWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#calculator_widget_Length")));
        WebElement expHomeValue = ElemWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#calculator_widget_HomeValue")));

        expLoanAmount.clear();
        expLoanAmount.sendKeys(loanamount);

        expInterestRate.clear();
        expInterestRate.sendKeys(interestrate);

        expLength.clear();
        expLength.sendKeys(length);

        expHomeValue.clear();
        expHomeValue.sendKeys(homevalue);
        NextBtn.click();
    }


}
