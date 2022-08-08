package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {

    WebDriver driver;
    //Поле ввода имени
    @FindBy(xpath = ".//input[@placeholder='* Имя']")
    private WebElement nameInput;
    //Поле ввода фамилии
    @FindBy(xpath = ".//input[@placeholder='* Фамилия']")
    private WebElement surnameInput;
    //Поле ввода адреса
    @FindBy(xpath = ".//input[@placeholder='* Адрес: куда привезти заказ']")
    private WebElement addressInput;
    //Поле ввода станции метро
    @FindBy(className = "select-search__input")
    private WebElement subwayInput;
    //Поле ввода телефона
    @FindBy(xpath = ".//input[@placeholder='* Телефон: на него позвонит курьер']")
    private WebElement phoneInput;
    //Кнопка "Далее"
    @FindBy(xpath = ".//button[text()='Далее']")
    private WebElement continueButton;
    //Поле ввода даты аренды
    @FindBy(xpath = ".//input[@placeholder='* Когда привезти самокат']")
    private WebElement dateInput;
    //Поле выбора срока аренды
    @FindBy(xpath = ".//div[text()='* Срок аренды']")
    private WebElement durationOfRentInput;
    //Поле ввода комментария для курьера
    @FindBy(xpath = ".//input[@placeholder='Комментарий для курьера']")
    private WebElement commentInput;
    //Кнопка оформления заказа
    @FindBy(xpath = ".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']")
    private WebElement makeOrderButton;
    //Кнопка согласия с оформлением заказа
    @FindBy(xpath = ".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']")
    private WebElement acceptOrderButton;
    //Всплывающее окно с сообщением об успешном создании заказа
    @FindBy(xpath = ".//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']")
    private WebElement successOrderWindow;

    //Конструктор класса
    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Метод заполняет поле ввода имени
    public OrderPage fillNameInput(String name) {
        nameInput.sendKeys(name);
        return this;
    }

    //Метод заполняет поле ввода фамилии
    public OrderPage fillSurnameInput(String surname) {
        surnameInput.sendKeys(surname);
        return this;
    }

    //Метод заполняет поле ввода адреса
    public OrderPage fillAddressInput(String address) {
        addressInput.sendKeys(address);
        return this;
    }

    //Метод заполняет поле ввода станции метро
    public OrderPage fillSubwayInput(String station) {
        subwayInput.click();
        driver.findElement(By.xpath(".//div[text() = '" + station + "']")).click();
        return this;
    }

    //Метод заполняет поле ввода телефона
    public OrderPage fillPhoneInput(String phone) {
        phoneInput.sendKeys(phone);
        return this;
    }

    //Метод нажимает кнопку "Далее"
    public OrderPage clickContinueButton() {
        continueButton.click();
        return this;
    }

    //Метод заполняет поле ввода даты аренды
    public OrderPage fillDateInput(String date) {
        dateInput.sendKeys(date, Keys.ENTER);
        return this;
    }

    //Метод выбирает срок аренды
    public OrderPage fillDurationOfRentInput(String duration) {
        durationOfRentInput.click();
        driver.findElement(By.xpath(".//div[@class='Dropdown-option' and text()='" + duration + "']")).click();
        return this;
    }

    //Метод выбирает цвет самоката (условный оператор сделан, чтобы можно было сделать кейс без выбора цвета самоката)
    public OrderPage chooseColourCheckboxes(String colour) {
        if (!colour.equals("")) {
            driver.findElement(By.xpath(".//label[text()='" + colour + "']")).click();
        }
        return this;
    }

    //Метод заполняет поле ввода комментария
    public OrderPage fillCommentInput(String comment) {
        commentInput.sendKeys(comment);
        return this;
    }

    //Метод нажимает кнопку оформления заказа
    public OrderPage clickMakeOrderButton() {
        makeOrderButton.click();
        return this;
    }

    //Метод нажимает кнопку согласия с оформлением заказа
    public OrderPage clickAcceptOrderButton() {
        acceptOrderButton.click();
        return this;
    }

    //Метод проверяет наличие всплывающего окна с сообщением об успешном создании заказа
    public boolean checkSuccessOrderWindowIsDisplayed() {
        return successOrderWindow.isDisplayed();
    }

    //Метод получает текст валидационного сообщения для поля ввода (условный оператор сделан, т.к. для поля "Станция метро" другая структура)
    public String getInputValidationText(String input) {
        if (input.equals("Станция метро")) {
            return driver.findElement(By.className("Order_MetroError__1BtZb")).getText();
        } else {
            return driver.findElement(By.xpath(".//input[@placeholder='* " + input + "']/parent::div/div[@class='Input_ErrorMessage__3HvIb Input_Visible___syz6']")).getText();
        }
    }
}
