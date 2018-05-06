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
        WebElement webElement = driver.findElement(By.xpath(".//*[@id='main']/div/div/table/tbody/tr/td/div/div/div/div/div/div[1]/div[1]/div[3]/div/div[2]/div[1]/div/div/div/form/div[3]/a"));
        webElement.click();

        WebDriverWait wait = new WebDriverWait(driver, 3);


        WebElement webElement1 = driver.findElement(By.xpath("html/body/div[7]/div/div[2]/div[2]/div/div[1]/div/div[1]/input"));

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("html/body/div[7]/div/div[2]/div[2]/div/div[1]/div/div[1]/input"))));

        webElement1.sendKeys("Нижегородская область");

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("html/body/div[8]/div/div/div"))));

        WebElement webElement2 = driver.findElement(By.xpath("html/body/div[8]/div/div/div"));

        webElement2.click();

        WebElement webElement3 = driver.findElement(By.xpath(".//*[@id='main']/div/div/table/tbody/tr/td/div/div/div/div/div/div[3]/div/div[2]/div/div/div[3]/div/div"));

        new Actions(driver).moveToElement(webElement3).perform();

        WebElement fb = driver.findElement(By.xpath(".//*[@id='main']/div/div/table/tbody/tr/td/div/div/div/div/div/div[3]/div/div[2]/div/div/div[2]/div/div/div/div/ul/li[1]/a/span"));

        WebElement tw = driver.findElement(By.xpath(".//*[@id='main']/div/div/table/tbody/tr/td/div/div/div/div/div/div[3]/div/div[2]/div/div/div[2]/div/div/div/div/ul/li[2]/a/span"));

        WebElement yt = driver.findElement(By.xpath(".//*[@id='main']/div/div/table/tbody/tr/td/div/div/div/div/div/div[3]/div/div[2]/div/div/div[2]/div/div/div/div/ul/li[3]/a/span"));

        WebElement inst = driver.findElement(By.xpath(".//*[@id='main']/div/div/table/tbody/tr/td/div/div/div/div/div/div[3]/div/div[2]/div/div/div[2]/div/div/div/div/ul/li[4]/a/span"));

        WebElement vk = driver.findElement(By.xpath(".//*[@id='main']/div/div/table/tbody/tr/td/div/div/div/div/div/div[3]/div/div[2]/div/div/div[2]/div/div/div/div/ul/li[5]/a/span"));

        WebElement odn = driver.findElement(By.xpath(".//*[@id='main']/div/div/table/tbody/tr/td/div/div/div/div/div/div[3]/div/div[2]/div/div/div[2]/div/div/div/div/ul/li[6]/a/span"));

        Assert.assertTrue(fb.isEnabled());

        Assert.assertTrue(tw.isEnabled());

        Assert.assertTrue(yt.isEnabled());

        Assert.assertTrue(inst.isEnabled());

        Assert.assertTrue(vk.isEnabled());

        Assert.assertTrue(odn.isEnabled());





    }
}
