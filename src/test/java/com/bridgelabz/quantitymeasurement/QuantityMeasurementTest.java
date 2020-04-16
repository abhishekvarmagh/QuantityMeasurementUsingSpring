package com.bridgelabz.quantitymeasurement;

import com.bridgelabz.quantitymeasurement.controller.QuantityMeasurementController;
import com.bridgelabz.quantitymeasurement.dto.QuantityMeasurementDTO;
import com.bridgelabz.quantitymeasurement.dto.ResponseDTO;
import com.bridgelabz.quantitymeasurement.enumeration.Unit;
import com.bridgelabz.quantitymeasurement.enumeration.UnitType;
import com.bridgelabz.quantitymeasurement.service.IQuantityMeasurementService;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


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
        mockMvc.perform(MockMvcRequestBuilders.get("/units"))
                .andDo(print())
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

    @Test
    void givenDTO_ShouldReturnConvertedValue() throws Exception {
        QuantityMeasurementDTO quantityMeasurementDTO = new QuantityMeasurementDTO();
        quantityMeasurementDTO.setUnitTypeOne(UnitType.YARD);
        quantityMeasurementDTO.setUnitTypeTwo(UnitType.FEET);
        quantityMeasurementDTO.setActualValue(1.0);
        Gson gson = new Gson();
        String jsonBody = gson.toJson(quantityMeasurementDTO);
        given(quantityMeasurementService.getConvertedValue(any())).willReturn(3.0);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/unittype/conversion")
                .contentType(MediaType.APPLICATION_JSON).content(jsonBody))
                .andReturn();
        String response = mvcResult.getResponse().getContentAsString();
        ResponseDTO responseDTO = gson.fromJson(response, ResponseDTO.class);
        double actualConvertedValue = (double) responseDTO.getValue();
        Assert.assertEquals(3.0, actualConvertedValue, 0.0);
    }
}
