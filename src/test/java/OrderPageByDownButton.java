import OrderPageCheck.OrderElements;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.*;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class OrderPageByDownButton {

    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phone;
    private final String date;
    private final String limit;
    private final String color;
    private final boolean expected;

    public OrderPageByDownButton(String name, String surname, String address, String metro, String phone, String date, String limit, String color, boolean expected) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.limit = limit;
        this.color = color;
        this.expected = expected;

    }


    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Вадим", "Куликов", "г. Саратов, ул. Большая Горная 313, кв.47", "Черкизовская", "79372680801", "01.03.2024", "сутки", "чёрный жемчуг", true},
                {"Дима", "Козин", "г. Саратов, ул. Астраханская 57 кв.34", "Сокольники", "79372680801", "05.03.2024", "двое суток", "серая безысходность", true}

        };
    }


    protected WebDriver driver;

    @Before
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void orderPageTest() {
        OrderElements singleElements = new OrderElements(driver);
        singleElements.clickOrderTwoButton();
        singleElements.fillName(name);
        singleElements.fillSurname(surname);
        singleElements.fillAddress(address);
        singleElements.selectMetro(metro);
        singleElements.fillPhoneInOrderPage(phone);
        singleElements.pressNextButton();
        singleElements.setDate(date);
        singleElements.setLimitOfRent(limit);
        singleElements.selectColor(color);
        singleElements.startOrder();
        singleElements.yesButtonClick();
        assertEquals(expected, singleElements.validationOfFirstOrderPage());

    }

    @After
    public void quit() {
        driver.quit();
    }
}


