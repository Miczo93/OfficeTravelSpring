package com.example.demo.Repository;

import com.example.demo.Model.Address;
import com.example.demo.Model.Customer;
import com.example.demo.Model.Trip;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.TreeMap;

@Repository
public class TravelOffice {
    static long countOfCustomers = 0;
    private Map<Long, Customer> customersList = new TreeMap<>();

    public Map<Long, Customer> getCustomersList() {
        return customersList;
    }

    public void addCustomer(Customer customer) {
        countOfCustomers++;
        customersList.put(countOfCustomers, customer);
    }

    public void addCustomer(String name, Trip trip, Address address) {
        countOfCustomers++;
        customersList.put(countOfCustomers, new Customer(name));
        customersList.get(countOfCustomers).setTrip(trip);
        customersList.get(countOfCustomers).setAddress(address);
    }

    public static long getCustomerCount() {
        return countOfCustomers;
    }

    @Override
    public String toString() {
        {
            StringBuilder allInfo = new StringBuilder();
            for (Customer c : customersList.values()) {
                allInfo.append(c.toString()).append("\n");
            }
            return allInfo.toString();
        }
    }
}
