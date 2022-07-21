import PageObject.OrderPage;
import model.OrderData;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class SamokatFullOrderTest extends BaseTest {

    @Test
    public void fullOrderTestTopButton() {
        OrderData orderData = new OrderData("Заказчик", "Заказов","Ул.Самокатная, д.5", "Черкизовская", "+79111234567", "20.12.2022","двое суток", "black", "Побыстрее!");
        boolean isOrderNotCreated = new OrderPage(driver)
                .clickAcceptCookiesButton()
                .clickCreateOrderTopButton()
                .fillOrderDetailsForm(orderData)
                .isOrderNotCreated();
        assertTrue(isOrderNotCreated);
    }

    @Test
    public void fullOrderTestBottomButton() {
        OrderData orderData = new OrderData("Самокат", "Самокатов","Ул.Заказчиков, д.5", "Лубянка", "+79111267567", "20.12.2023","трое суток", "grey", "Погнали!");
        boolean isOrderNotCreated = new OrderPage(driver)
                .clickAcceptCookiesButton()
                .clickCreateOrderBottomButton()
                .fillOrderDetailsForm(orderData)
                .isOrderNotCreated();
        assertTrue(isOrderNotCreated);
    }
}





