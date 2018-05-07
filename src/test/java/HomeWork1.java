import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeWork1 {
    WebDriver driver;

    @FindBy(xpath = ".//a[@data-toggle='dropdown']")
    public WebElement insurance;

    @FindBy(xpath = ".//a[@href='https://www.rgs.ru/products/private_person/health/dms/generalinfo/index.wbp']")
    public WebElement dms;

    @FindBy(xpath = ".//*[@class='page-header']/span")
    public WebElement titleDms;

    @FindBy(xpath = ".//a[contains(text(), 'Отправить заявку')]")
    public WebElement sendApp;

    @FindBy(xpath = "//h4/b")
    public WebElement titleApp;

    @FindBy(name = "LastName")
    public WebElement lastName;

    @FindBy(name = "FirstName")
    public WebElement firstName;

    @FindBy(name = "MiddleName")
    public WebElement middleName;

    @FindBy(name = "Region")
    public WebElement region;

    @FindBy(xpath = ".//label[contains(text(), 'Телефон')]/following-sibling:: input")
    public WebElement phone;

    @FindBy(name = "Email")
    public WebElement email;

    @FindBy(name = "Comment")
    public WebElement comment;

    @FindBy(xpath = ".//label[contains(text(),'Я согласен')]")
    public WebElement agreement;

    @FindBy(xpath = ".//*[@id='button-m']")
    public WebElement button;

    @FindBy(xpath = ".//span[text()='Введите адрес электронной почты']")
    public WebElement errorMessage;


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

    public void waiting(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void select(WebElement element, String value){
        Select selectElement = new Select(element);
        selectElement.selectByValue(value);
    }


    @Test
    public void rgs_test_1() throws InterruptedException{
        PageFactory.initElements(driver, this);

        insurance.click();

        dms.click();

        Assert.assertEquals("Титульник страницы соответстувет выбору в селекте",
                "Добровольное медицинское страхование (ДМС)", titleDms.getText());

        sendApp.click();


        this.waiting(titleApp);

        Assert.assertEquals("Титульник страницы соответстувет выбору в селекте",
                "Заявка на добровольное медицинское страхование", titleApp.getText());


        this.waiting(lastName);

        lastName.sendKeys("Иванов");


        this.waiting(firstName);

        firstName.sendKeys("Иван");


        this.waiting(middleName);

        middleName.sendKeys("Иванович");


        this.select(region, "77");


        this.waiting(phone);

        phone.sendKeys("99999999999");


        this.waiting(email);

        email.sendKeys("qwertyqwerty");


        this.waiting(comment);

        comment.sendKeys("qwertyqwerty");


        this.waiting(agreement);

        agreement.click();


        Assert.assertEquals("Иванов", driver.findElement(By.name("LastName")).getAttribute("value"));

        Assert.assertEquals("Иван", driver.findElement(By.name("FirstName")).getAttribute("value"));

        Assert.assertEquals("Иванович", driver.findElement(By.name("MiddleName")).getAttribute("value"));

        Assert.assertEquals("77", driver.findElement(By.name("Region")).getAttribute("value"));

        Assert.assertEquals("+7 (999) 999-99-99", driver.findElement(By.xpath(".//label[contains(text(), 'Телефон')]/following-sibling:: input")).getAttribute("value"));

        Assert.assertEquals("qwertyqwerty", driver.findElement(By.name("Email")).getAttribute("value"));

        Assert.assertEquals("qwertyqwerty", driver.findElement(By.name("Comment")).getAttribute("value"));


        this.waiting(button);

        button.click();



        this.waiting(errorMessage);

        Assert.assertTrue(errorMessage.isEnabled());



        email.clear();

        email.sendKeys("qwerty@qwerty.ru");


    }


}
