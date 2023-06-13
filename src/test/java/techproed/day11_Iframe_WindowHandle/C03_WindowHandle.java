package techproed.day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import techproed.utilities.TestBase;

public class C03_WindowHandle extends TestBase {
    /*
        Eger sayfaya gittikten sonra yeni sekme yada yeni bir pencereyle baska sayfaya gittikten sonra
        tekrar ilk actiginiz sayfaya dnmek isterseniz, ilk sayfaya driver.get() methoduyla gittikten sonra
        String bir degiskene handle degerini assign ederseniz tekrar ilk acilan sayfaya donmek istediginizde
        driver.switchTo().window(ilksayfaHandleDegeri) ile gecis yapabilirsiniz
     */
    @Test
    public void windowHandle() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproHandle = driver.getWindowHandle();

        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String actualTitle = driver.getTitle();
        String expectedTitle = "Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(expectedTitle,actualTitle);

        //Window 2'de https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);     //yeni bir pencereye driveri tasir.
                                    //WindowType.TAB---->yeni bir sekme acar
        driver.get("https://www.youtube.com");
        String youtubeHandle = driver.getWindowHandle();

        //Window 3'te https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedinHandle = driver.getWindowHandle();

        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techproHandle);
        bekle(1);

        //youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeHandle);
        bekle(1);

        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinHandle);
        bekle(1);
    }
}
