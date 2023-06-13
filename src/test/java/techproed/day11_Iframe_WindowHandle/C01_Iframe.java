package techproed.day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C01_Iframe extends TestBase {
    /*
        Bir HTML dokumanin icine yerlestirilmis baska bir HTML dokumanina inline frame yani IFRAME denir.
    Bi sayfada iframe varsa iframe icindeki webelementi handle edebilmek icin switchTo() methoduyla iframe gecis yapmamiz gerekir.
    Eger gecis yapmazsak nosucheelmentexception aliriz.
        Alert'ten farki alert ciktiginda hicbir webelementi locate edemeyiz.Iframe olsada locate ederiz fakat handle edemeyiz.

     */

    @Test
    public void iframe() {
        //➢    https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");
        //➢    Ana sayfadaki 'An iframe with a thin black border:' metninde 'black border' yazisinin   oldugunu test edelim.
        String metin = driver.findElement(By.xpath("(//p)[1]")).getText();
        System.out.println(metin);
        Assert.assertTrue(metin.contains("black border"));

        //➢    Ayrica 'Applications lists' yazisinin sayfada oldugunu test edelim
        driver.switchTo().frame(0);//gecis yapmazsak NOsucheelmentexception aliriz
        String applicationsLists = driver.findElement(By.xpath("//h1")).getText();
        System.out.println(applicationsLists);
        Assert.assertEquals("Applications lists",applicationsLists);

        //➢    Son olarak sayfadaki iframe yazisinin gorunur oldugunu test ediniz
        driver.switchTo().defaultContent();    // 1.kullanim
        //driver.get(driver.getCurrentUrl());  // 2.kullanim--> Sayfayı yeniledik    //butun kullanimlarda ana sayfaya doneriz.
        //driver.navigate().refresh();         // 3.kullanim
        WebElement iframeYazisi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(iframeYazisi.isDisplayed());
        /*
            Eğer iki tane iframe olsaydı ve 2. frame'e geçmek isteseydik index'i 1 almam gerekicekti
        <body>
	            <iframe id="outerIframe" src="https://www.w3schools.com"> --> driver.switchTo().frame("outerIframe")
		            <iframe id="innerIframe" src="https://www.google.com"></iframe> --> bu örnekte parentFrame ile bir üst frame geçiş yapabiliriz
	            </iframe>
            </body>

          İstersek WebElement frame = driver.findElement(By.xpath("//*[@id='outerIframe'")) bu şekilde locate ettiğimiz
        iframe'e driver.switchTo().frame(frame) geçiş yapabiliriz.
         */

    }
}
