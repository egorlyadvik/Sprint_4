package page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderStatusPage {

    WebDriver driver;
    //Блок "Заказ не найден"
    @FindBy(className = "Track_NotFound__6oaoY")
    private WebElement orderNotFoundBlock;
    //Блок с информацией о заказе
    @FindBy(className = "Track_OrderColumns__2r_1F")
    private WebElement orderInfoBlock;

    //Конструктор класса
    public OrderStatusPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Метод проверяет наличие блока "Заказ не найден" и отсутствие блока с информацией о заказе
    public boolean checkOrderNotFoundBlockIsDisplayed() {
        if (orderNotFoundBlock.isDisplayed()) {
            try {
                return !orderInfoBlock.isDisplayed();
            } catch (NoSuchElementException e) {
                return true;
            }
        } else {
            return false;
        }
    }
}
