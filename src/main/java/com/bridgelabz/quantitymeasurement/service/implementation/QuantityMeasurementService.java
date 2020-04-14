package com.bridgelabz.quantitymeasurement.service.implementation;
import com.bridgelabz.quantitymeasurement.enumeration.Unit;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class QuantityMeasurementService implements IQuantityMeasurementService {

    @Override
    public List<Unit> getUnits() {
        return Arrays.asList(Unit.values());
    }

}
