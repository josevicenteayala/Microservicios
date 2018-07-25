/**
 * NOTE: This class is auto generated by the swagger code generator program (1.0.14).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package co.com.investment.cryptocurrency.api;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import co.com.investment.cryptocurrency.model.Wallet;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "wallet", description = "the wallet API")
@RequestMapping("/wallet")
public interface WalletApi {

    @ApiOperation(value = "adds a wallet item", nickname = "addWallet", notes = "Adds a wallet to the system", tags={ "investor", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Wallet created"),
        @ApiResponse(code = 400, message = "invalid input, object invalid"),
        @ApiResponse(code = 409, message = "a wallet already exists") })
    @RequestMapping(value = "/addWallet/{idWallet}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> addWallet(@ApiParam(value = "Wallet to add",required=true) @PathVariable("idWallet") String idWallet,@ApiParam(value = "Wallet to create"  )  @Valid @RequestBody Wallet wallet);


    @ApiOperation(value = "searches an specific wallet", nickname = "searchWallet", notes = "By passing in the appropriate options, you can search for available wallet in the system ", response = Wallet.class, responseContainer = "List", tags={ "investor", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "search results matching criteria", response = Wallet.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "bad input parameter") })
    @RequestMapping(value = "/searchWallet/{idWallet}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Wallet>> searchWallet(@ApiParam(value = "pass a mandatory search id for looking up the wallet",required=true) @PathVariable("idWallet") String idWallet,@Min(0)@ApiParam(value = "number of records to skip for pagination") @Valid @RequestParam(value = "skip", required = false) Integer skip,@Min(0) @Max(50) @ApiParam(value = "maximum number of records to return") @Valid @RequestParam(value = "limit", required = false) Integer limit);

}
