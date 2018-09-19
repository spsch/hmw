package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.LoanAndProperty;

public class PaymentsAndResults implements Helper {

    private WebDriver driver;

    @FindBy(css="#calculator_widget_PropertyTaxes") private WebElement AnnualTaxes;
    @FindBy(css="#calculator_widget_Insurance") private WebElement AnnualInsurance;
    @FindBy(css="#calculator_widget_PMI") private WebElement AnnualPmi;
    @FindBy(css="li.next:nth-child(5) > a:nth-child(1)") private WebElement ShowResultsBtn;
    //special elements - dollar signs and percentual signs for previous elems
    @FindBy(css="div.radio-group-container:nth-child(2) > div:nth-child(2) > div:nth-child(1) > label:nth-child(2)") private WebElement ATSign;
    @FindBy(css="div.radio-group-container:nth-child(3) > div:nth-child(2) > div:nth-child(1) > label:nth-child(2)") private WebElement AISign;
    @FindBy(css="div.radio-group-container:nth-child(4) > div:nth-child(2) > div:nth-child(1) > label:nth-child(2)") private WebElement PMISign;


    public PaymentsAndResults(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void CheckFieldsAndFill(String annualtaxes, String annualinsurance, String annualpmi){
        WebDriverWait elemWait = new WebDriverWait(driver, 60);
        WebElement expAnnualTaxes = elemWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#calculator_widget_PropertyTaxes")));
        WebElement expAnnualInsurance = elemWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#calculator_widget_Insurance")));
        WebElement expAnnualPMI = elemWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#calculator_widget_PMI")));

        expAnnualTaxes.clear();
        expAnnualTaxes.sendKeys(annualtaxes);

        expAnnualInsurance.clear();
        expAnnualInsurance.sendKeys(annualinsurance);

        expAnnualPMI.clear();
        expAnnualPMI.sendKeys(annualpmi);

        ShowResultsBtn.click();
    }

}
