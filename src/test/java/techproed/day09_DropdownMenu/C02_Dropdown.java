package techproed.day09_DropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_Dropdown {
     /*

    DropDown: Alt baslıkların oldugu acılır menu listesidir.

    DropDown 3 adımda handle edilir

    1-) DropDown menusu locate edilmelidir.

    2-) Select objesi olusturulmalıdır
    Select select = new Select(dropdownmenu webelementi)

   3-) Opsiyonlardan bir tanesi secilir
   -selectByVisibleText() ==> ddm deki elemente görünür metin ile ulasmak icin kullanılır
   -selectByIndex() ==> optin'a ındex ile ulasmak icin kullanılır. (index 0 baslar)
   -selectByValue() ==> option'a value ile ulasmak icin kullanılır

   4-)Select class'i sadece <select> tag'i ile olusturulmus dropdown menulere uygulanabilir
   5-)getOprions() -> Locate ettigimiz ddm'deki tum secenekleri bize verir. (List'e atip loop ile yazdirabiliriz)
   6-)getFirstSelectedOption() --> Ddm'deki secili kalan secenegi bize verir. Birden fazla secenek secildigse,
   bu secilenlerin ilkini verir.
   7-)Ddm'ye sendKeys() methodu ile de ddm menudeki seceneklerden birini kullanarak gonderebiliriz.


     */

       //ORNEK :
    /*
        Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
        -3 farklı test methodu oluşturalım
    1.Method:
        a. Yil,ay,gün dropdown menu'leri locate ediniz
        b. Select objesi olustur
        c. Select object i kullaarak 3 farkli sekilde secim yapiniz
    2.Method:
        a. Tüm eyalet isimlerini yazdıralım
    3.Method:
        a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim

 */

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void test01() {
        //1.Method:
        //a. Yil,ay,gün dropdown menu'leri locate ediniz
        WebElement yil = driver.findElement(By.xpath("(//select)[2]"));
        WebElement ay = driver.findElement(By.xpath("(//select)[3]"));
        WebElement gun = driver.findElement(By.xpath("(//select)[4]"));

        //b. Select objesi olustur
        Select select = new Select(yil);
        //c. Select object i kullaarak 3 farkli sekilde secim yapiniz
        select.selectByIndex(5);//index 0'dan başlar 2018'i seçer
        Select select1 = new Select(ay);
        select1.selectByValue("6");//July -> option tag'ındaki value attribute değerini aldık
        Select select2 = new Select(gun);
        select2.selectByVisibleText("15");





    }

    @Test
    public void test02() {
       // a. Tüm eyalet isimlerini yazdıralım
        //1.yol (Selcet ile yaptik)
        WebElement eyaletler = driver.findElement(By.xpath("(//select)[5]"));
        Select select = new Select(eyaletler);
        select.getOptions().forEach(w-> System.out.println(w.getText()));
        System.out.println("**********************************************");
        //2.yol
        List<WebElement> eyaletlerr = driver.findElements(By.xpath("(//select)[5]"));
        eyaletlerr.forEach(w-> System.out.println(w.getText()));
        /* bu sekilde for each ilede yapabililirdik
        3.yol
        for (WebElement w : eyaletler) {
            System.out.println(w.getText());  // Foreach ile de yazdirabiliriz.
        }
        */
    }


    @Test
    public void test03() {
        //a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim.
        WebElement eyaletler = driver.findElement(By.xpath("(//select)[5]"));
        Select select = new Select(eyaletler);
        String seciliOlanSecenek = select.getFirstSelectedOption().getText();
        System.out.println(seciliOlanSecenek);
        Assert.assertEquals("Select a State",seciliOlanSecenek);

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
