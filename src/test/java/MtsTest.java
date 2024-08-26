import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.TimeoutException;


public class MtsTest {
    private WebDriver driver;
    private WebDriverWait wait;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");

        try {
            WebElement cookieCloseButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#cookie-agree")));
            cookieCloseButton.click();
        } catch (NoSuchElementException | TimeoutException e) {

        }
    }

    @Test
    public void testOnlineRefillBlock() {
        WebElement refillBlock =
                driver.findElement(By.xpath("//h2[contains(normalize-space(), \"Онлайн пополнение\") and contains(normalize-space(), \"без комиссии\")]"));
        Assert.assertNotNull("Блок не найден", refillBlock);
    }

    @Test
    public void testLogo() {
        WebElement visaLogo = driver.findElement(By.xpath("//img[@alt=\"Visa\"]"));
        WebElement verifiedByVisaLogo = driver.findElement(By.xpath("//img[@alt=\"Verified By Visa\"]"));
        WebElement masterCardLogo = driver.findElement(By.xpath("//img[@alt=\"MasterCard\"]"));
        WebElement masterCardSecureCodeLogo = driver.findElement(By.xpath("//img[@alt=\"MasterCard Secure Code\"]"));
        WebElement belkartLogo = driver.findElement(By.xpath("//img[@alt=\"Белкарт\"]"));

        Assert.assertNotNull("Логотип не найден", visaLogo);
        Assert.assertNotNull("Логотип не найден", verifiedByVisaLogo);
        Assert.assertNotNull("Логотип не найден", masterCardLogo);
        Assert.assertNotNull("Логотип не найден", masterCardSecureCodeLogo);
        Assert.assertNotNull("Логотип не найден", belkartLogo);
    }

    @Test
    public void testMoreAboutService() {
        WebElement detailsLink = driver.findElement(By.xpath("//a[@href=\"/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/\"]"));
        detailsLink.click();
        WebElement serviceNameElement = driver.findElement(By.xpath("//span[@itemprop='name' and text()='Порядок оплаты и безопасность интернет платежей']"));
        Assert.assertNotNull("Страница не загрузилась", serviceNameElement);

    }

    @Test
    public void testContinueButton() {
        WebElement phoneNumber = driver.findElement(By.id("connection-phone"));
        phoneNumber.sendKeys("297777777");

        WebElement sum = driver.findElement(By.id("connection-sum"));
        sum.sendKeys("77");

        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        continueButton.click();

        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("iframe.bepaid-iframe")));
        driver.switchTo().frame(iframe);
        WebElement expectedElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"pay-description__text\"]")));

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}