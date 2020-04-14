package com.bridgelabz.quantitymeasurement.controller;

import com.bridgelabz.quantitymeasurement.enumeration.Unit;
import com.bridgelabz.quantitymeasurement.service.implementation.IQuantityMeasurementService;
import com.bridgelabz.quantitymeasurement.service.implementation.QuantityMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuantityMeasurementController {

    @Autowired
    IQuantityMeasurementService quantityMeasurementService;

    @GetMapping("/units")
    public List<Unit> getUnits() {
        return quantityMeasurementService.getUnits();
    }

}
