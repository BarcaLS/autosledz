package com.autosledz.backend.controller;

import com.autosledz.backend.domain.GeocodingDto;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringJUnitWebConfig
@WebMvcTest(GeocodingController.class)
public class GeocodingControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GeocodingController geocodingController;

    @Test
    void getGeocoding() throws Exception {
        // Given
        GeocodingDto geocodingDto = new GeocodingDto("Warsaw, PL");
        when(geocodingController.getGeocoding(any(), any())).thenReturn(geocodingDto);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/geocoding/get/50.2323/19.213434")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.display_name", Matchers.is("Warsaw, PL")));
    }
}
