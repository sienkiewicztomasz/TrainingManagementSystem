package pl.sda.trainingmanagementsystem.service;

import pl.sda.trainingmanagementsystem.domain.Customer;

import java.util.List;
//opis interfejsu, do czego służy
public interface CustomerService {

    List<Customer> listAllCustomers();

    Customer getById(Integer id);

    Customer save(Customer customer);

    void activateCustomer(Boolean active);

    void delete(Integer id);
}