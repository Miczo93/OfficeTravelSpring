package com.example.demo.Controller;

import com.example.demo.Model.Address;
import com.example.demo.Model.Customer;
import com.example.demo.Model.MyDate;
import com.example.demo.Model.Trip;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestTest {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    private Customer getTestCustomer() {
        Customer customer = new Customer();
        customer.setName("Igorrr");
        customer.setAddress(new Address("Gangsta", "89-969", "Metropolice"));
        customer.setTrip(new Trip(
                new MyDate(19, 11, 2019), new MyDate(19, 12, 2019),
                "Brooklyn"));
        return customer;
    }

    private Customer FunctionForTestIfCustomerIsAdded() throws Exception {
        Customer customer = getTestCustomer();
        String postValue = OBJECT_MAPPER.writeValueAsString(customer);
        MvcResult storyResult = mockMvc.perform(MockMvcRequestBuilders
                .post("/AddCustomCustomerWithReturn")
                .contentType(MediaType.APPLICATION_JSON)
                .content(postValue))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        return OBJECT_MAPPER.readValue(storyResult.getResponse().getContentAsString(), Customer.class);
    }

    @Test
    public void SimpleTest() throws Exception {
        mockMvc.perform(get("/Add"))
                .andExpect(status().isOk());
    }

    @Test
    public void TestIfCustomerIsAdded() throws Exception {
        Customer customer = FunctionForTestIfCustomerIsAdded();
        assertNotNull(customer.getTrip().getStart());
        assertEquals(customer.getName(), "Igorrr");
    }
}