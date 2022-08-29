package com.roman.converter.functional.state;

import com.roman.converter.service.RomanIntegerConverter;

public class ScenarioState {

    private RomanIntegerConverter converter;
    private  int intFromRoman ;
    private  String romanFromInt ;
    private String errorMessage;

    public ScenarioState(RomanIntegerConverter converter) {
        this.converter = converter;
    }

    public RomanIntegerConverter getConverter() {
        return converter;
    }

    public int getIntFromRoman() {
        return intFromRoman;
    }

    public void setIntFromRoman(int intFromRoman) {
        this.intFromRoman = intFromRoman;
    }

    public String getRomanFromInt() {
        return romanFromInt;
    }

    public void setRomanFromInt(String romanFromInt) {
        this.romanFromInt = romanFromInt;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
