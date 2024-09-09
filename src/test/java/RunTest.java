import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;

public class RunTest {
    @BeforeAll
    public static void beforeAll(){
        System.out.println("Выполнить до всех");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("Выполнить после всех");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("Выполнить после каждого");
    }

    @Test
    @Tag("Позитивный сценарий")
    @Owner("Никита Савенков")
    public void test1(){
        System.out.println("1");
        String s = "AW";
        Assertions.assertEquals("AW",s);

    }
    @Test
    @Tag("Негативный сценарий")
    @Owner("Никита Савенков")
    public void test2(){
        System.out.println("2");
        String s = "Asad@W";
        Assertions.assertEquals("AW",s);

    }


}
