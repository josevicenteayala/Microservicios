package co.com.investment.cryptocurrency.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.investment.cryptocurrency.model.CryptoCurrency;
import co.com.investment.cryptocurrency.model.MarketCoin;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class MarketcoinApiController implements MarketcoinApi {

    private static final Logger log = LoggerFactory.getLogger(MarketcoinApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public MarketcoinApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addCryptoCurrencyToMarketCoin(@ApiParam(value = "Market coin to add the cryptocurrency",required=true) @PathVariable("idMarketCoin") String idMarketCoin,@ApiParam(value = "Marketcoin to create"  )  @Valid @RequestBody CryptoCurrency marketCoin) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> addMarketCoin(@ApiParam(value = "Market coin to add",required=true) @PathVariable("idMarketCoin") String idMarketCoin,@ApiParam(value = "Marketcoin to create"  )  @Valid @RequestBody MarketCoin marketCoin) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<CryptoCurrency>> searchCryptoCurrencies(@ApiParam(value = "pass a mandatory search id for looking up the marketcoin brand and his cryptocurrencies",required=true) @PathVariable("idMarketCoin") String idMarketCoin,@Min(0)@ApiParam(value = "number of records to skip for pagination") @Valid @RequestParam(value = "skip", required = false) Integer skip,@Min(0) @Max(50) @ApiParam(value = "maximum number of records to return") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<CryptoCurrency>>(objectMapper.readValue("[ {  \"name\" : \"Bitcoin\",  \"valueInDollar\" : 25.0}, {  \"name\" : \"Bitcoin\",  \"valueInDollar\" : 25.0} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<CryptoCurrency>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<CryptoCurrency>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<MarketCoin>> searchMarketCoin(@ApiParam(value = "pass a mandatory search id for looking up the marketcoin brand",required=true) @PathVariable("idMarketCoin") String idMarketCoin,@Min(0)@ApiParam(value = "number of records to skip for pagination") @Valid @RequestParam(value = "skip", required = false) Integer skip,@Min(0) @Max(50) @ApiParam(value = "maximum number of records to return") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<MarketCoin>>(objectMapper.readValue("[ {  \"cryptoCurrencyList\" : [ {    \"name\" : \"Bitcoin\",    \"valueInDollar\" : 25.0  }, {    \"name\" : \"Bitcoin\",    \"valueInDollar\" : 25.0  } ],  \"walletList\" : [ {    \"owner\" : \"Boundary Limit Investor\",    \"privateKey\" : \"12346W4646eqweeeeee3wqew7898665\",    \"idWallet\" : \"we459893r66asd65srsd65sdrser65fdds\",    \"currencyInvestment\" : [ {      \"ammountOfCryptoCurrency\" : 2.8,      \"cryptoCurrency\" : {        \"name\" : \"Bitcoin\",        \"valueInDollar\" : 25.0      }    }, {      \"ammountOfCryptoCurrency\" : 2.8,      \"cryptoCurrency\" : {        \"name\" : \"Bitcoin\",        \"valueInDollar\" : 25.0      }    } ]  }, {    \"owner\" : \"Boundary Limit Investor\",    \"privateKey\" : \"12346W4646eqweeeeee3wqew7898665\",    \"idWallet\" : \"we459893r66asd65srsd65sdrser65fdds\",    \"currencyInvestment\" : [ {      \"ammountOfCryptoCurrency\" : 2.8,      \"cryptoCurrency\" : {        \"name\" : \"Bitcoin\",        \"valueInDollar\" : 25.0      }    }, {      \"ammountOfCryptoCurrency\" : 2.8,      \"cryptoCurrency\" : {        \"name\" : \"Bitcoin\",        \"valueInDollar\" : 25.0      }    } ]  } ],  \"name\" : \"Digital Currency Investment\",  \"idMarketCoin\" : 200}, {  \"cryptoCurrencyList\" : [ {    \"name\" : \"Bitcoin\",    \"valueInDollar\" : 25.0  }, {    \"name\" : \"Bitcoin\",    \"valueInDollar\" : 25.0  } ],  \"walletList\" : [ {    \"owner\" : \"Boundary Limit Investor\",    \"privateKey\" : \"12346W4646eqweeeeee3wqew7898665\",    \"idWallet\" : \"we459893r66asd65srsd65sdrser65fdds\",    \"currencyInvestment\" : [ {      \"ammountOfCryptoCurrency\" : 2.8,      \"cryptoCurrency\" : {        \"name\" : \"Bitcoin\",        \"valueInDollar\" : 25.0      }    }, {      \"ammountOfCryptoCurrency\" : 2.8,      \"cryptoCurrency\" : {        \"name\" : \"Bitcoin\",        \"valueInDollar\" : 25.0      }    } ]  }, {    \"owner\" : \"Boundary Limit Investor\",    \"privateKey\" : \"12346W4646eqweeeeee3wqew7898665\",    \"idWallet\" : \"we459893r66asd65srsd65sdrser65fdds\",    \"currencyInvestment\" : [ {      \"ammountOfCryptoCurrency\" : 2.8,      \"cryptoCurrency\" : {        \"name\" : \"Bitcoin\",        \"valueInDollar\" : 25.0      }    }, {      \"ammountOfCryptoCurrency\" : 2.8,      \"cryptoCurrency\" : {        \"name\" : \"Bitcoin\",        \"valueInDollar\" : 25.0      }    } ]  } ],  \"name\" : \"Digital Currency Investment\",  \"idMarketCoin\" : 200} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<MarketCoin>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<MarketCoin>>(HttpStatus.NOT_IMPLEMENTED);
    }

}
