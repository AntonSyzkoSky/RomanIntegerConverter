package com.roman.converter.functional.steps;

import com.roman.converter.functional.state.ScenarioState;
import com.roman.converter.service.RomanIntegerConverterImpl;
import com.roman.converter.validators.ConversionDataValidator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.api.Assertions.assertThat;

public class StepDefinitions {

    private ScenarioState
        scenarioState = new ScenarioState(new RomanIntegerConverterImpl(new ConversionDataValidator()));

    @BeforeEach
    void setUp() {
        scenarioState.setRomanFromInt("");
        scenarioState.setIntFromRoman(0);
        scenarioState.setErrorMessage("");
    }

    @Given("I convert (.+) to integer$")
    public void convertRomanToInteger(String roman) {
        if(roman.equals("empty")){
            roman = "";
        }
        if(roman.equals("null")){
            roman = null;
        }
        try {
            scenarioState.setIntFromRoman( scenarioState.getConverter().convertRomanToInteger(roman));
        }catch (Exception e){
            scenarioState.setErrorMessage(e.getMessage());
        }
    }

    @Given("I convert {int} to roman")
    public void convertIntToRoman(Integer intArg) {
        try {
            scenarioState.setRomanFromInt(scenarioState.getConverter().convertIntegerToRoman(intArg));
        }catch (Exception e){
            scenarioState.setErrorMessage(e.getMessage());
        }
    }

    @Then("I am getting {int} as result")
    public void assertIntResult(Integer convertedInt) {
        assertThat(convertedInt).isEqualTo(scenarioState.getIntFromRoman());
    }

    @Then("I am getting roman number (.+) as result$")
    public void assertRomanNumberResult(String roman) {
        assertThat(roman).isEqualTo(scenarioState.getRomanFromInt());
    }

    @Then("I am getting (.+) error message$")
    public void assertErrorMessage(String error) {
        assertThat(error).isEqualTo(scenarioState.getErrorMessage());
    }
}
