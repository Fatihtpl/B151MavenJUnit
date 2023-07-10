package techproed.day23_Log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class C01_Log4j {
    @Test
    public void log4j() {
        /*
        Log4j system.out.println gibi her test adımında bilgilendirme yapmamıza yarayan bir api'dır
            Log4j ile bu bilgilendirmeleri hem konsolda tarih saat olarak hemde src>main>resources içene
        koyduğumuz log4j.xml file da belirttiğimiz .log uzantılı dosyada yine tarih saat olarak kayıt altına
        almış olacağız.
            Log4j kullanabilmek için öncelikle log4j-api ve log4j-core dependency lerini mvnrepository.com
        adresinden (aynı version numaralarına sahip) alıp pom.xml dosyamıza koymalıyız.
            src>main>resources içene koyduğumuz log4j.xml dosyasındaki kodlara pdf deki adresten ulaşabilirsiniz
         */
        Logger logger = LogManager.getLogger(C01_Log4j.class);
        logger.info("INFO");
        logger.debug("DEBUG");
        logger.error("ERROR");
        logger.fatal("FATAL");
        logger.warn("WARNING");
    }
}