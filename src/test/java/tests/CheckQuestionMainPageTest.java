package tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ImportantQuestionPage;

import static org.junit.Assert.assertEquals;

// 1) Выпадающий список в разделе «Вопросы о важном».


//Параметризированный тест
@RunWith(Parameterized.class) // fixed (comment to delete after finishing task)
public class CheckQuestionMainPageTest {

    private WebDriver driver;

    @Before
    public void startUp() {


        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
       /* WebDriverManager.firefoxdriver();
       driver = new FirefoxDriver(); */
    }

    private final String locatorAccordeonHeading;
    private final String expectedTextAccordeonHeading;
    private final String locatorAccordeonPanel;
    private final String expectedTextAccordeonPanel;

    public CheckQuestionMainPageTest(String locatorAccordeonHeading, String expectedTextAccordeonHeading, String locatorAccordeonPanel, String expectedTextAccordeonPanel) {
        this.locatorAccordeonHeading = locatorAccordeonHeading;
        this.expectedTextAccordeonHeading = expectedTextAccordeonHeading;
        this.locatorAccordeonPanel = locatorAccordeonPanel;
        this.expectedTextAccordeonPanel = expectedTextAccordeonPanel;
    }

    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        //Test data
        return new Object[][] {
                { "accordion__heading-0", "Сколько это стоит? И как оплатить?", "accordion__panel-0", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                { "accordion__heading-1", "Хочу сразу несколько самокатов! Так можно?", "accordion__panel-1",
                        "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                { "accordion__heading-2", "Как рассчитывается время аренды?","accordion__panel-2",
                        "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                { "accordion__heading-3", "Можно ли заказать самокат прямо на сегодня?", "accordion__panel-3", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                { "accordion__heading-4", "Можно ли продлить заказ или вернуть самокат раньше?", "accordion__panel-4", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                { "accordion__heading-5", "Вы привозите зарядку вместе с самокатом?", "accordion__panel-5", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                { "accordion__heading-6", "Можно ли отменить заказ?", "accordion__panel-6", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                { "accordion__heading-7", "Я жизу за МКАДом, привезёте?", "accordion__panel-7", "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Test
    public void checkTestOnAccordeonHeadingAndAccordeonPanel() {

        // Создали объект главной страницы
        ImportantQuestionPage questions = new ImportantQuestionPage(driver);

        // переход на страницу тестового приложения
        questions.openMainPage();

        // Нашли 1 строку в разделе «Вопросы о важном» и нажали на неё
        questions.clickAccordeonHeading(locatorAccordeonHeading);

        // Проверка текста в "Вопросы о важном" в строке
        assertEquals(expectedTextAccordeonHeading, questions.getTextAccordeonHeading(locatorAccordeonHeading));

        // Проверка текста в "Вопросы о важном" в выпадающем (после клика по строке)
        assertEquals(expectedTextAccordeonPanel, questions.getTextAccordeonPanel(locatorAccordeonPanel));
    }

    @After
    public void tearDown() {
        // Закрой браузер
        driver.quit();

    }

}
