package pro.sky.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.calculator.service.CalculatorService;

import java.util.Objects;

@RequestMapping("calculator")
@RestController
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping()
    public String hello(){
        return "Добро пожаловать в калькулятор";
    }
    @GetMapping("/plus")
    public String plus(@RequestParam(value = "num1", required = false) Float a,
                       @RequestParam(value = "num2", required = false) Float b) {
        if (Objects.isNull(a) || Objects.isNull(b)){
            return "Не все переменные переданы";
        }
            return a + " +  " + b + " = " + calculatorService.plus(a, b);
    }
    @GetMapping("/minus")
    public String minus(@RequestParam(value = "num1", required = false) Float a,
                        @RequestParam(value = "num2", required = false) Float b) {
        if (Objects.isNull(a) || Objects.isNull(b)){
            return "Не все переменные переданы";
        }
        return a + " -  " + b + " = " + calculatorService.minus(a, b);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(value = "num1", required = false) Float a,
                           @RequestParam(value = "num2", required = false) Float b) {
        if (Objects.isNull(a) || Objects.isNull(b)){
            return "Не все переменные переданы";
        }
        return a + " *  " + b + " = " + calculatorService.multiply(a, b);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam(value = "num1", required = false) Float a,
                         @RequestParam(value = "num2", required = false) Float b) {
        if (Objects.isNull(a) || Objects.isNull(b)){
            return "Не все переменные переданы";
        }
        if (b == 0) {
            return "На ноль делить нельзя";
        } else {
            return a + " /  " + b + " = " + calculatorService.divide(a, b);
        }
    }


}
