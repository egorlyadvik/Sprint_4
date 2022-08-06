package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    WebDriver driver;
    //URL главной страницы
    public final String mainPageUrl = "https://qa-scooter.praktikum-services.ru/";
    //Кнопка соглашения с использованием cookies
    @FindBy(id = "rcc-confirm-button")
    private WebElement acceptCookiesButton;
    //Панель с ответом на выбранный вопрос
    @FindBy(xpath = ".//div[@class='accordion__panel' and not(@hidden)]/p")
    private WebElement answerPanel;
    //Кнопка "Заказать" вверху страницы
    @FindBy(className = "Button_Button__ra12g")
    private WebElement upperOrderButton;
    //Кнопка "Заказать" внизу страницы
    @FindBy(xpath = ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']")
    private WebElement lowerOrderButton;
    //Логотип "Самоката"
    @FindBy(className = "Header_LogoScooter__3lsAR")
    private WebElement scooterLogo;
    //Логотип Яндекса
    @FindBy(className = "Header_LogoYandex__3TSOI")
    private WebElement yandexLogo;
    //Кнопка "Статус заказа"
    @FindBy(className = "Header_Link__1TAG7")
    private WebElement orderStatusButton;
    //Поле ввода номера заказа
    @FindBy(xpath = ".//input[@class='Input_Input__1iN_Z Header_Input__xIoUq']")
    private WebElement orderNumberInput;
    //Кнопка поиска заказа
    @FindBy(xpath = ".//button[@class='Button_Button__ra12g Header_Button__28dPO']")
    private WebElement findOrderInput;

    //Конструктор класса
    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.get(mainPageUrl);
        acceptCookiesButton.click();
    }

    //Метод скроллит страницу до вопроса и кликает на него
    public MainPage scrollAndClickQuestion(String question) {
        WebElement questionElement = driver.findElement(By.xpath(".//div[text()='" + question + "']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", questionElement);
        questionElement.click();
        return this;
    }
    //Метод возвращает текст ответа на выбранный вопрос
    public String getAnswerText() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(answerPanel));
        return answerPanel.getText();
    }
    //Метод кликает на верхнюю кнопку "Заказать"
    public OrderPage clickUpperOrderButton() {
        upperOrderButton.click();
        return new OrderPage(driver);
    }
    //Метод кликает на нижнюю кнопку "Заказать"
    public OrderPage clickLowerOrderButton() {
        lowerOrderButton.click();
        return new OrderPage(driver);
    }
    //Метод кликает на логотип "Самоката"
    public void clickScooterLogo() {
        scooterLogo.click();
    }
    //Метод кликает на логотип Яндекса
    public void clickYandexLogo() {
        yandexLogo.click();
    }
    //Метод кликает на кнопку "Статус заказа"
    public MainPage clickOrderStatusButton() {
        orderStatusButton.click();
        return this;
    }
    //Метод заполняет поле ввода номера заказа
    public MainPage fillOrderNumberInput(String orderNumber) {
        orderNumberInput.sendKeys(orderNumber);
        return this;
    }
    //Метод кликает на кнопку поиска заказа
    public OrderStatusPage clickFindOrderButton() {
        findOrderInput.click();
        return new OrderStatusPage(driver);
    }
}