package pl.sda.trainingmanagementsystem.repo;

import org.springframework.data.repository.CrudRepository;
import pl.sda.trainingmanagementsystem.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
