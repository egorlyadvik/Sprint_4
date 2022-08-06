import org.junit.Test;
import page.MainPage;

import static org.junit.Assert.assertTrue;

//Тест: Если ввести неправильный номер заказа, осуществляется переход на страницу статуса заказа с сообщением, что такого заказа нет, и не появляется блок с информацией о заказе.
public class OrderNotFoundTest extends BaseTest{

    @Test
    public void testOrderNotFoundBlockForWrongNumberIsDisplayed() {
        assertTrue(new MainPage(driver)
                .clickOrderStatusButton()
                .fillOrderNumberInput("100")
                .clickFindOrderButton()
                .checkOrderNotFoundBlockIsDisplayed());
    }
}
