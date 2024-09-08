import io.qameta.allure.*;
import org.example.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
//import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.Assert.assertArrayEquals;

@Epic("MTS test")
@Feature("UI tests")
public class MtsTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private MainPage mainPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        mainPage = new MainPage(driver);
        mainPage.closeCookie();
    }


    @Test
    @Story("Онлайн пополнение без комиссии")
    @Description("Проверка наименования блока \"Онлайн пополнение без комиссии\"")
    public void testOnlineRefillBlock() {
        Assert.assertNotNull("Блок не найден", mainPage.getRefillBlockName());
    }

    @Test
    @Story("Онлайн пополнение без комиссии")
    @Description("Проверка логотипов платёжных систем")
    public void testLogo() {
        Assert.assertTrue("Логотипы не найдены", mainPage.areLogosPresent());
    }

    @Test
    @Story("Онлайн пополнение без комиссии")
    @Description("Проверка ссылки \"Подробнее о сервисе\"")
    public void testMoreAboutServiceLink() {
        mainPage.clickMoreAboutServiceLink();
        WebElement serviceNameElement = driver.findElement(By.xpath("//span[@itemprop='name' and text()='Порядок оплаты и безопасность интернет платежей']"));
        Assert.assertNotNull("Страница не загрузилась", serviceNameElement);
    }



    @Test
    @Story("Онлайн пополнение без комиссии")
    @Description("Проверка варианта \"Услуги связи\": проверка суммы, номера телефона, надписей и логотипов платёжных систем")
    public void testContinueButton() {
        mainPage.enterPhoneNumber("297777777");
        mainPage.enterSum("80");
        mainPage.clickContinueButton();
        mainPage.switchToIframe();
        String[] paymentDetails = mainPage.getPaymentPageTexts();
        String[] expectedPaymentDetails = new String[] {
               "80.00 BYN",
                "Оплатить 80.00 BYN",
                "Оплата: Услуги связи Номер:375297777777",
                "Номер карты",
                "Срок действия",
                "CVC",
                "Имя держателя (как на карте)"
        };
        Assert.assertArrayEquals("Данные не совпадают",expectedPaymentDetails, paymentDetails);
        Assert.assertTrue("Логотипы не найдены", mainPage.areLogosPresentOnPaymentTab());
    }

    @Test
    @Story("Онлайн пополнение без комиссии")
    @Description("Проверка плейсхолдеров для варианта \"Услуги связи\"")
    public void testPlaceholderTexts1() {
        mainPage.selectPaymentType("Услуги связи");
        String[] servicePlaceholders = mainPage.getPlaceholderTexts1();
        String[] expectedServicePlaceholders = new String[]{
                "Номер телефона",
                "Сумма",
                "E-mail для отправки чека"
        };
        assertArrayEquals("Плейсхолдеры не совпадают", expectedServicePlaceholders, servicePlaceholders);
    }

    @Test
    @Story("Онлайн пополнение без комиссии")
    @Description("Проверка плейсхолдеров для варианта \"Домашний интернет\"")
    public void testPlaceholderTexts2() {
        mainPage.selectPaymentType("Домашний интернет");
        String[] servicePlaceholders = mainPage.getPlaceholderTexts2();
        String[] expectedServicePlaceholders = new String[]{
                "Номер абонента",
                "Сумма",
                "E-mail для отправки чека"
        };

        assertArrayEquals("Плейсхолдеры не совпадают", expectedServicePlaceholders, servicePlaceholders);
    }

    @Test
    @Story("Онлайн пополнение без комиссии")
    @Description("Проверка плейсхолдеров для варианта \"Рассрочка\"")
    public void testPlaceholderTexts3() {
        mainPage.selectPaymentType("Рассрочка");
        String[] servicePlaceholders = mainPage.getPlaceholderTexts3();
        String[] expectedServicePlaceholders = new String[]{
                "Номер счета на 44",
                "Сумма",
                "E-mail для отправки чека"
        };
        assertArrayEquals("Плейсхолдеры не совпадают", expectedServicePlaceholders, servicePlaceholders);
    }

    @Test
    @Story("Онлайн пополнение без комиссии")
    @Description("Проверка плейсхолдеров для варианта \"Задолженность\"")
    public void testPlaceholderTexts4() {
        mainPage.selectPaymentType("Задолженность");
        String[] servicePlaceholders = mainPage.getPlaceholderTexts4();
        String[] expectedServicePlaceholders = new String[]{
                "Номер счета на 2073",
                "Сумма",
                "E-mail для отправки чека"
        };
        assertArrayEquals("Плейсхолдеры не совпадают", expectedServicePlaceholders, servicePlaceholders);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}