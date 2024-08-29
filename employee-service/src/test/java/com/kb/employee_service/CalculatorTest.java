package com.kb.employee_service;

import com.kb.employee_service.utils.Calculator;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    //setup and tear down
    Calculator calculator;

    //the following function will execute before each test
    // aaa pattern -> arrange, act, assert
    // arrange -> setting up the test
    // act -> calling function
    // assert -> checking the result

    //tdd -> test driven development

    @BeforeEach
    public void setup() {
        // arrange
        calculator = new Calculator();
    }

    @Test
    public void multiplyTest() {
        //act
        Integer result = calculator.multiply(20, 10);

        //assert
        assertEquals(200, result);
    }

    @Test
    public void divideTest() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(20, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
