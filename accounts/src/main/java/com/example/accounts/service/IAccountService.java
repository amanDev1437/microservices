package com.example.accounts.service;

import com.example.accounts.dto.CustomerDto;

public interface IAccountService {

    /**
     * @param customerDto
     */
    void createAccount(CustomerDto customerDto);

    CustomerDto fetchAccount(String mobileNumber);

    boolean updateAccount(CustomerDto customerDto);

    boolean deleteAccount(String mobileNumber);
}