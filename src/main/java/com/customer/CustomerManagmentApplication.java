package com.customer;

import com.customer.controller.CustomerController;
import com.customer.model.Customer;
import com.customer.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerManagmentApplication  {

	public static void main(String[] args) {
		SpringApplication.run(CustomerManagmentApplication.class, args);
	}

}
