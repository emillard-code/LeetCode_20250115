package com.project;

import com.project.solution.LeetCodeSolution;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class LeetCodeSolutionTest {

    @Test
    public void minimizeXORTest() {

        assertEquals(3, LeetCodeSolution.minimizeXor(3, 5));
        assertEquals(3, LeetCodeSolution.minimizeXor(1, 12));

    }

}
