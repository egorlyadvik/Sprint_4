import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import page.MainPage;

import static org.junit.Assert.assertTrue;

/*Тест 1: Весь флоу заказа самоката (точка входа в сценарий: кнопка «Заказать» вверху страницы)
/*Тест 2: Весь флоу заказа самоката (точка входа в сценарий: кнопка «Заказать» внизу страницы)
Входные данные: Данные для полей ввода (Имя, Фамилия, Адрес, Станция метро, Телефон, Когда привезти самокат, Срок аренды, Цвет самоката, Комментарий для курьра*/
@RunWith(Parameterized.class)
public class OrderTests extends BaseTest {

    private final String name;
    private final String surname;
    private final String address;
    private final String subway;
    private final String phone;
    private final String date;
    private final String duration;
    private final String colour;
    private final String comment;

    public OrderTests(String name, String surname, String address, String subway, String phone, String date, String duration, String colour, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.subway = subway;
        this.phone = phone;
        this.date = date;
        this.duration = duration;
        this.colour = colour;
        this.comment = comment;
    }

    @Parameterized.Parameters(name = "Тестовые данные: Имя = {0}, Фамилия = {1}, Адрес = {2}, Станция метро = {3}, Телефон = {4}, Когда привезти самокат = {5}, Срок аренды = {6}, Цвет самоката = {7}, Комментарий для курьра = {8}")
    public static Object[][] getOrderData() {
        return new Object[][]{
                {"Иван", "Иванов", "Москва", "Черкизовская", "89111231231", "27.08.2022", "сутки", "чёрный жемчуг", "Тест1"},
                {"Сидор", "Сидоров", "Москва, Арбат", "Митино", "+12121231231", "01.01.2023", "семеро суток", "серая безысходность", "Тест2"},
                {"Пётр", "Петров", "Москва, Красная Площаль", "Аэропорт", "+79213213211", "01.09.2022", "четверо суток", "", ""}
        };
    }

    @Test
    public void testUpperOrder() {
        assertTrue(new MainPage(driver)
                .clickUpperOrderButton()
                .fillNameInput(name)
                .fillSurnameInput(surname)
                .fillAddressInput(address)
                .fillSubwayInput(subway)
                .fillPhoneInput(phone)
                .clickContinueButton()
                .fillDateInput(date)
                .fillDurationOfRentInput(duration)
                .chooseColourCheckboxes(colour)
                .fillCommentInput(comment)
                .clickMakeOrderButton()
                .clickAcceptOrderButton()
                .checkSuccessOrderWindowIsDisplayed());
    }

    @Test
    public void testLowerOrder() {
        assertTrue(new MainPage(driver)
                .clickLowerOrderButton()
                .fillNameInput(name)
                .fillSurnameInput(surname)
                .fillAddressInput(address)
                .fillSubwayInput(subway)
                .fillPhoneInput(phone)
                .clickContinueButton()
                .fillDateInput(date)
                .fillDurationOfRentInput(duration)
                .chooseColourCheckboxes(colour)
                .fillCommentInput(comment)
                .clickMakeOrderButton()
                .clickAcceptOrderButton()
                .checkSuccessOrderWindowIsDisplayed());
    }
}
