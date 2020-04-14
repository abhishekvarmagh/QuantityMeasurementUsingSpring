package com.bridgelabz.quantitymeasurement.controller;

import com.bridgelabz.quantitymeasurement.dto.QuantityMeasurementDTO;
import com.bridgelabz.quantitymeasurement.enumeration.Unit;
import com.bridgelabz.quantitymeasurement.enumeration.UnitType;
import com.bridgelabz.quantitymeasurement.service.IQuantityMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuantityMeasurementController {

    @Autowired
    IQuantityMeasurementService quantityMeasurementService;

    @GetMapping("/units")
    public List<Unit> getUnits() {
        return quantityMeasurementService.getUnits();
    }

    @GetMapping("/units/type")
    public List<UnitType> getUnitType(@RequestParam(value = "unit") Unit unit) {
        return quantityMeasurementService.getUnitType(unit);
    }

    @PostMapping("/unittype/conversion")
    public QuantityMeasurementDTO getDTO(@RequestBody QuantityMeasurementDTO quantityMeasurementDTO) {
        return quantityMeasurementService.getDTO(quantityMeasurementDTO);
    }

}
