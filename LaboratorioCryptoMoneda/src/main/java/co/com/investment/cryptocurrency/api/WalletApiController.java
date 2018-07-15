package co.com.investment.cryptocurrency.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.investment.cryptocurrency.model.Wallet;
import io.swagger.annotations.ApiParam;

@Controller
public class WalletApiController implements WalletApi {

    private static final Logger log = LoggerFactory.getLogger(WalletApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public WalletApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addWallet(@ApiParam(value = "Wallet to add",required=true) @PathVariable("idWallet") String idWallet,@ApiParam(value = "Wallet to create"  )  @Valid @RequestBody Wallet wallet) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Wallet>> searchWallet(@ApiParam(value = "pass a mandatory search id for looking up the wallet",required=true) @PathVariable("idWallet") String idWallet,@Min(0)@ApiParam(value = "number of records to skip for pagination") @Valid @RequestParam(value = "skip", required = false) Integer skip,@Min(0) @Max(50) @ApiParam(value = "maximum number of records to return") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Wallet>>(objectMapper.readValue("[ {  \"owner\" : \"Boundary Limit Investor\",  \"privateKey\" : \"12346W4646eqweeeeee3wqew7898665\",  \"idWallet\" : \"we459893r66asd65srsd65sdrser65fdds\",  \"currencyInvestment\" : [ {    \"ammountOfCryptoCurrency\" : 2.8,    \"cryptoCurrency\" : {      \"name\" : \"Bitcoin\",      \"valueInDollar\" : 25.0    }  }, {    \"ammountOfCryptoCurrency\" : 2.8,    \"cryptoCurrency\" : {      \"name\" : \"Bitcoin\",      \"valueInDollar\" : 25.0    }  } ]}, {  \"owner\" : \"Boundary Limit Investor\",  \"privateKey\" : \"12346W4646eqweeeeee3wqew7898665\",  \"idWallet\" : \"we459893r66asd65srsd65sdrser65fdds\",  \"currencyInvestment\" : [ {    \"ammountOfCryptoCurrency\" : 2.8,    \"cryptoCurrency\" : {      \"name\" : \"Bitcoin\",      \"valueInDollar\" : 25.0    }  }, {    \"ammountOfCryptoCurrency\" : 2.8,    \"cryptoCurrency\" : {      \"name\" : \"Bitcoin\",      \"valueInDollar\" : 25.0    }  } ]} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Wallet>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Wallet>>(HttpStatus.NOT_IMPLEMENTED);
    }

}
