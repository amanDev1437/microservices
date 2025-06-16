package com.example.accounts.controller;


import com.example.accounts.constants.AccountConstants;
import com.example.accounts.dto.CustomerDto;
import com.example.accounts.dto.ErrorResponseDto;
import com.example.accounts.dto.ResponseDto;
import com.example.accounts.service.IAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "CRUD REST APIs for Accounts in EazyBank",
        description = "CRUD REST APIs in EazyBank to CREATE, UPDATE, FETCH AND DELETE account details"
)
@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class AccountController {

    private IAccountService accountService;

    @Operation(
            summary = "Create account REST API",
            description = "REST API to create new Customer & Account inside EazyBank"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status created"
    )
    @PostMapping("/create")
   public ResponseEntity<ResponseDto> createAccount(@Valid  @RequestBody CustomerDto customerDto) {
        accountService.createAccount(customerDto);
           return ResponseEntity
                   .status(HttpStatus.CREATED)
                   .body(new ResponseDto(AccountConstants.STATUS_201, AccountConstants.MESSAGE_201));

   }

   @Operation(
           summary = "Fetch Account Details REST API",
           description = "REST API to fetch Customer & Account details based on a mobile number"
   )
   @GetMapping("/fetch")
   public ResponseEntity<CustomerDto> fetchAccountDetails(@RequestParam String mobileNumber){
        CustomerDto customerDto = accountService.fetchAccount(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
   }

   @Operation(
           summary = "Update Account Details REST API",
           description = "REST API to update Customer & Account details based on a account number"
   )
   @ApiResponses({
           @ApiResponse(
                   responseCode = "200",
                   description = "HTTP Status OK"
           ),
           @ApiResponse(
                   responseCode = "500",
                   description = "HTTP Internal Server Error",
                   content = @Content(
                           schema = @Schema(implementation = ErrorResponseDto.class)
                   )
           )
   })
   @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccountsDetails( @Valid @RequestBody CustomerDto customerDto){
        boolean isUpdated = accountService.updateAccount(customerDto);

        if(isUpdated){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountConstants.STATUS_200,AccountConstants.MESSAGE_200));

        }else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(AccountConstants.STATUS_500,AccountConstants.MESSAGE_500));
        }
   }

   @DeleteMapping("/delete")
   public ResponseEntity<ResponseDto> deleteAccountDetail(@RequestParam String mobileNumber){
        boolean isDeleted = accountService.deleteAccount(mobileNumber);

        if(isDeleted){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountConstants.STATUS_200,AccountConstants.MESSAGE_200));
        }else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(AccountConstants.STATUS_500,AccountConstants.MESSAGE_500));
        }
   }
}
