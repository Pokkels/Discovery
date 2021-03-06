package za.ac.nwu.AccountSystem.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import za.ac.nwu.AccountSystem.domain.dto.AccountTypeDto;
import za.ac.nwu.AccountSystem.domain.service.GeneralResponse;
import za.ac.nwu.AccountSystem.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.AccountSystem.logic.flow.FetchAccountTypeFlow;

import java.util.List;

@RestController
@RequestMapping("Account-Type")
public class AccountTypeController
{

    private final FetchAccountTypeFlow fetchAccountTypeFlow;
    private final CreateAccountTypeFlow createAccountTypeFlow;

    @Autowired
    public AccountTypeController(FetchAccountTypeFlow fetchAccountTypeFlow, @Qualifier("createAccountTypeFlowName") CreateAccountTypeFlow createAccountTypeFlow) {
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
        this.createAccountTypeFlow = createAccountTypeFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the exsiting Account Type", notes = "Returns a list of account Types")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The Ping was received and echoed", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<AccountTypeDto>>> getAll()
    {
        List<AccountTypeDto> accountTypes = fetchAccountTypeFlow.getAllAccountTypes();
        GeneralResponse<List<AccountTypeDto>> response = new GeneralResponse<>(true, accountTypes);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Creates a new Account Type.", notes = "Creates a new Account Type that writes to the DB.")
    @ApiResponses(value =
            {
                    @ApiResponse(code = 201, message = "The AccountType was created successfully", response = GeneralResponse.class),
                    @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
                    @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountTypeDto>> create(
            @ApiParam(value = "Request to create a new AccountType.", required = true)
            @RequestBody AccountTypeDto accountType)
    {
        AccountTypeDto accountTypeResponse = createAccountTypeFlow.create(accountType);
        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true,accountTypeResponse);
        return  new ResponseEntity<>(response,HttpStatus.CREATED);
    }


    @GetMapping("{mnemonic}")
    @ApiOperation(value = "Fetches the specified AccountType though the mnemonic", notes = "Fetches the AccountType corresponding to the excisting mnemonic.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Goal Found", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountTypeDto>> getAccountType(
            @ApiParam(value = "The mnemonic that will uniquely identifies the AccountType.",
                    example = "MILES",
                    name = "mnemonic",
                    required = true)
            @PathVariable("mnemonic") final String mnemonic)
    {
        AccountTypeDto accountType = fetchAccountTypeFlow.getAccountTypeByMnemonic(mnemonic);
        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true,accountType);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



}

