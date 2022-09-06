package com.khalil.junit.assumptions;

import com.khalil.junit.lifecycle.ResourceForAllTests;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class JUnit5SUTTest {
    private static ResourceForAllTests resourceForAllTests;
    private SUT systemUnderTest;

    @BeforeAll
    static void setUpClass() {
        resourceForAllTests = new ResourceForAllTests("Our resource for all tests");
    }

    @AfterAll
    public static void tearDownClass() {
        resourceForAllTests.close();
    }

    @BeforeEach
    public void setUp() {
        systemUnderTest = new SUT("Our system under test");
    }

    @AfterEach
    public void tearDown() {
        systemUnderTest.close();
    }

    @Test
    public void testRegularWork() {
        boolean canReceiveRegularWork = systemUnderTest.canReceiveRegularWork();
        assertTrue(canReceiveRegularWork);
    }

    @Test
    public void testAdditionalWork() {
        boolean canReceiveAdditionalWork = systemUnderTest.canReceiveAdditionalWork();
        assertFalse(canReceiveAdditionalWork);
    }

    @Test
    @Disabled
    public void myThirdTest() {
        assertEquals(2, 1, "2 is not equal to 1");
    }
}
