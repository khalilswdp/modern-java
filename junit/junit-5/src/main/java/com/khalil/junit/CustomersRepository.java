package com.khalil.junit;

import java.util.ArrayList;
import java.util.List;

class CustomersRepository {
    private List<Customer> customers = new ArrayList<>();

    public boolean contains(String name) {
        return customers.stream().anyMatch(customer -> customer.getName().equals(name));
    }

    public void persist(Customer customer) {
        customers.add(customer);
    }
}