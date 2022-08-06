import org.junit.Test;
import page.MainPage;

import static org.junit.Assert.assertEquals;

/*Тест 1: Если нажать на логотип «Самоката», осуществляется переход на главную страницу «Самоката».
Тест 2: Если нажать на логотип Яндекса, в новом окне откроется главная страница Яндекса.*/
public class LogoRedirectionTests extends BaseTest{

    @Test
    public void testScooterLogoRedirectsToMainPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickScooterLogo();
        assertEquals(mainPage.mainPageUrl, driver.getCurrentUrl());
    }

    @Test
    public void testYandexLogoRedirectsToYandexMainPage() {
        String expectedUrl = "https://yandex.ru/";

        MainPage mainPage = new MainPage(driver);
        mainPage.clickYandexLogo();
        switchToNewWindow();
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }
}
