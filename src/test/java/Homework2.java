import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homework2 {
    WebDriver driver;

    @FindBy(xpath = ".//a[@class='kit-link kit-link_color_black region-list__toggler']")
    public WebElement region;

    @FindBy(xpath = ".//input[@placeholder='Введите название региона']")
    public WebElement regionFind;

    @FindBy(xpath = ".//div[@data-value='52']")
    public WebElement regionNO;

    @FindBy(xpath = ".//div[@class='footer-info']")
    public WebElement footer;

    @FindBy(xpath = ".//a[@aria-label='Поделиться в Фейсбук']/span")
    public WebElement fb;

    @FindBy(xpath = ".//a[@aria-label='Поделиться в Твиттер']/span")
    public WebElement tw;

    @FindBy(xpath = ".//a[@aria-label='Поделиться в Ютьюб']/span")
    public WebElement yt;

    @FindBy(xpath = ".//a[@aria-label='Поделиться в Инстаграмм']/span")
    public WebElement inst;

    @FindBy(xpath = ".//a[@aria-label='Поделиться в Вконтакте']/span")
    public WebElement vk;

    @FindBy(xpath = ".//a[@aria-label='Поделиться в Одноклассниках']/span")
    public WebElement odn;


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

    public void waiting(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    @Test
    public void sbt_test_1() throws InterruptedException{
        PageFactory.initElements(driver, this);

        region.click();

        this.waiting(regionFind);

        regionFind.sendKeys("Нижегородская область");

        this.waiting(regionNO);

        regionNO.click();

        new Actions(driver).moveToElement(footer).perform();

        Assert.assertTrue(fb.isEnabled());

        Assert.assertTrue(tw.isEnabled());

        Assert.assertTrue(yt.isEnabled());

        Assert.assertTrue(inst.isEnabled());

        Assert.assertTrue(vk.isEnabled());

        Assert.assertTrue(odn.isEnabled());





    }
}
