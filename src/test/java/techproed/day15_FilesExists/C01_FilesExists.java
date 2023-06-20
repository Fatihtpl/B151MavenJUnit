package techproed.day15_FilesExists;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C01_FilesExists {
    @Test
    public void test01() {
        /*

        Bir web sitesini test ettiğimizde download işlemi yapıldığı zaman dosyanın bilgisayarımıza inip inmediğini
      kontrol etmek varlığını doğrulamak için yada bilgisayarımızdaki herhangi bir dosyanın varlığını doğrulabilmek
      için;
        Files class'ından exists() methodunu kullanarak parametre olarak Paths.get(dosyaYolu) methodunu kullanarak
      dosyanın varlığını test edebiliriz. --> Files.exists(Paths.get(dosyaYolu)
      Dolayısıyla bu işleme başlamadan önce varlığını test edeceğimiz dosyanın yolunu String bir değişkene
      assing ederiz.

         */

        String dosyaYolu = "C:/Users/GÜLŞEN/Desktop/odev.docx";
        System.out.println(Files.exists(Paths.get(dosyaYolu)));//Dosya varsa True yoksa False doner.
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu))); //Dosya varsa True yoksa False doner.
    }

    @Test
    public void test02() {
        String dosyaYolu = "C:/Users/GÜLŞEN/Desktop/sql.docx";
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }

    @Test
    public void test03() throws InterruptedException {
        /*
        Bir server'da farkli isletim sistemleri ile ayni anda dosya varligini test etmek istedigimiz zaman, daha dinamik
   olmasi acisindan System.getProoerty("os.name") bu sekilde isletim sistemini alir
   her isletim sisteminin kullanici yolu farkli olacagindan System.getProoerty("user.home") bilgisayarimizdaki
   kullanici yolunu bu sekilde alip String bir degiskene farkliYol ismi ile System.getProoerty("user.home") atayarak
   her seferinde farkli yollari almayla ugrasmamiz oluruz. Dosya diyelim ki masa ustunde ve her isletim sisteminde
   bize ayni yolu verecegi icin bunu da ortak yol olarak bir String'e assing ederiz
         */
        //-->Dosya yolumuz :"C:/Users/GÜLŞEN/Desktop/odev.docx"
        String farkliYol = "";
        String isletimSistemiAdi = System.getProperty("os.name");//-->İşletim sistemimizin adını verir
        System.out.println(isletimSistemiAdi);
        System.out.println(System.getProperty("user.home"));//-->Bilgisayarımızdaki kullanıcı yolunu verir
        if (isletimSistemiAdi.contains("Win")){
            farkliYol = System.getProperty("user.home");//-->Windows 10/-->C:\Users\GÜLŞEN
        }else if (isletimSistemiAdi.contains("mac")){
            farkliYol = "/Users/aycapolatkamali";//-->Mac işletim sistemi yolu
        }
       String ortakYol = "C:/Users/GÜLŞEN/Desktop/odev.docx";
       String dosyaYolu = farkliYol+ortakYol;
       System.out.println(Files.exists(Paths.get(dosyaYolu)));
       Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
       try {
           Files.delete(Paths.get(dosyaYolu));//-->Bu şekilde belirtmiş olduğumuz dosyayı sileriz
       } catch (IOException e) {
           System.out.println("Dosya bulunamadı");
       }
        Assert.assertFalse(Files.exists(Paths.get(dosyaYolu)));//-->Sildiğimiz için assertFalse kullandık

       Thread.sleep(3000);
       //Sildiğimiz dosya isminde yeni bir dosya oluşturalım
       try {
           Files.createFile(Paths.get(dosyaYolu));//-->Belirtmiş olduğumuz dosyayı oluşturduk
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
       Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
       /*
           Her seferinde test ettiğimiz sayfada download işlemi yapılıyorsa gereksiz dosya kalabalığını önlemek için
       yukardaki delete işlemini kullanabiliriz
        */
    }

   @Test
    public void test04() {
       /*
           Yukarıdaki methodlarda bilgisayarımızdaki dosya yolunun varlığını Files.exists()methoduyla test etmiştik
       Aynı işlemi aşağıdaki örnekteki gibi File class'ından obje oluşturarak da yapabiliriz.
       */
       String dosyaYolu = "C:/Users/GÜLŞEN/Desktop/odev.docx";
       File file = new File(dosyaYolu);
       System.out.println(file.exists());
       Assert.assertTrue(file.exists());
       file.delete();
    }
}

