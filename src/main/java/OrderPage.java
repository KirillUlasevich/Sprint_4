import org.openqa.selenium.*;

public class OrderPage {
    public static final String URL = "https://qa-scooter.praktikum-services.ru/";
    private final WebDriver driver;
    private final By acceptCookiesButton = By.className("App_CookieButton__3cvqF"); // кнопка принятия куки
    private final By createOrderTopButton = By.className("Button_Button__ra12g"); // кнопка создания заказа вверху страницы
    private final By createOrderBottomButton = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Заказать']"); // кнопка создания заказа внизу страницы
    private final By fieldName = By.xpath(".//input[@placeholder = '* Имя']"); //поле ввода имени
    private final By fieldSecondName = By.xpath(".//input[@placeholder = '* Фамилия']"); // поле ввода фамилии
    private final By fieldAddress = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']"); // поле ввода адреса
    private final By metroStationList = By.xpath(".//input[@class='select-search__input']"); // поле выбора станции метро
    private final String xpathRentalPeriodDropDown = "//div[@class ='Dropdown-option' and text() = '%s']"; // выбор станции
    private final By fieldPhone = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']"); // поле ввода телефона
    private final By furtherButton = By.xpath(".//button[@class ='Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Далее']"); // кнопка далее ко второй форме заказа
    private final By orderDateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']"); // поле ввода адреса доставки
    private final By rentalPeriodField = By.xpath(".//div[@class='Dropdown-placeholder']"); // поле выбора срока аренды
    private final By orderComment = By.xpath(".//input[@placeholder = 'Комментарий для курьера']"); // поле ввода комментария к заказу
    private final String xpathSamokatColorBox = "//input[@class = 'Checkbox_Input__14A2w' and @id = '%s']"; // цвет самоката
    private final By finalOrderButton = By.xpath(".//button[@class ='Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Заказать']"); // кнопка "Заказать", завершающая заказ
    private final By yesOrderButton = By.xpath(".//button[@class ='Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Да']"); // кнопка "Да", подтверждающая создание заказа
    private final By orderNotCreated = By.className("Order_ModalHeader__3FDaJ"); // поле подтверждения создания заказа

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public OrderPage clickAcceptCookiesButton() {
        driver.findElement(acceptCookiesButton).click();
        return this;
    }  // клик по кнопке принятия куки

    public OrderPage clickCreateOrderTopButton() {
        driver.findElement(createOrderTopButton).click();
        return this;
    } // клик кнопки заказа вверху страницы

    public OrderPage clickCreateOrderBottomButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Заказать']")));
        driver.findElement(createOrderBottomButton).click();
        return this;
    } // клик кнопки заказа внизу страницы

    public OrderPage fillName(String name) {
        driver.findElement(fieldName).sendKeys(name);
        return this;
    } // ввод имени

    public OrderPage fillSecondName(String secondName) {
        driver.findElement(fieldSecondName).sendKeys(secondName);
        return this;
    } // ввод фамилии

    public OrderPage fillAddress(String address) {
        driver.findElement(fieldAddress).sendKeys(address);
        return this;
    } // ввод адреса

    public OrderPage fillMetroStation(String metroStation) {
        driver.findElement(metroStationList).click();
        driver.findElement(metroStationList).sendKeys(metroStation + Keys.ARROW_DOWN + Keys.ENTER);
        return this;
    } // выбор станции метро

    public OrderPage fillPhone(String phone) {
        driver.findElement(fieldPhone).sendKeys(phone);
        return this;
    } // ввод номера телефона

    public OrderPage clickFurtherButton() {
        driver.findElement(furtherButton).click();
        return this;
    } // клик по кнопке "Далее" ко второй форме заказа

    public OrderPage fillOrderDate(String orderDate) {
        driver.findElement(orderDateField).sendKeys(orderDate);
        return this;
    } // выбор даты доставки

    public OrderPage chooseSamokatColor(String color) {
        driver.findElement(By.xpath(String.format(xpathSamokatColorBox, color))).click();
        return this;
    } // выбор цвета самоката

    public OrderPage fillOrderTerm(String rentalPeriod) {
        driver.findElement(rentalPeriodField).click();
        driver.findElement(By.xpath(String.format(xpathRentalPeriodDropDown, rentalPeriod))).click();
        return this;
    } // выбор срока аренды

    public OrderPage orderComment(String comment) {
        driver.findElement(orderComment).sendKeys(comment);
        return this;
    } // ввод комментария к заказу

    public OrderPage clickFinalOrderButton() {
        driver.findElement(finalOrderButton).click();
        return this;
    } // клик по кнопке "Заказать", завершающей создание заказа

    public OrderPage clickYesOrderButton() {
        driver.findElement(yesOrderButton).click();
        return this;
    } // клик по кнопке "Да", подтверждающей создание заказа

    public boolean isOrderNotCreated() {
        return driver.findElement(orderNotCreated).isDisplayed();
    } // проверка появления поля, подтверждающего создание заказа

    public OrderPage fillOrderDetailsForm(OrderData orderData) {
        fillName(orderData.getName());
        fillSecondName(orderData.getSecondName());
        fillAddress(orderData.getAddress());
        fillMetroStation(orderData.getMetroStation());
        fillPhone(orderData.getPhone());
        clickFurtherButton();
        fillOrderDate(orderData.getOrderDate());
        chooseSamokatColor(orderData.getSamokatColor());
        fillOrderTerm(orderData.getOrderTerm());
        orderComment(orderData.getCommentForDelivery());
        clickFinalOrderButton();
        clickYesOrderButton();
        return this;
    } // метод заполнения формы заказа с кликами по сопутствующим кнопкам
}


