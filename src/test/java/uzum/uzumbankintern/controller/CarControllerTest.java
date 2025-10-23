package uzum.uzumbankintern.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import uzum.uzumbankintern.dto.CarDto;
import uzum.uzumbankintern.service.CarService;

import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;

//@WebMvcTest(controllers = CarController.class)
//@AutoConfigureMockMvc(addFilters = false)
//class CarControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//    @MockitoBean
//    private CarService carService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    void addCar() throws Exception {
//        given(carService.addCar(ArgumentMatchers.any()))
//                .willAnswer(invocation -> invocation.getArgument(0));
//
//        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/car")
//                        .contentType(APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(
//                                new CarDto(
//                                        "Chevrolet-Damas1", 10, 22L
//                                )
//                        ))
//        );
//        response.andExpect(MockMvcResultMatchers.status().isCreated());
//    }
//}
