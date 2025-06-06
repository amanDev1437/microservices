package com.example.accounts.controller;


import com.example.accounts.constants.AccountConstants;
import com.example.accounts.dto.CustomerDto;
import com.example.accounts.dto.ResponseDto;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AccountController {

    @PostMapping("/create")
   public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto) {
           return ResponseEntity
                   .status(HttpStatus.CREATED)
                   .body(new ResponseDto(AccountConstants.STATUS_201, AccountConstants.MESSAGE_201));

   }
}
