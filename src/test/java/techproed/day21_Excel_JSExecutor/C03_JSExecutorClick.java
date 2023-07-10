package techproed.day21_Excel_JSExecutor;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C03_JSExecutorClick extends TestBase {
    /*
        Bir web sayfasında bazı webelementler oluşturulurken JAVASCRIPT kodlarıyla oluşturulmuş olabilir.
    Bu webelementleri handle edebilmek için JavaScriptExecutor arayüzünü kullanmamız gerekir.
    Bir webelement JavaScript kodları ile yazılmamış olsada javaScriptExecutor ile o webelementi handle edebiliriz.
    Normal bildiğimiz methodlardan daha yavaş çalışacağı için bildiğimiz methodlar işimizi görüyorsa onları kullanırız.
    <script> tagi ile oluşturulmuş olan web elementleri de js executor ile handle edebiliriz.
     */

    @Test
    public void test01() {
        //Amazon sayfasına gidiniz
        driver.get("https://amazon.com");

        bekle(2);
        //sell linkinin resmini alalım
        WebElement sellLinki = driver.findElement(By.xpath("//*[.='Sell']"));
        webElementResmi(sellLinki);

        //Sell linkine js executor kullanarak tıklayınız
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",sellLinki);

        //Başlığın Sell içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("Sell"));

        //Sayfanın resmini alalım
        tumSayfaResmi();
    }

    @Test
    public void test02() {
        //Amazon sayfasına gidiniz
        driver.get("https://amazon.com");

        bekle(2);
        //sell linkinin resmini alalım
        WebElement sellLinki = driver.findElement(By.xpath("//*[.='Sell']"));
        webElementResmi(sellLinki);

        //Sell linkine tıklayınız
        sellLinki.click();
        /*
        JS executor ile Webelementin önünde uyarı çıkmasına rağmen webelemente click yaptı çünkü kodlara direk ulaşıyor
        Normal kullandığımız click methodu burda önünde farklı bir element olduğu için ElementClickInterceptedException:
        hatası verdi.Dolayısıyla bu exception ile karşılaştığımızda da js executor ile bunu çözebiliriz
         */

        //Başlığın Sell içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("Sell"));

        //Sayfanın resmini alalım
        tumSayfaResmi();
    }

    @Test
    public void test03() {
        //Amazon sayfasına gidiniz
        driver.get("https://amazon.com");

        bekle(2);
        //sell linkinin resmini alalım
        //driver.findElement(By.xpath("(//*[@class='a-button-inner'])[1]")).click();//-->uyarı kapatıldı

        WebElement sellLinki = driver.findElement(By.xpath("//*[.='Sell']"));
        bekle(2);
        webElementResmi(sellLinki);

        //Sell linkine js executor kullanarak tıklayınız
        click(sellLinki);//sell linkine tikladigimizda uyari cikiyor dolayisyla sell linkini goremiyor ve tiklayamiyor.bu nedenle js kodlari ile locate aldigimizda bu sorun cozulur.
                         //-->Click methodu olusturduk bu method ile normal click yapmayı denedi fakat olmadı js excutor ile click yaptı
        //Başlığın Sell içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("Sell"));

        //Sayfanın resmini alalım
        tumSayfaResmi();


    }
}
