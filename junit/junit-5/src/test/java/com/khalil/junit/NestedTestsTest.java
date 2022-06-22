package com.khalil.junit;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class NestedTestsTest {
    private static final String FIRST_NAME = "John";
    private static final String LAST_NAME = "Smith";

    @Nested
    class BuilderTest {
        private String MIDDLE_NAME = "Michael";

        @Test
        void customerBuilder() throws ParseException {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
            Date customerDate = simpleDateFormat.parse("04-21-2019");

            Customer customer = new Customer.Builder(Gender.MALE, FIRST_NAME, LAST_NAME)
                    .withMiddleName(MIDDLE_NAME)
                    .withBecomeCustomer(customerDate)
                    .build();


            assertAll(() -> {
                assertEquals(Gender.MALE, customer.getGender());
                assertEquals(FIRST_NAME, customer.getFirstName());
                assertEquals(LAST_NAME, customer.getLastName());
                assertEquals(MIDDLE_NAME, customer.getMiddleName());
                assertEquals(customerDate, customer.getBecomeCustomer());
            });
        }
    }

    @Nested
    class CustomerEqualsTest {
        private String OTHER_FIRST_NAME = "John";
        private String OTHER_LAST_NAME = "Doe";

        @Test
        void testDifferentCustomers() {
            Customer customer = new Customer.Builder(Gender.MALE, FIRST_NAME, LAST_NAME)
                    .build();
            Customer otherCustomer = new Customer.Builder(Gender.MALE, OTHER_FIRST_NAME, OTHER_LAST_NAME)
                    .build();
            assertNotEquals(customer, otherCustomer);
        }

        @Test
        void testSameCustomer() {
            Customer customer = new Customer.Builder(Gender.MALE, FIRST_NAME, LAST_NAME)
                    .build();
            Customer otherCustomer = new Customer.Builder(Gender.MALE, FIRST_NAME, LAST_NAME)
                    .build();

            assertAll(() -> {
                assertEquals(customer, otherCustomer);
                assertNotSame(customer, otherCustomer);
            });
        }
    }

    @Nested
    class CustomerHashCodeTest {
        private String OTHER_FIRST_NAME = "John";
        private String OTHER_LAST_NAME = "Doe";

        @Test
        void testDifferentCustomers() {
            Customer customer = new Customer.Builder(Gender.MALE, FIRST_NAME, LAST_NAME)
                    .build();
            Customer otherCustomer = new Customer.Builder(Gender.MALE, OTHER_FIRST_NAME, OTHER_LAST_NAME)
                    .build();
            assertNotEquals(customer.hashCode(), otherCustomer.hashCode());
        }

        @Test
        void testSameCustomer() {
            Customer customer = new Customer.Builder(Gender.MALE, FIRST_NAME, LAST_NAME)
                    .build();
            Customer otherCustomer = new Customer.Builder(Gender.MALE, FIRST_NAME, LAST_NAME)
                    .build();
            assertEquals(customer.hashCode(), otherCustomer.hashCode());
        }
    }
}