package com.bridgelabz.quantitymeasurement.service;

import com.bridgelabz.quantitymeasurement.dto.QuantityMeasurementDTO;
import com.bridgelabz.quantitymeasurement.enumeration.Unit;
import com.bridgelabz.quantitymeasurement.enumeration.UnitType;

import java.util.List;

public interface IQuantityMeasurementService {

    List<Unit> getUnits();
    List<UnitType> getUnitType(Unit unit);

    QuantityMeasurementDTO getDTO(QuantityMeasurementDTO quantityMeasurementDTO);
}
