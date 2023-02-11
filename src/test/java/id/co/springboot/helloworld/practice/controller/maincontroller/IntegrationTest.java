package id.co.springboot.helloworld.practice.controller.maincontroller;

import id.co.springboot.helloworld.practice.PracticeApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = PracticeApplication.class)
@AutoConfigureMockMvc
//@TestPropertySource(
//        locations = "classpath:application-integrationtest.properties")
public class IntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void helloworld_status200() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/hello-world")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("name", "1234")
                        .param("phone", "1234"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN))
                .andExpect(jsonPath("$", is("Hello 1234")));
    }

    @Test
    public void helloworld_status400() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/hello-world")
                                .contentType(MediaType.APPLICATION_JSON)
                                .param("phone", "1234"))
                .andExpect(status().isBadRequest());

    }
}
