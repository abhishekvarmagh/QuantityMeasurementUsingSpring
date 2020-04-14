package com.bridgelabz.quantitymeasurement;

import com.bridgelabz.quantitymeasurement.controller.QuantityMeasurementController;
import com.bridgelabz.quantitymeasurement.enumeration.Unit;
import com.bridgelabz.quantitymeasurement.enumeration.UnitType;
import com.bridgelabz.quantitymeasurement.service.IQuantityMeasurementService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(QuantityMeasurementController.class)
public class QuantityMeasurementTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IQuantityMeasurementService quantityMeasurementService;


    @Test
    void testUnitList() throws Exception {
        List<Unit> unitList = Arrays.asList(Unit.values());
        given(quantityMeasurementService.getUnits()).willReturn(unitList);
        mockMvc.perform(MockMvcRequestBuilders.get("/units").accept(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(String.valueOf(unitList)));
    }

    @Test
    void givenUnit_ShouldReturnUnitSubType() throws Exception {
        List<UnitType> unitTypeList = Arrays.stream(UnitType.values()).filter(unitType -> unitType.unit.equals(Unit.LENGTH)).collect(Collectors.toList());
        given(quantityMeasurementService.getUnitType(Unit.LENGTH)).willReturn(unitTypeList);
        mockMvc.perform(MockMvcRequestBuilders.get("/units/type?unit={unit}", Unit.LENGTH).accept(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(String.valueOf(unitTypeList)));
    }
}
