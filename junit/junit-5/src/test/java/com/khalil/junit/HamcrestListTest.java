package com.khalil.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HamcrestListTest {

    private List<String> values;

    @BeforeEach
    public void setUp() {
        values = new ArrayList<>();
        values.add("John");
        values.add("Michael");
        values.add("Edwin");
    }

    @Test
    @DisplayName("List without Hamcrest will intentionally fail to show how failing information is displayed")
    public void testListWithoutHamcrest() {
        assertEquals(3, values.size());
        assertTrue(values.contains("Oliver") || values.contains("Jack") || values.contains("Harry"));
    }
}