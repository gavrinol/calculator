package service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.calculator.service.CalculatorService;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ParameterizedCalculatorServiceTest {
    private final CalculatorService calculatorService = new CalculatorService();

    @ParameterizedTest
    @MethodSource("paramsForPlus")
    public void plusTest(float a,
                         float b,
                         float result){
        assertThat(calculatorService.plus(a, b)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("paramsForMinus")
    public void minusTest(float a,
                         float b,
                         float result){
        assertThat(calculatorService.minus(a, b)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("paramsForMultiply")
    public void multiplyTest(float a,
                         float b,
                         float result){
        assertThat(calculatorService.multiply(a, b)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("paramsForDivide")
    public void divideTest(float a,
                         float b,
                         float result){
        assertThat(calculatorService.divide(a, b)).isEqualTo(result);
    }

    public static Stream<Arguments> paramsForPlus(){
        return Stream.of(
        Arguments.of(3.0f, 5.0f ,8.0f),
        Arguments.of(4.0f, 2.0f, 6.0f)
        );
    }

    public static Stream<Arguments> paramsForMinus(){
        return Stream.of(
                Arguments.of(3.0f, 5.0f ,-2.0f),
                Arguments.of(4.0f, 2.0f, 2.0f)
        );
    }

    public static Stream<Arguments> paramsForMultiply(){
        return Stream.of(
                Arguments.of(3.0f, 5.0f ,15.0f),
                Arguments.of(4.0f, 2.0f, 8.0f)
        );
    }

    public static Stream<Arguments> paramsForDivide(){
        return Stream.of(
                Arguments.of(5.0f, 5.0f ,1.0f),
                Arguments.of(4.0f, 2.0f, 2.0f)
        );
    }
}
