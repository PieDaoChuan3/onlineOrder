package com.example.onlineorder.service;

import com.example.onlineorder.dao.CustomerDao;
import com.example.onlineorder.entity.Cart;
import com.example.onlineorder.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void signUp(Customer customer) {
        Cart cart = new Cart();
        customer.setCart(cart);
        customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
        customer.setEnabled(true);
        customerDao.signUp(customer);
    }

    public Customer getCustomer(String email) {
        return customerDao.getCustomer(email);
    }

}

