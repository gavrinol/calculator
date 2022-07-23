package service;

import org.junit.jupiter.api.Test;
import pro.sky.calculator.exceptions.DividedByZeroException;
import pro.sky.calculator.service.CalculatorService;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    public void plusTest(){
        Number actual  = calculatorService.plus(1,5);
        assertThat(actual).isEqualTo(6.0f);

        actual = calculatorService.plus(-2,6);
        assertThat(actual).isEqualTo(4.0f);
    }

    @Test
    public void minusTest(){
        Number actual = calculatorService.minus(4,2);
        assertThat(actual).isEqualTo(2.0f);

        actual = calculatorService.minus(10, -4);
        assertThat(actual).isEqualTo(14.0f);
    }

    @Test
    public void multipleTest(){
        Number actual = calculatorService.multiply(3,3);
        assertThat(actual).isEqualTo(9.0f);

        actual = calculatorService.multiply(-2, 5);
        assertThat(actual).isEqualTo(-10.0f);
    }

    @Test
    public void divideTest(){
        Number actual = calculatorService.divide(9, 3);
        assertThat(actual).isEqualTo(3.0f);

        actual = calculatorService.divide(5,2);
        assertThat(actual).isEqualTo(2.5f);
    }

    @Test
    public void divideNegativeTest(){
        assertThatExceptionOfType(DividedByZeroException.class)
                .isThrownBy(() -> calculatorService.divide(2,0))
                .withMessage("Делить на ноль нельзя");

        assertThatExceptionOfType(DividedByZeroException.class)
                .isThrownBy(() -> calculatorService.divide(-40,0))
                .withMessage("Делить на ноль нельзя");
    }

}
