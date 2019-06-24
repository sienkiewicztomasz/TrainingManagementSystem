package pl.sda.trainingmanagementsystem.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.trainingmanagementsystem.domain.Customer;
import pl.sda.trainingmanagementsystem.repo.CustomerRepository;
import pl.sda.trainingmanagementsystem.service.CustomerService;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private CustomerRepository repository;

    public CustomerServiceImpl() {
    }

    @Override
    public List<Customer> listAllCustomers() {
        List<Customer> result = new LinkedList<>();
        repository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public Customer getById(Integer id) {
        Optional<Customer> result = repository.findById(id);
        return result.orElse(new Customer());
    }

    @Override
    public Customer save(Customer customer) {
        if (customer != null) {
//            customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
            return repository.save(customer);
        }else {
            throw new RuntimeException("Nie mogę zapisać użytkownika!!! Wypełnij wszystkie pola!!!");
        }

    }

    @Override
    public void activateCustomer(Boolean active) {

    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
