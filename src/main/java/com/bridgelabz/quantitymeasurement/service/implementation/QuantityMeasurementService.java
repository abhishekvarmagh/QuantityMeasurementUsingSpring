package com.bridgelabz.quantitymeasurement.service.implementation;
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
}
