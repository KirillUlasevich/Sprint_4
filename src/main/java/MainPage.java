import org.openqa.selenium.*;

public class MainPage {

    public static final String URL = "https://qa-scooter.praktikum-services.ru/";
    private final WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public static String questionButton = "accordion__heading-%s"; // кнопки с вопросами
    public static String answerText = "accordion__panel-%s"; // ответы на вопросы
    public static By accordionButton(String number) {
        return By.id(String.format(questionButton, number));
    } // номер для кнопок
    public MainPage scrollToFaq() {
        WebElement element = driver.findElement(By.className("Home_FAQ__3uVm4"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        return this;
    } // Скролл до FAQ
    public static By accordionText(String number) {
        return By.id(String.format(answerText, number));
    }  // номер для ответов

    public MainPage clickAcceptCookiesButton() {
        driver.findElement(acceptCookiesButton).click();
        return this;
    } // метода нажатия на кнопку куки
    private final By acceptCookiesButton = By.className("App_CookieButton__3cvqF"); // кнопка принятия куки
    public MainPage clickButton(String number) {
        driver.findElement(accordionButton(number)).click();
        return this;
    } // клик по кнопкам с вопросами
    public String getText(String number) {
        return driver.findElement(accordionText(number)).getText();
    } // возвращение текста ответов на вопросы
}

