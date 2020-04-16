package com.bridgelabz.quantitymeasurement.controller;

import com.bridgelabz.quantitymeasurement.dto.QuantityMeasurementDTO;
import com.bridgelabz.quantitymeasurement.dto.ResponseDTO;
import com.bridgelabz.quantitymeasurement.enumeration.Unit;
import com.bridgelabz.quantitymeasurement.enumeration.UnitType;
import com.bridgelabz.quantitymeasurement.service.IQuantityMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class QuantityMeasurementController {

    @Autowired
    IQuantityMeasurementService quantityMeasurementService;

    @GetMapping("/units")
    public ResponseEntity<List<Unit>> getUnits() {
        return new ResponseEntity<>(quantityMeasurementService.getUnits(), HttpStatus.OK);
    }

    @GetMapping("/units/type")
    public ResponseEntity<List<UnitType>> getUnitType(@RequestParam(value = "unit") Unit unit) {
        return new ResponseEntity<>(quantityMeasurementService.getUnitType(unit), HttpStatus.OK);
    }

    @PostMapping("/unittype/conversion")
    public ResponseEntity<ResponseDTO> getConvertedValue(@RequestBody QuantityMeasurementDTO quantityMeasurementDTO) {
        double convertedValue = quantityMeasurementService.getConvertedValue(quantityMeasurementDTO);
        ResponseDTO responseDTO = new ResponseDTO(convertedValue, "Conversion Successful", 200);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
