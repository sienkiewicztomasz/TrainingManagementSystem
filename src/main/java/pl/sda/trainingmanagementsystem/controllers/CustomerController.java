package pl.sda.trainingmanagementsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.sda.trainingmanagementsystem.domain.Customer;
import pl.sda.trainingmanagementsystem.service.CustomerService;

@RequestMapping("/customer")
@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/list")
    public String getCustomers (Model model){
        model.addAttribute("customers", customerService.listAllCustomers());
        return "customers";
    }

    @RequestMapping("/{id}")
    public String getCustomerBy(@PathVariable Integer id, Model model){
        model.addAttribute("customer", customerService.getById(id));
        return "customer";
    }

    @RequestMapping("/delete/{id}")
    public String deleteCustomerBy(@PathVariable Integer id){
        customerService.delete(id);
        return "redirect:/customers";
    }

    @RequestMapping("/edit/{id}")
    public String editCustomer(@PathVariable Integer id, Model model){
        model.addAttribute("customer", customerService.getById(id));
        return "customerForm";
    }

    @RequestMapping("/new")
    public String newCustomer(Model model){
        model.addAttribute("customer", new Customer());
        return "customerForm";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String saveCustomer(Customer customer){
        Customer newOne = customerService.save(customer);
        return "redirect:/customer/" + newOne.getId();
    }

    @RequestMapping("/panel")
    public String customerPanel(){
        return "customerPanel";
    }
}
