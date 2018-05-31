package ruk.paul.testRest.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ruk.paul.testRest.domain.model.Appliance;
import ruk.paul.testRest.service.ApplianceService;
import ruk.paul.testRest.web.dto.ApplianceDto;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by paul on 30.05.18.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ApplianceController.class)
public class ApplianceControllerTest extends TestCase {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ApplianceService applianceService;

    private static Integer sharedID;

    @Test
    public void testCreate() throws Exception {

        ApplianceDto applianceDto = new ApplianceDto("TEST10001", "TT", "TS");

        given(applianceService.create(applianceDto)).willReturn(1);
        mockMvc.perform(post("/appliance/")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(asJsonString(applianceDto)))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf("1")));
    }

    @Test
    public void testGet() throws Exception {
        Appliance appliance = new Appliance();
        appliance.setItem("TEST10001");
        appliance.setType("TT");
        appliance.setState("TS");

        given(applianceService.findById(1)).willReturn(appliance);
        mockMvc.perform(get("/appliance/1")
                            .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));

    }

    /*
     * converts a Java object into JSON representation
     */
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
