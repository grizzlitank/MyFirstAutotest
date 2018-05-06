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
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homework2 {
    WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.sberbank.ru/ru/person\n");
    }


    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void rgs_test_1() throws InterruptedException{
        WebElement webElement = driver.findElement(By.xpath(".//a[@class='kit-link kit-link_color_black region-list__toggler']"));
        webElement.click();

        WebDriverWait wait = new WebDriverWait(driver, 3);


        WebElement webElement1 = driver.findElement(By.xpath(".//input[@placeholder='Введите название региона']"));

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//input[@placeholder='Введите название региона']"))));

        webElement1.sendKeys("Нижегородская область");

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//div[@data-value='52']"))));

        WebElement webElement2 = driver.findElement(By.xpath(".//div[@data-value='52']"));

        webElement2.click();

        WebElement webElement3 = driver.findElement(By.xpath(".//div[@class='footer-info']"));

        new Actions(driver).moveToElement(webElement3).perform();

        WebElement fb = driver.findElement(By.xpath(".//a[@aria-label='Поделиться в Фейсбук']/span"));

        WebElement tw = driver.findElement(By.xpath(".//a[@aria-label='Поделиться в Твиттер']/span"));

        WebElement yt = driver.findElement(By.xpath(".//a[@aria-label='Поделиться в Ютьюб']/span"));

        WebElement inst = driver.findElement(By.xpath(".//a[@aria-label='Поделиться в Инстаграмм']/span"));

        WebElement vk = driver.findElement(By.xpath(".//a[@aria-label='Поделиться в Вконтакте']/span"));

        WebElement odn = driver.findElement(By.xpath(".//a[@aria-label='Поделиться в Одноклассниках']/span"));

        Assert.assertTrue(fb.isEnabled());

        Assert.assertTrue(tw.isEnabled());

        Assert.assertTrue(yt.isEnabled());

        Assert.assertTrue(inst.isEnabled());

        Assert.assertTrue(vk.isEnabled());

        Assert.assertTrue(odn.isEnabled());





    }
}
