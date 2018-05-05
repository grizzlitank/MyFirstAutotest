import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by aasx .
 */
public class MyWebTest {
    WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rkn.gov.ru/");
    }

    @After
    public void tearDown(){
        driver.quit();
    }


    @Test
    public void rkn_test_1() throws InterruptedException {

        WebElement webElement = driver.findElement(By.xpath(".//td[text()='Массовые коммуникации']"));
        new Actions(driver).moveToElement(webElement).perform();

        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[text()='Контрольная и надзорная деятельность в сфере электронных коммуникаций']"))));

        WebElement control = driver.findElement(By.xpath(".//*[text()='Контрольная и надзорная деятельность в сфере электронных коммуникаций']"));
        control.click();

        WebElement territoryButton = driver.findElement(By.id("territory"));
        Select terriotrySelect = new Select(territoryButton);
        terriotrySelect.selectByValue("77");

        WebElement title = driver.findElement(By.xpath(".//div[@id='page_title']/p[text()!='']"));
        Assert.assertEquals("Титульник страницы соответстувет выбору в селекте",
                "Управление Роскомнадзора по Центральному федеральному округу", title.getText());

        WebElement address= driver.findElement(By.xpath(".//*[text()='Адрес']/following-sibling::td"));
        String factAddress = address.getText();
        Assert.assertTrue("Адресс ведомства не соответствует Москве: "+factAddress, factAddress.contains("Москва"));
        Assert.assertFalse("Адресс ведомства соответствует Спб (вместо МСК): "+factAddress, factAddress.contains("Санкт-Петербург"));

    }

}
