package com.example.demo.Repository;

import com.example.demo.Model.Address;
import com.example.demo.Model.Customer;
import com.example.demo.Model.Trip;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.TreeMap;

@Repository
public class TravelOffice {
    static long count = 0;
    private Map<Long, Customer> customers = new TreeMap<>();

    public Map<Long, Customer> getCustomers() {
        return customers;
    }

    public void AddCustomer(Customer customer) {
        count++;
        customers.put(count, customer);
    }

    public void AddCustomer(String name, Trip trip, Address address) {
        count++;
        customers.put(count, new Customer(name));
        customers.get(count).assignTrip(trip);
        customers.get(count).setAddress(address);
    }

    public static long getCustomerCount() {
        return count;
    }

    @Override
    public String toString() {
        {
            StringBuilder allInfo = new StringBuilder();
            for (Customer c : customers.values()) {
                allInfo.append(c.toString() + "\n");
            }
            return allInfo.toString();
        }
    }
}
