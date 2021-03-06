package za.ac.nwu.AccountSystem.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import za.ac.nwu.AccountSystem.domain.dto.AccountTransactionDto;
import za.ac.nwu.AccountSystem.domain.service.GeneralResponse;
import za.ac.nwu.AccountSystem.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.AccountSystem.logic.flow.FetchAccountTransactionFlow;

import java.util.List;

@RestController
@RequestMapping("account-transaction")
public class AccountTransactionController
{

    private CreateAccountTransactionFlow createAccountTransactionFlow;
    private FetchAccountTransactionFlow fetchAccountTransactionFlow;

    public AccountTransactionController(CreateAccountTransactionFlow createAccountTransactionFlow, FetchAccountTransactionFlow fetchAccountTransactionFlow)
    {
        this.createAccountTransactionFlow = createAccountTransactionFlow;
        this.fetchAccountTransactionFlow = fetchAccountTransactionFlow;
    }

    @PostMapping("")
    @ApiOperation(value = "Creating a new Transaction", notes = "Creates a new AccountTransaction that writes to the DB")
    @ApiResponses(value =
            {
            @ApiResponse(code = 200, message = "The AccountTransaction was succesfully created ", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> create(
            @ApiParam(value = "Request body to create a new AccountTransaction", required = true)
            @RequestBody AccountTransactionDto AccountTransaction){

        AccountTransactionDto AccountTransactionResponse = createAccountTransactionFlow.create(AccountTransaction);
        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true,AccountTransactionResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the exsiting Account Transaction.", notes = "Returns a list of account transactions")
    @ApiResponses(value =
            {
            @ApiResponse(code = 200, message = "Existing Account types returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<AccountTransactionDto>>> getAll()
    {
        List<AccountTransactionDto> AccountTransactions = fetchAccountTransactionFlow.getAllAccountTransactions();
        GeneralResponse<List<AccountTransactionDto>> response = new GeneralResponse<>(true, AccountTransactions);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("{transactionId}")
    @ApiOperation(value = "Fetches the specified AccountTransaction using the transactionID", notes = "Gets the AccountTransaction corresponding to the given transactionId")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "AccountTransaction Found through specified transaction IDA"),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> getAccountTransaction(
            @ApiParam(value = "The Account Transaction is uniquely defined through the Transaction ID",
                    example = "1582",
                    name = "transactionId",
                    required = true)
            @PathVariable("transactionId") final Long transactionId)
    {

        AccountTransactionDto AccountTransaction = fetchAccountTransactionFlow.getAccountTransactionById(transactionId);
        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, AccountTransaction);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
