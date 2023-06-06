package techproed.day08_BeforeClassAfterClassAssertion;

import org.junit.*;

public class C01_BeforeClassAfterClass {
    /*
    @BeforeClass ve @AfterClass methodlari static olmak zorundadir
     */
  @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Her class'dan sonra BeforeClass Methodu once bir kez calisir");
    }
    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Her class'dan sonra AfterClass Methodu bir kez calisir");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Her method'dan once Before methodu bir kez calisir.");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Her method'dan sonra After methodu calisir.");
    }

    @Test
    public void Test01() {
        System.out.println("Test 01 methodu calisti.");
    }

    @Test
    public void Test02() {
        System.out.println("Test 02 methodu calisti.");
    }

    @Test
    public void Test03() {
        System.out.println("Test 02 methodu calisti.");
    }




}

