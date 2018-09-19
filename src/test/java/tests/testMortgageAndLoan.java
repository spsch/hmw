package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Helper;
import pages.LoanAndProperty;
import pages.PaymentsAndResults;
import pages.ResultPage;

public class testMortgageAndLoan implements Helper {
    //initialize driver
    private WebDriver driver;
    //initilaize logger
    private Logger LOG = Logger.getLogger(String.valueOf(testMortgageAndLoan.class));

    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().forceDownload();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown(){
        driver.close();
        if (driver != null){
            driver.quit();
        }
    }

    @Test(priority=0)
    public void testMortgageFill() throws InterruptedException{
        LOG.log(Level.INFO, "Starting test");
        LoanAndProperty loanpage = new LoanAndProperty(driver).get();
        loanpage.CheckAndFillFields(LOANAMOUNT, INTERESTRATE, LENGTH, HOMEVALUE);
    }

    @Test(priority = 1)
    public void testPaymentsFill() throws InterruptedException{
        PaymentsAndResults payments = new PaymentsAndResults(driver);
        payments.CheckFieldsAndFill(Helper.ANNUALTAXES, Helper.ANNUALINSURANCE, Helper.PMI);
    }

    @Test(priority = 2)
    public void testCheckResults() throws InterruptedException{
        WebElement ResultTable = driver.findElement(By.tagName("table"));
        List<WebElement> TableRows = ResultTable.findElements(By.tagName("tr"));
        for(int i = 0; i<TableRows.size(); i++ ){
            WebElement row = TableRows.get(i);
            System.out.println(row);
        }
    }
}
