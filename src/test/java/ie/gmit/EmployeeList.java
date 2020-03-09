package ie.gmit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

public class EmployeeList {

    @BeforeAll
    static void startTest() {
        System.out.println("Beginning testing");
    }

    @AfterAll
    static void finishTest() {
        System.out.println("Finished testing");
    }

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter) {
        testReporter.publishEntry("Testing " + testInfo.getDisplayName());
        System.out.println();
    }

    @Test
    void testConstructor() {
        Employee passenger = new Employee("Mr", "Sam Feerick", "0123456789", "0852243977", 22);
        assertEquals("Mr", passenger.getTitle());
        assertEquals("Sam Feerick", passenger.getName());
        assertEquals("0123456789", passenger.getId());
        assertEquals("0852243977", passenger.getPhoneNo());
        assertEquals(22, passenger.getAge());
    }

    @Test
    @DisplayName("testTitle - Testing Employee title is valid (must be Mr, Mrs, or Ms)")
    void testTitle() {
        final String error = "Title must be Mr, Mrs, or Ms";
        Exception titleException = assertThrows(IllegalArgumentException.class, ()-> new Employee("", "Sam Feerick", "0123456789", "0852243977", 22));
        assertEquals(error, titleException.getMessage());
    }

    @Test
    @DisplayName("testName - Testing Employee name is valid (must be at least three characters)")
    void testName() {
        final String error = "Name must be at least three characters in length";
        Exception nameException = assertThrows(IllegalArgumentException.class, ()-> new Employee("Mr", "Sa", "0123456789", "0852243977", 22));
        assertEquals(error, nameException.getMessage());
    }

    @Test
    @DisplayName("testID - Testing Employee ID is valid (must be at least ten characters)")
    void testID() {
        final String error = "ID must be at least ten characters in length";
        Exception idException = assertThrows(IllegalArgumentException.class, ()-> new Employee("Mr", "Sam Feerick", "", "0852243977", 22));
        assertEquals(error, idException.getMessage());
    }

    @Test
    @DisplayName("testPhoneNo - Testing Employee phone number is valid (must be at least ten digits)")
    void testPhoneNo() {
        final String error = "Phone number must be at least ten digits in length";
        Exception phoneNoException = assertThrows(IllegalArgumentException.class, ()-> new Employee("Mr", "Sam Feerick", "0123456789", "", 22));
        assertEquals(error, phoneNoException.getMessage());
    }

    @Test
    @DisplayName("testAge - Testing Employee age is valid (must be at older than 16)")
    void testAge() {
        final String error = "You must be older than 16";
        Exception ageException = assertThrows(IllegalArgumentException.class, ()-> new Employee("Mr", "Sam Feerick", "0123456789", "0852243977", 15));
        assertEquals(error, ageException.getMessage());
    }
}

