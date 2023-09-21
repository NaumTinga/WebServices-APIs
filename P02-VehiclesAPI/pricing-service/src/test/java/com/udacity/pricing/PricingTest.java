package com.udacity.pricing;

import com.udacity.pricing.api.PricingController;
import com.udacity.pricing.service.PricingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.net.URI;
import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(PricingController.class)
public class PricingTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    PricingService pricingService;

    @Test
    public void getPriceWithValidId() throws Exception {
        Long validId = 1L;
        mvc.perform(
                get(new URI("/services/price?vehicleId=" + validId))
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
    }


    @Test
    public void getPriceWithInvalidId() throws Exception {
        Long invalidId = 999L;
        mvc.perform(
                get(new URI("/services/price?vehicleId=" + invalidId))
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isNotFound());
    }


}
