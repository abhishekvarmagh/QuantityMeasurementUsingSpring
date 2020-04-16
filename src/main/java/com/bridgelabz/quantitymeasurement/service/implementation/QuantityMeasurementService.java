package com.bridgelabz.quantitymeasurement.service.implementation;

import com.bridgelabz.quantitymeasurement.dto.QuantityMeasurementDTO;
import com.bridgelabz.quantitymeasurement.enumeration.Unit;
import com.bridgelabz.quantitymeasurement.enumeration.UnitType;
import com.bridgelabz.quantitymeasurement.service.IQuantityMeasurementService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuantityMeasurementService implements IQuantityMeasurementService {

    @Override
    public List<Unit> getUnits() {
        return Arrays.asList(Unit.values());
    }

    @Override
    public List<UnitType> getUnitType(Unit unit) {
        return Arrays.stream(UnitType.values()).filter(unitType -> unitType.unit.equals(unit)).collect(Collectors.toList());
    }

    @Override
    public double getConvertedValue(QuantityMeasurementDTO quantityMeasurementDTO) {
        if (quantityMeasurementDTO.getUnitTypeOne().unit == Unit.TEMPERATURE && quantityMeasurementDTO.getUnitTypeTwo().unit == Unit.TEMPERATURE)
            return getTemperatureConvertedValue(quantityMeasurementDTO);
        else
            return (quantityMeasurementDTO.getUnitTypeOne().conversionValue * quantityMeasurementDTO.getActualValue()) / quantityMeasurementDTO.getUnitTypeTwo().conversionValue;
    }

    public double getTemperatureConvertedValue(QuantityMeasurementDTO quantityMeasurementDTO) {
        if (quantityMeasurementDTO.getUnitTypeOne() == UnitType.CELSIUS && quantityMeasurementDTO.getUnitTypeTwo() == UnitType.FAHRENHEIT)
            return (quantityMeasurementDTO.getActualValue() * quantityMeasurementDTO.getUnitTypeOne().conversionValue) + 32;
        else
            return (quantityMeasurementDTO.getActualValue() - 32) * quantityMeasurementDTO.getUnitTypeOne().conversionValue;
    }
}
