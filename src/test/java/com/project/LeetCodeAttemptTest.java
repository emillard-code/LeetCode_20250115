package com.project;

import com.project.attempt.LeetCodeAttempt;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class LeetCodeAttemptTest {

    @Test
    public void minimizeXORTest() {

        assertEquals(3, LeetCodeAttempt.minimizeXOR(3, 5));
        assertEquals(3, LeetCodeAttempt.minimizeXOR(1, 12));

    }

}
