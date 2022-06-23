package com.khalil.junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssertAllTest {

    SUT systemUnderTest = new SUT("Our system under test");

    @Test
    @DisplayName("SUT should be under current verification")
    void testSystemUnderVerification() {
        systemUnderTest.verify();

        assertAll("SUT should be under current verification",
                () -> assertEquals("Our system under test", systemUnderTest.getSystemName()),
                () -> assertTrue(systemUnderTest.isVerified())
        );

        assertTrue(systemUnderTest.isVerified(),
                () -> "SUT should be under current verification");
    }

    @Test
    @DisplayName("SUT should default to not being under current verification")
    void testSystemNotVerified() {
        assertAll("By default, SUT is not under current verification",
                () -> assertEquals("Our system under test", systemUnderTest.getSystemName()),
                () -> assertFalse(systemUnderTest.isVerified())
        );

        assertFalse(systemUnderTest.isVerified(),
                () -> "By default, SUT is not under current verification");
    }

    @Test
    @DisplayName("SUT should have no current job")
    void testNoJob() {
        assertNull(systemUnderTest.getCurrentJob(),
                () -> "There should be no current job");
    }

}