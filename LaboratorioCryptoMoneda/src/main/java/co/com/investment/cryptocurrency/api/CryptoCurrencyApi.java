package co.com.investment.cryptocurrency.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.com.investment.cryptocurrency.model.CryptoCurrency;
import co.com.investment.cryptocurrency.model.Wallet;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "cryptocurrency", description = "the cryptocurrency API")
@RequestMapping("/cryptocurrency")
public interface CryptoCurrencyApi {

    @ApiOperation(value = "searches an specific cryptocurrency", nickname = "searchCryptoCurrencyBySelf", notes = "By passing in the appropriate options, you can search for available cryptocurrency in the system ", response = CryptoCurrency.class, responseContainer = "CryptoCurrency", tags={ "investor", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "search results matching criteria", response = Wallet.class, responseContainer = "CryptoCurrency"),
        @ApiResponse(code = 400, message = "bad input parameter") })
    @RequestMapping(value = "/{name}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<CryptoCurrency> searchCryptoCurrencyBySelf(@ApiParam(value = "pass a mandatory search name for looking up the cryptocurrency",required=true) @PathVariable("name") String name);
	
	
}
