package techproed.day10_TestBase_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C02_Alerts extends TestBase {
    /*
           Eger bir sayfada ki bir butona tikladigimizda bir uyari penceresi cikiyorsa ve bu cikan pencereye sag click yapip locate alamiyorsak
        bu bir javascript alertdir.
           js alert'u handle edebilmek icin driverinizi o pencereye gecirmeniz gerekir.Bunun icin driver objemizi kullanrak switchTo() methodu ile alert
        methodu kullanarak js alert'e gecis yapmis oluruz.
           accept() yada dismiss() methodlari ile js java script allert'u onaylar yada iptal ederek kapatiriz.
         */

    //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
    //Bir metod olusturun: acceptAlert
    //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
    //Bir metod olusturun: dismissAlert
    //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    //“successfuly” icermedigini test edin.
    //Bir metod olusturun: sendKeysAlert
    //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
    //--> Çalışmasını istemediğimiz test notasyonundan sonra (@Test) @Ignore notasyonu kullanırız

    @Test
    public void acceptAlert() {
        //Bir metod olusturun: acceptAlert
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("(//button)[1]")).click();
        bekle(3);
        driver.switchTo().//gecmek icin kullanilir
                alert().  //alert'e geçiş yapar
                accept();  //çıkan alert'te ok yada tamam butonuna tıklar
        bekle(2);
        WebElement resultMassage = driver.findElement(By.xpath("(//p)[2]"));
        String istenenYazi = "You successfully clicked an alert";
        Assert.assertEquals(istenenYazi,resultMassage.getText());
        bekle(2);

    }

    @Test
    public void dismissAlert() {
        //Bir metod olusturun: dismissAlert
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının “successfuly” icermedigini test edin.
        driver.findElement(By.xpath("(//button)[2]")).click();
        bekle(3);
        driver.switchTo().alert().dismiss();
        bekle(2);
        WebElement resultMassage = driver.findElement(By.xpath("(//p)[2]"));
        String istenenMetin = "successfuly";
        Assert.assertFalse(resultMassage.getText().contains(istenenMetin));
        bekle(2);


    }

    @Test
    public void sendKeysAlert() {
        //Bir metod olusturun: sendKeysAlert
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("(//button)[3]")).click();
        bekle(2);
        driver.switchTo().alert().sendKeys("Fatih");
        driver.switchTo().alert().accept();
        bekle(3);

        WebElement resultMassage = driver.findElement(By.xpath("(//p)[2]"));
        Assert.assertTrue(resultMassage.getText().contains("Fatih"));
        bekle(3);



    }
}
