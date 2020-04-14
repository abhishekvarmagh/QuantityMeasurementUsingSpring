package com.bridgelabz.quantitymeasurement.dto;


import com.bridgelabz.quantitymeasurement.enumeration.UnitType;

public class QuantityMeasurementDTO {

    UnitType unitTypeOne;
    UnitType unitTypeTwo;
    double actualValue;
    double convertedValue;

    public void setConvertedValue(double convertedValue) {
        this.convertedValue = convertedValue;
    }

    public UnitType getUnitTypeOne() {
        return unitTypeOne;
    }

    public UnitType getUnitTypeTwo() {
        return unitTypeTwo;
    }

    public double getActualValue() {
        return actualValue;
    }

    public double getConvertedValue() {
        return convertedValue;
    }
}
