package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImportantQuestionPage {

    private final WebDriver driver;
    // Верхняя кнопка заказать, xPath локатор
    private final String locatorButtonOrderUP = ".//button[@class='Button_Button__ra12g']";
    //Нижняя кнопка заказать, xPath локатор
    private final String locatorButtonOrderDOWN = ".//div[@class='Home_FinishButton__1_cWm']/button";

    public ImportantQuestionPage(WebDriver driver) {
        this.driver = driver;
    }

    // Открыть страницу с сайтом
    public void openMainPage() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    // Кликнуть по строке в "Вопросы о важном"
    public void clickAccordeonHeading(String locatorAccordeonHeading) {
        WebElement element = driver.findElement(By.id(locatorAccordeonHeading));
        // Скролл до элемента
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        // Явное ожидание видимости элемента
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(By.id(locatorAccordeonHeading)));
        // Кликаем по строке
        element.click();
    }

    // Получить текст из строки "Вопросы о важном"
    public String getTextAccordeonHeading(String locatorAccordeonHeading) {
        WebElement element = driver.findElement(By.id(String.valueOf(locatorAccordeonHeading)));
        return element.getText();
    }

    // Получить текст после клика по строке в Вопросы о важном
    public String getTextAccordeonPanel(String locatorAccordeonPanel) {
        // Явное ожидание видимости элемента
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorAccordeonPanel)));
        return driver.findElement(By.id(locatorAccordeonPanel)).getText();
    }

    // Клик по кнопке "Заказать"
    public void clickOrder(int n) {

        if (n == 1) {
            driver.findElement(By.xpath(locatorButtonOrderUP)).click();
        } else {
            // Скролл до элемента
            WebElement element = driver.findElement(By.xpath(locatorButtonOrderDOWN));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            driver.findElement(By.xpath(locatorButtonOrderDOWN)).click();
        }
    }
}