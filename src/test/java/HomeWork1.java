import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeWork1 {
    WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.rgs.ru/");
    }


    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void rgs_test_1() throws InterruptedException{
        WebElement webElement = driver.findElement(By.xpath(".//a[@data-toggle='dropdown']"));
        webElement.click();

        WebElement webElement2 = driver.findElement(By.xpath(".//a[@href='https://www.rgs.ru/products/private_person/health/dms/generalinfo/index.wbp']"));
        webElement2.click();

        WebElement title = driver.findElement(By.xpath(".//*[@class='page-header']/span"));
        Assert.assertEquals("Титульник страницы соответстувет выбору в селекте",
                "Добровольное медицинское страхование (ДМС)", title.getText());

        WebElement webElement3 = driver.findElement(By.xpath(".//*[@id='rgs-main-context-bar']/div/div/div/a[3]"));
        webElement3.click();


        WebDriverWait wait1 = new WebDriverWait(driver, 3);
        wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h4/b"))));
        WebElement title2 = driver.findElement(By.xpath("//h4/b"));

        Assert.assertEquals("Титульник страницы соответстувет выбору в селекте",
                "Заявка на добровольное медицинское страхование", title2.getText());

        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("LastName"))));

        WebElement webElement4 = driver.findElement(By.name("LastName"));

        webElement4.sendKeys("Иванов");


        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@id='applicationForm']/div[2]/div[2]/input"))));

        WebElement webElement5 = driver.findElement(By.xpath(".//*[@id='applicationForm']/div[2]/div[2]/input"));

        webElement5.sendKeys("Иван");


        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@id='applicationForm']/div[2]/div[3]/input"))));

        WebElement webElement6 = driver.findElement(By.xpath(".//*[@id='applicationForm']/div[2]/div[3]/input"));

        webElement6.sendKeys("Иванович");


        WebElement territoryButton = driver.findElement(By.name("Region"));
        Select terriotrySelect = new Select(territoryButton);
        terriotrySelect.selectByValue("77");




        WebElement webElement7 = driver.findElement(By.xpath(".//*[@id='applicationForm']/div[2]/div[5]/input"));

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@id='applicationForm']/div[2]/div[5]/input"))));

        webElement7.sendKeys("9999999999");


        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("Email"))));

        WebElement webElement8 = driver.findElement(By.name("Email"));

        webElement8.sendKeys("qwertyqwerty");







        WebElement webElement9 = driver.findElement(By.xpath(".//*[@id='applicationForm']/div[2]/div[7]/input"));

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@id='applicationForm']/div[2]/div[7]/input"))));

        webElement9.sendKeys("20062018");



        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@id='applicationForm']/div[2]/div[8]/textarea"))));

        WebElement webElement10 = driver.findElement(By.xpath(".//*[@id='applicationForm']/div[2]/div[8]/textarea"));

        webElement10.sendKeys("qwertyqwerty");



        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@id='applicationForm']/div[2]/div[9]/label/label"))));

        WebElement webElement11 = driver.findElement(By.xpath(".//*[@id='applicationForm']/div[2]/div[9]/label/label"));

        webElement11.click();

        Assert.assertEquals("Иванов", driver.findElement(By.name("LastName")).getAttribute("value"));

        Assert.assertEquals("Иван", driver.findElement(By.name("FirstName")).getAttribute("value"));

        Assert.assertEquals("Иванович", driver.findElement(By.name("MiddleName")).getAttribute("value"));

        Assert.assertEquals("77", driver.findElement(By.name("Region")).getAttribute("value"));

        Assert.assertEquals("+7 (999) 999-99-99", driver.findElement(By.xpath(".//*[@id='applicationForm']/div[2]/div[5]/input")).getAttribute("value"));

        Assert.assertEquals("qwertyqwerty", driver.findElement(By.name("Email")).getAttribute("value"));

        Assert.assertEquals("20.06.2018", driver.findElement(By.name("ContactDate")).getAttribute("value"));

        Assert.assertEquals("qwertyqwerty", driver.findElement(By.name("Comment")).getAttribute("value"));


        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@id='applicationForm']/div[2]/div[9]/label/label"))));

        WebElement webElement12 = driver.findElement(By.xpath(".//*[@id='button-m']"));

        webElement12.click();



        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@id='applicationForm']/div[2]/div[6]/div/label/span"))));

        WebElement webElement13 = driver.findElement(By.xpath(".//*[@id='applicationForm']/div[2]/div[6]/div/label/span"));

        Assert.assertTrue(webElement13.isEnabled());



        webElement8.clear();

        webElement8.sendKeys("qwerty@qwerty.ru");


    }


}
