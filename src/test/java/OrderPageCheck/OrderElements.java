package OrderPageCheck;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderElements {
    WebDriver driver;
    //кнопка заказать вверху
    public static final By orderOneButton = By.xpath(".//button[@class=\"Button_Button__ra12g\"]");
    // кнопка заказать внизу
    public static final By orderTwoButton = By.xpath(".//button[@class=\"Button_Button__ra12g Button_Middle__1CSJM\"]");
    // икс-пассы для первой страницы заказа: имя, фамилия, адрес, телефон и кнопка далее
    public static final By nameInOrderPage = By.xpath(".//input[@placeholder=\"* Имя\"]");
    public static final By surnameInOrderPage = By.xpath(".//input[@placeholder=\"* Фамилия\"]");
    public static final By addressInOrderPage = By.xpath(".//input[@placeholder=\"* Адрес: куда привезти заказ\"]");
    public static final By phoneInOrderPage = By.xpath(".//input[@placeholder=\"* Телефон: на него позвонит курьер\"]");
    public static final By nextButtonInOrderPage = By.xpath(".//button[text()=\"Далее\"]");
    // икс пассы для второй страницы заказа: дата, выпадающий список для выбора лимита, цвет, кнопка да
    public static final By settledDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    public static final By dropDown = By.xpath(".//div[@class='Dropdown-placeholder']");
    public static final By blackColorOfScooter = By.xpath(".//input[@id=\"black\"]");
    public static final By greyColorOfScooter = By.xpath(".//input[@id=\"grey\"]");
    public static final By startOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    public static final By yesButton = By.xpath(".//div[@class=\"Order_Modal__YZ-d3\"]/*/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //кнопка на проверку - если появилась то ассерт будет passed
    public static final By checkForOrderPage = By.xpath(".//button[text()='Посмотреть статус']");
    //метод для заказа по кнопке наверху
    public void clickOrderOneButton() {
        driver.findElement(orderOneButton).click();
    }
    //метод на заполнение имени(имя из параметризации берётся)
    public void fillName(String name) {
        driver.findElement(nameInOrderPage).sendKeys(name);
    }
    // метод на заполнение фамилии(фамилия из параметризации берётся)
    public void fillSurname(String surname) {
        driver.findElement(surnameInOrderPage).sendKeys(surname);
    }
    // метод на заполнение адреса(адрес из параметризации берётся)
    public void fillAddress(String address) {
        driver.findElement(addressInOrderPage).sendKeys(address);
    }
    //метод на заполнение номера телефона (берётся из параметризации)
    public void fillPhoneInOrderPage(String phone) {
        driver.findElement(phoneInOrderPage).sendKeys(phone);
    }
    //метод нажатия на кнопку
    public void pressNextButton() {
        driver.findElement(nextButtonInOrderPage).click();
    }
    //переменная для ассерта
    boolean result;
    //метод для ассерта на AR (нашли кнопку и взяли текст, если текст равен "Посмотреть статус", то вернули true)
    public boolean validationOfFirstOrderPage() {
        String str = driver.findElement(checkForOrderPage).getText();
        if (str.equals("Посмотреть статус"))
            result = true;
        else
            result = false;
        return result;

    }
    //метод для выбора цвета самоката
    public void selectColor(String scooterColor) {
        if (scooterColor.equals("чёрный жемчуг")) {
            driver.findElement(blackColorOfScooter).click();
        } else if (scooterColor.equals("серая безысходность")) {
            driver.findElement(greyColorOfScooter).click();
        }
    }
    //
    public OrderElements(WebDriver driver) {
        this.driver = driver;
    }
    //метод для выбора метро
    public void selectMetro(String metro) {
        String metroSearchFormatter = String.format(".//div[@class=\"select-search has-focus\"]//*[text()='%s']", metro);
        driver.findElement(By.xpath(".//div[@class=\"select-search__value\"]")).click();
        driver.findElement(By.xpath(metroSearchFormatter)).click();
    }
    //метод проставления даты
    public void setDate(String date) {
        driver.findElement(settledDate).sendKeys(date);
        driver.findElement(By.xpath(".//div[@class='App_App__15LM-']")).click();
    }
    // метод для выбора количества времени на аренду самоката
    public void setLimitOfRent(String limit) {
        String limitOfRentFormatter = String.format(".//div[@class='Dropdown-menu']/div[text()='%s']", limit);
        driver.findElement(dropDown).click();
        driver.findElement(By.xpath(limitOfRentFormatter)).click();
    }
    // метод нажатия на кнопку заказать
    public void startOrder() {
        driver.findElement(startOrderButton).click();
    }
    // метод для нажатия на кнопку ДА
    public void yesButtonClick() {
        driver.findElement(yesButton).click();
    }

    //метод для заказа по кнопке внизу
    public void clickOrderTwoButton() {
        driver.findElement(orderTwoButton).click();}
}