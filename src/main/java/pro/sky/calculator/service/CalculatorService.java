package pro.sky.calculator.service;

import org.springframework.stereotype.Service;
import pro.sky.calculator.exceptions.DividedByZeroException;

import java.util.DuplicateFormatFlagsException;

@Service
public class CalculatorService {

    public float plus(float a, float b){
        return a + b;
    }
    public float minus(float a, float b){
        return a  - b;
    }
    public float multiply(float a, float b){
        return a * b;
    }

    public float divide(float a, float b){
        if (b == 0){
            throw new DividedByZeroException("Делить на ноль нельзя");
        }
        return a / b;
    }

}
