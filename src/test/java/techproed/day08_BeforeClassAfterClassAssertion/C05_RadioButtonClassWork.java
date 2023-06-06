package techproed.day08_BeforeClassAfterClassAssertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_RadioButtonClassWork {
    /*

      https://www.facebook.com adresine gidin
     -“Crate an Account” button’una basin
     -“raio buttons” elementlerini locate edin
     -Secli degilse cinsiyet butonundan size uygun olani secin

     */
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void radioButton() {
        //https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
        //-“Crate an Account” button’una basin
        driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();
        //-“radio buttons” elementlerini locate edin
        WebElement female = driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        WebElement male = driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        WebElement ozel = driver.findElement(By.xpath("(//input[@type='radio'])[3]"));

        //-Secli degilse cinsiyet butonundan size uygun olani secin
        if (!male.isSelected()) {
            male.click();
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}

