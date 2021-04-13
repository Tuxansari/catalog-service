package com.tripaneer.catalog.controller;

import com.cedarsoftware.util.DeepEquals;
import com.google.gson.Gson;
import com.tripaneer.catalog.response.BaseResponse;
import com.tripaneer.catalog.response.DestinationResponse;
import com.tripaneer.catalog.service.DestinationService;
import org.jeasy.random.EasyRandom;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.net.SocketTimeoutException;

import static com.tripaneer.catalog.constants.CatalogServiceDefaultExceptionCodes.INTERNAL_SERVER;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@AutoConfigureDataMongo
@WebMvcTest(DestinationController.class)
public class DestinationControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    DestinationService mockedDestinationService;

    @Test
    public void testGetDestinationSuccess() throws Exception {
        EasyRandom easyRandom = new EasyRandom();
        DestinationResponse mockedResponse = easyRandom.nextObject(DestinationResponse.class);

        Mockito.when(mockedDestinationService.getDestination("123"))
                .thenReturn(mockedResponse);

        MvcResult result = mvc.perform( MockMvcRequestBuilders
                .get("/destination/123")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String responseStr = result.getResponse().getContentAsString();
        DestinationResponse apiResponse
                = new Gson().fromJson(responseStr, DestinationResponse.class);
        Assert.assertTrue(DeepEquals.deepEquals(mockedResponse, apiResponse));
    }

}
