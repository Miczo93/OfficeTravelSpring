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

    @GetMapping("/addSimpleData")
    public void addSimpleData() {
        newOffice.addCustomer("Duprim", new AbroadTrip(new MyDate(19, 11, 2019), new MyDate(19, 12, 2019), "Brooklyn"), new Address("Gangsta", "89-969", "Metropolice"));
        newOffice.addCustomer("Larry", new DomesticTrip(new MyDate(19, 7, 2019), new MyDate(15, 12, 2019), "Norwegia"), new Address("Norweska", "66-661", "Metropolice"));
        newOffice.addCustomer("Crowbar Gary", new Trip(new MyDate(9, 12, 2019), new MyDate(29, 12, 2019), "Metropolice"), new Address("Gangsta", "99-999", "Siłownice"));
        newOffice.getCustomersList().get(TravelOffice.getCustomerCount() - 2).getTrip().setPrice(5000);
        newOffice.getCustomersList().get(TravelOffice.getCustomerCount() - 1).getTrip().setPrice(5000);
        newOffice.getCustomersList().get(TravelOffice.getCustomerCount()).getTrip().setPrice(5000);
    }

    @GetMapping("/displayData")
    public String displayData() {
        StringBuilder sb = new StringBuilder();
        for (Customer c : newOffice.getCustomersList().values()) {
            if (c.getTrip() instanceof AbroadTrip) {
                ((AbroadTrip) c.getTrip()).setInsurance(200);
            } else if (c.getTrip() instanceof DomesticTrip) {
                ((DomesticTrip) c.getTrip()).setOwnArrivalDiscount(50);
            }
            sb.append(c.toString()).append("\n");
        }
        return sb.toString();
    }

    @PostMapping("/addCustomCustomer")
    public void addCustomCustomer(@RequestBody Customer customer) {
        newOffice.addCustomer(customer);
    }

    @PostMapping("/addCustomCustomerWithReturn")
    public Customer addCustomCustomerWithReturn(@RequestBody Customer customer) {
        newOffice.addCustomer(customer);
        return newOffice.getCustomersList().get(TravelOffice.getCustomerCount());
    }

    @GetMapping("/displayDataJSON")
    public Map<Long, Customer> displayDataJSON() {
        return newOffice.getCustomersList();
    }

    @GetMapping("/throwExceptionForDebug")
    public void throwExceptionForDebug(){
        new ExceptionTesting().functionForException();
    }

}
