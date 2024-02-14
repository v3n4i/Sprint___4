import MainPageCheck.Elements;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static MainPageCheck.Elements.*;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class MainPage {

    private final By button;
    private final By checkText;
    private final String expected;

    public MainPage(By button, By checkText, String expected) {
        this.button = button;
        this.checkText = checkText;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {


        return new Object[][]{
                {zeroHeading, zeroCheck, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {firstHeading, firstCheck, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {secondHeading, secondCheck, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {thirdHeading, thirdCheck, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {fourthHeading, fourthCheck, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {fifthHeading, fifthCheck, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {sixthHeading, sixthCheck, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {seventhHeading, seventhCheck, "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        };
    }

    protected WebDriver driver =  new ChromeDriver();


    @Before
    public void beforeMethod() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void headersTest() {
        Elements elements = new Elements(driver);
        elements.clickOnCookie();
        elements.scrollUntilElement(mainQuestionsText);
        new WebDriverWait(driver, Duration.ofSeconds(700)).until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[text()='Вопросы о важном']")));
        elements.clickArrowOne(button);
        assertEquals(expected, elements.getTextOfArrow(checkText));
    }

    @After
    public void quitFromBrowser() {
        driver.quit();
    }
}

