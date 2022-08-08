import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;

    @Before
    public void setUp() {
        //Переменная для инициализации драйвера необходимого браузера
        driver = new ChromeDriver();
        //Метод разворачивает браузер на весь экран
        driver.manage().window().maximize();
        //Метод устаналивает неявное ожидание в 10 секунд
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        //Метод закрывает браузер
        driver.quit();
    }

    //Метод переключает драйвер на новое окно и ожидает отображения URL
    public void switchToNewWindow() {
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.urlContains("http"));
    }
}
