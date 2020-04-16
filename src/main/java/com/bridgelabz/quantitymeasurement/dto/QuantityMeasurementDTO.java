package com.bridgelabz.quantitymeasurement.dto;


import com.bridgelabz.quantitymeasurement.enumeration.UnitType;

public class QuantityMeasurementDTO {

    UnitType unitTypeOne;
    UnitType unitTypeTwo;
    double actualValue;

    public void setUnitTypeOne(UnitType unitTypeOne) {
        this.unitTypeOne = unitTypeOne;
    }

    public void setUnitTypeTwo(UnitType unitTypeTwo) {
        this.unitTypeTwo = unitTypeTwo;
    }

    public void setActualValue(double actualValue) {
        this.actualValue = actualValue;
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

}
