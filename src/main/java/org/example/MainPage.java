package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    private final By refillBlockLocator = By.xpath("//h2[contains(normalize-space(), \"Онлайн пополнение\") and contains(normalize-space(), \"без комиссии\")]");
    private final By visaLogoLocator = By.xpath("//img[@alt=\"Visa\"]");
    private final By verifiedByVisaLogoLocator = By.xpath("//img[@alt=\"Verified By Visa\"]");
    private final By masterCardLogoLocator = By.xpath("//img[@alt=\"MasterCard\"]");
    private final By masterCardSecureCodeLogoLocator = By.xpath("//img[@alt=\"MasterCard Secure Code\"]");
    private final By belkartLogoLocator = By.xpath("//img[@alt=\"Белкарт\"]");
    private final By moreAboutServiceLinkLocator = By.xpath("//a[@href=\"/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/\"]");
    private final By serviceTypeLocator = By.xpath("//button[@class=\"select__header\"]");
    private final By phoneNumberLocator = By.id("connection-phone");
    private final By internetPhoneLocator = By.id("internet-phone");
    private final By accountNumber44Locator = By.id("score-instalment");
    private final By accountNumber2073Locator = By.id("score-arrears");
    private final By sumLocator = By.id("connection-sum");
    private final By emailLocator = By.id("connection-email");
    private final By continueButtonLocator = By.xpath("//*[@id=\"pay-connection\"]/button");
    private final By cookieCloseButtonLocator = By.cssSelector("#cookie-agree");
    private final By iframeLocator = By.cssSelector("iframe.bepaid-iframe");
    private final By paymentTypeDropdown1 = By.id("pay");
    private final By paymentSumLocator = By.xpath("//div[@class=\"pay-description__cost\"]/span");
    private final By paymentSumOnButtonLocator = By.xpath("//button[@class=\"colored disabled\"]");
    private final By creditCardNumberPlaceholderLocator = By.xpath("//label[@class=\"ng-tns-c46-1 ng-star-inserted\"]");
    private final By expirationDatePlaceholderLocator = By.xpath("//label[@class=\"ng-tns-c46-4 ng-star-inserted\"]");
    private final By cvcPlaceholderLocator = By.xpath("//label[@class=\"ng-tns-c46-5 ng-star-inserted\"]");
    private final By holdersNameLocator = By.xpath("//label[@class=\"ng-tns-c46-3 ng-star-inserted\"]");
    private final By phoneNumberOnPaymentFormLocator = By.xpath("//div[@class=\"pay-description__text\"]/span");
    private final By visaLogoOnPaymentTab = By.xpath("//img[@src=\"assets/images/payment-icons/card-types/visa-system.svg\"]");
    private final By masterCardLogoOnPaymentTab = By.xpath("//img[@src=\"assets/images/payment-icons/card-types/mastercard-system.svg\"]");
    private final By belkartLogoOnPaymentTab = By.xpath("//img[@src=\"assets/images/payment-icons/card-types/belkart-system.svg\"]");
    private final By maestroLogoOnPaymentTab = By.xpath("//img[@src=\"assets/images/payment-icons/card-types/maestro-system.svg\"]");
    private final By mirLogoOnPaymentTab = By.xpath("//img[@src=\"assets/images/payment-icons/card-types/mir-system-ru.svg\"]");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void closeCookie() {
        try {
            WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(cookieCloseButtonLocator)));
            cookieButton.click();
        } catch (Exception e) {
        }
    }

    public WebElement getRefillBlockName() {
        return driver.findElement(refillBlockLocator);
    }

    public boolean areLogosPresent() {
        return driver.findElement(visaLogoLocator) != null &&
                driver.findElement(verifiedByVisaLogoLocator) != null &&
                driver.findElement(masterCardLogoLocator) != null &&
                driver.findElement(masterCardSecureCodeLogoLocator) != null &&
                driver.findElement(belkartLogoLocator) != null;
    }

    public boolean areLogosPresentOnPaymentTab() {
        return driver.findElement(visaLogoOnPaymentTab) != null &&
                driver.findElement(masterCardLogoOnPaymentTab) != null &&
                driver.findElement(belkartLogoOnPaymentTab) != null &&
                driver.findElement(maestroLogoOnPaymentTab) != null &&
                driver.findElement(mirLogoOnPaymentTab) != null;
    }

    public void clickMoreAboutServiceLink() {
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement detailsLink = wait.until(ExpectedConditions.elementToBeClickable(moreAboutServiceLinkLocator));
        detailsLink.click();
    }

    public void enterPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberLocator).sendKeys(phoneNumber);
    }

    public void enterSum(String sum) {
        driver.findElement(sumLocator).sendKeys(sum);
    }

    public void clickContinueButton() {
        WebElement continueBtn = driver.findElement(continueButtonLocator);
        continueBtn.click();
    }

    public void switchToIframe() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(iframeLocator));
        driver.switchTo().frame(iframe);
    }

    public void selectPaymentType(String paymentType) {
        WebElement serviceTypeDropdown = driver.findElement(serviceTypeLocator);
        serviceTypeDropdown.click();
        Select select = new Select(driver.findElement(paymentTypeDropdown1));
        select.selectByVisibleText(paymentType);
    }

    public String[] getPlaceholderTexts1() {
        String phoneNumberPlaceholder = driver.findElement(phoneNumberLocator).getAttribute("placeholder");
        String totalSumPlaceholder = driver.findElement(sumLocator).getAttribute("placeholder");
        String connectionEmailPlaceholder = driver.findElement(emailLocator).getAttribute("placeholder");

        return new String[]{
                phoneNumberPlaceholder,
                totalSumPlaceholder,
                connectionEmailPlaceholder
        };
    }

    public String[] getPlaceholderTexts2() {
        String phonePlaceholder = driver.findElement(internetPhoneLocator).getAttribute("placeholder");
        String totalSumPlaceholder = driver.findElement(sumLocator).getAttribute("placeholder");
        String connectionEmailPlaceholder = driver.findElement(emailLocator).getAttribute("placeholder");

        return new String[]{
                phonePlaceholder,
                totalSumPlaceholder,
                connectionEmailPlaceholder
        };
    }

    public String[] getPlaceholderTexts3() {
        String accountNumberPlaceholder = driver.findElement(accountNumber44Locator).getAttribute("placeholder");
        String totalSumPlaceholder = driver.findElement(sumLocator).getAttribute("placeholder");
        String connectionEmailPlaceholder = driver.findElement(emailLocator).getAttribute("placeholder");

        return new String[]{
                accountNumberPlaceholder,
                totalSumPlaceholder,
                connectionEmailPlaceholder
        };
    }

    public String[] getPlaceholderTexts4() {
        String accountNumberPlaceholder = driver.findElement(accountNumber2073Locator).getAttribute("placeholder");
        String totalSumPlaceholder = driver.findElement(sumLocator).getAttribute("placeholder");
        String connectionEmailPlaceholder = driver.findElement(emailLocator).getAttribute("placeholder");

        return new String[]{
                accountNumberPlaceholder,
                totalSumPlaceholder,
                connectionEmailPlaceholder
        };
    }


    public String[] getPaymentPageTexts() {
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        String paymentSum = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentSumLocator)).getText();
        String paymentSumOnButton = driver.findElement(paymentSumOnButtonLocator).getText();
        String phoneNumberOnPaymentForm = driver.findElement(phoneNumberOnPaymentFormLocator).getText();
        String creditCardNumberPlaceholder = driver.findElement(creditCardNumberPlaceholderLocator).getText();
        String expirationDatePlaceholder = driver.findElement(expirationDatePlaceholderLocator).getText();
        String cvcPlaceholder = driver.findElement(cvcPlaceholderLocator).getText();
        String holdersName = driver.findElement(holdersNameLocator).getText();

        return new String[]{
                paymentSum,
                paymentSumOnButton,
                phoneNumberOnPaymentForm,
                creditCardNumberPlaceholder,
                expirationDatePlaceholder,
                cvcPlaceholder,
                holdersName
        };
    }

}


