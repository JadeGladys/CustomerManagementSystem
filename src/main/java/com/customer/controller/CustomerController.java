package com.customer.controller;

import com.customer.model.Customer;
import com.customer.repository.CustomerRepo;
import com.customer.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    //handle method to handle list of customers

    @GetMapping("/customers")
    public String listCustomers (Model model){
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customers";
    }

    @GetMapping("/customers/add")
    public String createCustomer(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "create_customer";
    }

    @PostMapping("/customers")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/customers/edit/{id}")
    public String editCustomer(@PathVariable int id, Model model){
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "edit_customer";
    }

    @PostMapping("/customers/{id}")
    public String updateCustomer(@PathVariable int id,
                                 @ModelAttribute("customer") Customer customer, Model model){
        //get customer from DB by Id
        Customer existingCustomer = customerService.getCustomerById(id);
        existingCustomer.setId(id);
        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setAge(customer.getAge());

        //save updated customer
        customerService.updateCustomer(existingCustomer);
        return "redirect:/customers";
    }

    //handler method to handle delete request
    @GetMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable int id){
        customerService.deleteCustomerById(id);
        return "redirect:/customers";
    }
}
