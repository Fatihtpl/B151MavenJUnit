package techproed.day23_Log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

public class C02_Log4j extends TestBase {
    @Test
    public void test01() {
        Logger logger = LogManager.getLogger(C02_Log4j.class);
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        logger.info("Techpro sayfasına gidildi");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        logger.info("Sayfada çıkan reklam kapatıldı");

        //Baslığın Egitim içerdigine dogrulayalım
        Assert.assertFalse(driver.getTitle().contains("Egitim"));
        logger.error("Sayfa baslığı Egitim yazisi icermiyor");
    }
}
