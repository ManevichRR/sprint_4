package pages;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.containsString;

public class ScooterOrderPage {
    private final WebDriver driver;
    public ScooterOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // Ввод имени в Поле ввода имени
    public ScooterOrderPage inputFirstName(String firstName) {
        driver.findElement(By.xpath("//input[@placeholder= '* Имя']")).sendKeys(firstName);
        return this;
    }

    // Ввод фамилии в Поле ввода фамилии
    public ScooterOrderPage inputSecondName(String secondName) {
        driver.findElement(By.xpath("//input[@placeholder= '* Фамилия']")).sendKeys(secondName);
        return this;
    }

    // Ввод адреса в Поле ввода адреса
    public ScooterOrderPage inputAdress(String adress) {
        driver.findElement(By.xpath("//input[@placeholder= '* Адрес: куда привезти заказ']")).sendKeys(adress);
        return this;
    }

    // Выбор метро - клик по полю
    public void clickMetro() {
        driver.findElement(By.className("select-search")).click();
    }

    // Ввод названия станции и Клик по выпавшей станции
    public void choseMetroStation(String metroStation) {
        driver.findElement(By.className("select-search__input")).sendKeys(metroStation);
        driver.findElement(By.className("select-search__select")).click();
    }

    // Ввод в Поле ввода номера телефона
    public ScooterOrderPage inputPhoneNumber(String phoneNumber) {
        driver.findElement(By.xpath("//input[@placeholder= '* Телефон: на него позвонит курьер']")).sendKeys(phoneNumber);
        return this;
    }

    // Нажать "Далее"
    public void clickNext() {
        driver.findElement(By.xpath("//button[@class= 'Button_Button__ra12g Button_Middle__1CSJM']")).click();
    }



}