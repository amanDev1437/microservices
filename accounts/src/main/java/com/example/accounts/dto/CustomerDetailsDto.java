package com.example.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "CustomerDetails",
        description = "Schema to hold Customer,Account, Cards and Loans information"
)
public class CustomerDetailsDto {
    @NotEmpty(message = "Name can not be null or empty")
    @Size(min = 5, max = 30, message = "The length of customer name should be between 5 and 30")
    private  String name;

    @NotEmpty(message = "Email address can not be null or empty")
    @Email(message = "Email address should be a valid value")
    private  String email;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digit")
    private  String mobileNumber;

    private AccountDto accountDto;

    private CardsDto cardsDto;

    private LoansDto loansDto;

}
