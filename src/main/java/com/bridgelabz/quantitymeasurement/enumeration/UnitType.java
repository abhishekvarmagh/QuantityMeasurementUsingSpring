package com.bridgelabz.quantitymeasurement.enumeration;

public enum UnitType {

    FEET(12, Unit.LENGTH), INCH(1, Unit.LENGTH),
    YARD(36, Unit.LENGTH), CM(1 / 2.54, Unit.LENGTH),

    GALLON(3.78, Unit.VOLUME), LITRE(1, Unit.VOLUME),
    ML(1d / 1000, Unit.VOLUME),

    KG(1, Unit.WEIGHT), GRAM(1d / 1000, Unit.WEIGHT),
    TONNE(1000, Unit.WEIGHT),

    CELSIUS(1.8, Unit.TEMPERATURE), FAHRENHEIT(0.555555556, Unit.TEMPERATURE);

    public final double conversionValue;
    public final Unit unit;

    UnitType(double conversionValue, Unit unit) {
        this.conversionValue = conversionValue;
        this.unit = unit;
    }

}
