import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UnitTesting {
    WebDriver driver;
    @BeforeAll
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @DisplayName("View the web title")
    @Test
    public void getWebTitle(){
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        String title_actual = driver.getTitle();
        System.out.println(title_actual);
    }
    @DisplayName("check banner title")
    @Test
    public void getBannerTitle(){
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        boolean isExists = driver.findElement(By.cssSelector("[id = 'block-pagetitle']")).isDisplayed();
        Assertions.assertTrue(isExists);
    }

    @DisplayName("check social sharing block")
    @Test
    public void checkSocialMediaIcon(){
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        boolean isExists = driver.findElement(By.cssSelector("[id ='block-socialsharingblock']")).isDisplayed();
        Assertions.assertTrue(isExists);
    }
    @DisplayName("View menu bar by hovering cursor")
    @Test
    public void menuHover() throws InterruptedException {
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        WebElement menuAbout = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/header[1]/div[1]/div[3]/div[1]/div[1]/nav[1]/div[1]/ul[1]/li[1]/div[1]/span[1]"));
        Actions action = new Actions(driver);
        action.moveToElement(menuAbout).perform();
        WebElement menuProducts = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/header[1]/div[1]/div[3]/div[1]/div[1]/nav[1]/div[1]/ul[1]/li[2]/div[1]/span[1]"));
        action.moveToElement(menuProducts).perform();
        WebElement menuClients = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/header[1]/div[1]/div[3]/div[1]/div[1]/nav[1]/div[1]/ul[1]/li[3]/div[1]/a[1]"));
        action.moveToElement(menuClients).perform();
        WebElement menuResources = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/header[1]/div[1]/div[3]/div[1]/div[1]/nav[1]/div[1]/ul[1]/li[4]/div[1]/span[1]"));
        action.moveToElement(menuResources).perform();
        WebElement menuNews = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/header[1]/div[1]/div[3]/div[1]/div[1]/nav[1]/div[1]/ul[1]/li[5]/div[1]/a[1]"));
        action.moveToElement(menuNews).perform();
        WebElement menuFreeGuides = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/header[1]/div[1]/div[3]/div[1]/div[1]/nav[1]/div[1]/ul[1]/li[6]/div[1]/a[1]"));
        action.moveToElement(menuFreeGuides).perform();
        WebElement menuContacts = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/header[1]/div[1]/div[3]/div[1]/div[1]/nav[1]/div[1]/ul[1]/li[7]/div[1]/a[1]"));
        action.moveToElement(menuContacts).perform();
        Thread.sleep(3000);

    }
    @DisplayName("User should submit the form properly")
    @Test
    public void submitForm() throws InterruptedException {
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        WebElement textName = driver.findElement(By.cssSelector("[id ='edit-name']"));
        textName.sendKeys("H M SHIHAB");
        WebElement textNumber = driver.findElement(By.cssSelector("[id ='edit-number']"));
        textNumber.sendKeys("01869863554");
        WebElement textDate = driver.findElement(By.cssSelector("[id ='edit-date']"));
        textDate.sendKeys("10/10/2023");
        WebElement textEmail = driver.findElement(By.cssSelector("[id ='edit-email']"));
        textEmail.sendKeys("shihab@test.com");
        Utils.scrollDown(driver);
        WebElement textAbout = driver.findElement(By.cssSelector("[id ='edit-tell-us-a-bit-about-yourself-']"));
        textAbout.sendKeys("I am a fresher");
        WebElement uploadFile = driver.findElement(By.id("edit-uploadocument-upload"));
        uploadFile.sendKeys("C:\\Users\\Asus\\Pictures\\Screenshots");
        driver.findElement(By.id("edit-submit")).click();
        driver.get("https://www.digitalunite.com/node/5932/webform/confirmation?token=CjzuixiCPxpZJrxqASwEBu9uVPkcXzFwwISZ0r5jXEU");
        boolean confirm = driver.findElement(By.cssSelector("[class= 'page-title']")).isDisplayed();
        Assertions.assertTrue(confirm);
        Thread.sleep(3000);

    }

    @AfterAll
    public void closeDriver(){
        driver.quit();
    }

}
