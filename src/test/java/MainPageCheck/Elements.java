package MainPageCheck;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class Elements {
    WebDriver driver;
    //икс пасс для нахождения вопросов о важном
    public static final By mainQuestionsText = By.xpath(".//div[text()='Вопросы о важном']");
    //кнопка куки
    public static final By cookieButton = By.xpath(".//button[text()='да все привыкли']");
    //икс пассы для выпадающего списка "все о главном" и их проверки(текст)
    public static final By zeroHeading = By.id("accordion__heading-0");
    public static final By zeroCheck = By.xpath(".//div[@aria-labelledby=\"accordion__heading-0\"]/p");
    public static final By firstHeading = By.id("accordion__heading-1");
    public static final By firstCheck = By.xpath(".//div[@aria-labelledby=\"accordion__heading-1\"]/p");
    public static final By secondHeading = By.id("accordion__heading-2");
    public static final By secondCheck = By.xpath(".//div[@aria-labelledby=\"accordion__heading-2\"]/p");
    public static final By thirdHeading = By.id("accordion__heading-3");
    public static final By thirdCheck = By.xpath(".//div[@aria-labelledby=\"accordion__heading-3\"]/p");
    public static final By fourthHeading = By.id("accordion__heading-4");
    public static final By fourthCheck = By.xpath(".//div[@aria-labelledby=\"accordion__heading-4\"]/p");
    public static final By fifthHeading = By.id("accordion__heading-5");
    public static final By fifthCheck = By.xpath(".//div[@aria-labelledby=\"accordion__heading-5\"]/p");
    public static final By sixthHeading = By.id("accordion__heading-6");
    public static final By sixthCheck = By.xpath(".//div[@aria-labelledby=\"accordion__heading-6\"]/p");
    public static final By seventhHeading = By.id("accordion__heading-7");
    public static final By seventhCheck = By.xpath(".//div[@aria-labelledby=\"accordion__heading-7\"]/p");
    //метод для нажатия на кнопку куки
    public void clickOnCookie() {
        driver.findElement(cookieButton).click();
    }
    public Elements(WebDriver driver) {
        this.driver = driver;
    }
    //метод для нажатия на нужную стрелочку
    public void clickArrowOne(By button) {
        driver.findElement(button).click();
    }
    //метод скролла до нужно элемента
    public void scrollUntilElement(By button) {
        WebElement element = driver.findElement(button);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    //метод забора текста
    public String getTextOfArrow(By button) {
        return driver.findElement(button).getText();
    }
}
