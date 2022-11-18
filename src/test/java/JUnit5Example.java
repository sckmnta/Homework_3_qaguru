import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JUnit5Example {
    @BeforeAll
    static void BeforeAll(){
System.out.println("### BeforeAll() !");
    }
    @AfterAll
    static void AfterAll() {
System.out.println("### AfterAll() !");
    }
    @BeforeEach
    void BeforeEach() {
//        open("google.com")
        System.out.println("### BeforeEach() !");
    }
    @AfterEach
    void AfterEach() {
//        open("google.com")
        System.out.println("### AfterEach() !");
    }
    @Test
    void firstTest() {
        System.out.println("### @Test FirstTest() !");
        assertTrue(3>2);

    }
    @Test
    void secondTest() {
        System.out.println("### @Test SecondTest() !");
        assertFalse(3<2);
    }
}
