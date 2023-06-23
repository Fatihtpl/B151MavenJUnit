package techproed.day18_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import techproed.utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_TumSayfaResmi extends TestBase {
    /*
  SCREENSHOT
      Selenium'da tüm ekran görüntüsünü alabilmek için TakesScreenShot arayünden bir obje oluşturup
  driver'a eşitleriz. Arayüzler farklı olduğu için casting yaparız. Ve bu oluşturduğumuz obje ile
  getScreenshotAs methodu ile sayfanın resmini alırız. Almış olduğumuz resmi projemizde nereye kaydedeceksek
  oranın yolunu belirtiriz.
   */
    @Test
    public void test01() throws IOException {
        //Techproeducation sayfasina gidelim.
        driver.get("https://techproeducation.com");
        bekle(2);
        //Cikan reklami kapatalim.
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        //ve ekran goruntusu alalim.
        /* ADIMLAR
        1-Ilk olarak ss aldigimizda nereye kaydetmek istiyorsak oranin yolunu belirtelim.
        2-ikinci olarak TakesScreeenShot arayuzunden obje olustururuz.
        3-ucuncu olarak FileUtils classindan copyFile methodu ile ts objemizi kullanarak getScreenShotAs methodu ile dosya yolunu belirtecegiz.
         */
        String dosyaYolu = "src/test/java/techproed/TumSayfaResmi/screenShot.png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        }



        @Test
        public void test02() throws IOException {
            //Techproeducation sayfasına gidelim
            driver.get("https://techproeducation.com");

            bekle(2);
            //Çıkan reklamı kapatalım
            driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

            //Ve ekran görüntüsünü alalım
            TakesScreenshot ts = (TakesScreenshot) driver;
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("ScreenShot/screenShot.png"));

        }

    @Test
    public void test03() throws IOException {
        /*

        Kaydettigimiz ekran resmi her seferinde ayni dosya uzerine yazmamasi icin dosya isminden sonra String bir
        degiskene tarih formati atayabiliriz.

         */
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        bekle(2);
        //Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //Ve ekran görüntüsünü alalım
        //SimpleDateFormat' io kullanarak yeni bir tarih formati olusturup bir String'e assing ederiz.
        //ve bunu dosya isminden once belirtiriz.
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/techproed/TumSayfaResmi/screenShot" + tarih +".jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));


    }

    @Test
    public void test04() throws IOException {
        //Techproeducation sayfasına gidelim
        driver.get("https://amazon.com");

        bekle(2);
        //Ve ekran görüntüsünü alalım
        //SimpleDateFormat' io kullanarak yeni bir tarih formati olusturup bir String'e assing ederiz.
        //ve bunu dosya isminden once belirtiriz.
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/techproed/TumSayfaResmi/screenShot" + tarih +".jpeg";//driver.getTitle() yaptim amazon yazdi.
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
    }
}
