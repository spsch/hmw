package pages;

import org.openqa.selenium.WebElement;

public interface Helper {

    final String URL = "https://www.mortgageloan.com/calculator";

    final String LOANAMOUNT = "200000";
    final String INTERESTRATE = "5";
    final String LENGTH = "30";
    final String HOMEVALUE = "235000";
    final String ANNUALTAXES = "2000";
    final String ANNUALINSURANCE = "1865";
    final String PMI = "0.52";

    final String MONTHLY_RESULT = "1073.64";
    final String ANNUAL_RESULT = "85.11";
    final String PAYMENTS_RESULT = "1482.39";

    final String MONTHLY_RESULT_TEXT = "Monthly Principal & Interests";
    final String LOANTOVALUERATIO_TEXT = "Loan To Value Ratio";
    final String TOTAL_MTHLY_PAYMENTS_TEXT = "Total Monthly Payments";
}

