package io.cucumber.skeleton.calculator;


import static java.lang.invoke.MethodHandles.lookup;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CalculatorSteps {


    private Calculator calc;

    @Given("a calculator I just turned on")
    public void setup() {
        calc = new Calculator();
    }

    @When("I add {int} and {int}")
    public void add(int arg1, int arg2) {
        System.out.println("Adding "+arg1+" and "+arg2);
        calc.push(arg1);
        calc.push(arg2);
        calc.push("+");

    }

    @When("I substract {int} to {int}")
    public void substract(int arg1, int arg2) {
        System.out.println("Substracting "+arg1+" and "+arg2);
        calc.push(arg1);
        calc.push(arg2);
        calc.push("-");

    }

    @Then("the result is {int}")
    public void the_result_is(double expected) {
        Number value = calc.value();
        System.out.println("Result: "+value+" (expected "+expected+")");
        assertEquals(expected, value);

    }

}
