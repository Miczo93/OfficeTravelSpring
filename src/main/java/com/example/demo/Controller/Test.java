package com.example.demo.Controller;

import com.example.demo.Exception.ExceptionTesting;
import com.example.demo.Model.*;
import com.example.demo.Repository.TravelOffice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Test {

    @Autowired
    private TravelOffice newOffice;

    @GetMapping("/AddSimpleData")
    public void AddSimpleData() {
        newOffice.AddCustomer("Duprim", new AbroadTrip(new MyDate(19, 11, 2019), new MyDate(19, 12, 2019), "Brooklyn"), new Address("Gangsta", "89-969", "Metropolice"));
        newOffice.AddCustomer("Larry", new DomesticTrip(new MyDate(19, 7, 2019), new MyDate(15, 12, 2019), "Norwegia"), new Address("Norweska", "66-661", "Metropolice"));
        newOffice.AddCustomer("Crowbar Gary", new Trip(new MyDate(9, 12, 2019), new MyDate(29, 12, 2019), "Metropolice"), new Address("Gangsta", "99-999", "Siłownice"));
        newOffice.getCustomers().get(newOffice.getCustomerCount() - 2).getTrip().setPrice(5000);
        newOffice.getCustomers().get(newOffice.getCustomerCount() - 1).getTrip().setPrice(5000);
        newOffice.getCustomers().get(newOffice.getCustomerCount()).getTrip().setPrice(5000);
    }

    @GetMapping("/DisplayData")
    public String DisplayData() {
        StringBuilder sb = new StringBuilder();
        for (Customer c : newOffice.getCustomers().values()) {
            if (c.getTrip() instanceof AbroadTrip) {
                ((AbroadTrip) c.getTrip()).setInsurance(200);
            } else if (c.getTrip() instanceof DomesticTrip) {
                ((DomesticTrip) c.getTrip()).setOwnArrivalDiscount(50);
            }
            sb.append(c.toString() + "\n");
        }
        return sb.toString();
    }

    @PostMapping("/AddCustomCustomer")
    public void AddCustomCustomer(@RequestBody Customer customer) {
        newOffice.AddCustomer(customer);
    }

    @PostMapping("/AddCustomCustomerWithReturn")
    public Customer AddCustomCustomerWithReturn(@RequestBody Customer customer) {
        newOffice.AddCustomer(customer);
        return newOffice.getCustomers().get(newOffice.getCustomerCount());
    }

    @GetMapping("/DisplayDataJSON")
    public Map<Long, Customer> DisplayDataJSON() {
        return newOffice.getCustomers();
    }

    @GetMapping("/ThrowExceptionForDebug")
    public void ThrowExceptionForDebug(){
        new ExceptionTesting().FunctionForException();
    }

}
