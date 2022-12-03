package com.krystian;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

import static org.junit.jupiter.api.Assertions.*;

class CaloriesCalculatorTest {

    @Test
    public void shouldReturn70296() throws IOException {
        CaloriesCalculator caloriesCalculator = new CaloriesCalculator();
        assertEquals(70296, caloriesCalculator.getMaximumCalories("C:\\Users\\Krystian\\Desktop\\input.txt"));
    }

    @Test
    public void shouldThrowFileNotFoundException() throws IOException {
        CaloriesCalculator caloriesCalculator = new CaloriesCalculator();
        Assertions.assertThrows(NoSuchFileException.class, () -> {
            caloriesCalculator.getMaximumCalories("C:\\Users\\Krystian\\Desktop\\inpusst.txt");
        });
    }

}