import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import page.MainPage;

import static org.junit.Assert.assertEquals;

/*Тест: Корректность ошибок для полей формы заказа.
Входные данные: Поле, Ожидаемое валидационное сообщение*/
@RunWith(Parameterized.class)
public class InputValidationTests extends BaseTest{

    private final String input;
    private final String expectedValidation;

    public InputValidationTests(String input, String expectedValidation) {
        this.input = input;
        this.expectedValidation = expectedValidation;
    }

    @Parameterized.Parameters
    public static Object[][] getInputAndValidationData() {
        return new Object[][] {
                {"Имя", "Введите корректное имя"},
                {"Фамилия", "Введите корректную фамилию"},
                {"Адрес: куда привезти заказ", "Введите корректный адрес"},
                {"Станция метро", "Выберите станцию"},
                {"Телефон: на него позвонит курьер", "Введите корректный номер"}
        };
    }

    @Test
    public void orderInputValidationTest() {
        assertEquals(expectedValidation, new MainPage(driver)
                .clickUpperOrderButton()
                .clickContinueButton()
                .fillAddressInput(".")
                .getInputValidationText(input));
    }
}
