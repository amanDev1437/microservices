package com.example.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Accounts",
        description = "Schema to hold Account information"
)
public class AccountDto {

    @NotEmpty(message = "AccountNumber can not be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "AccountNumber must be 10 digit")
    private Long accountNumber;

    @NotEmpty(message = "AccountType can not be null or empty")
    private String accountType;

    @NotEmpty(message = "BranchAddress can not be null or empty")
    private String branchAddress;

}
