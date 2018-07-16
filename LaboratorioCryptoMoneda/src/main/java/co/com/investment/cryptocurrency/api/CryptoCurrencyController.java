package co.com.investment.cryptocurrency.api;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.investment.cryptocurrency.model.CryptoCurrency;
import co.com.investment.cryptocurrency.util.DataBaseSimulator;

@Controller
public class CryptoCurrencyController implements CryptoCurrencyApi {

	private static final String CRYPTO_CURENCY_FOUND = "Crypto curency found";
	private static final String CURRENCY_FOUND = "CurrencyFound";
	private static final String CRYPTO_CURENCY_NOT_FOUND = "Crypto curency not found";
	private static final String CURRENCY_NOT_FOUND = "CurrencyNotFound";
	private static final long ONE_SECOND = 1000;
	private final ObjectMapper objectMapper;
	private final HttpServletRequest request;
	private DataBaseSimulator dataBaseSimulator = DataBaseSimulator.getInstance();
	
	@Autowired
	public CryptoCurrencyController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
	}

	@Override
	public ResponseEntity<CryptoCurrency> searchCryptoCurrencyBySelf(String name) {
		CryptoCurrency cryptoCurrency = dataBaseSimulator.getCryptoCurrency(name);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setExpires(ONE_SECOND);
		ResponseEntity<CryptoCurrency> responseEntity = null;
		if(Objects.isNull(cryptoCurrency)) {
			httpHeaders.set(CURRENCY_NOT_FOUND, CRYPTO_CURENCY_NOT_FOUND);
			responseEntity = new ResponseEntity<>(cryptoCurrency,httpHeaders,HttpStatus.NO_CONTENT);
		}
		httpHeaders.set(CURRENCY_FOUND, CRYPTO_CURENCY_FOUND);
		responseEntity = new ResponseEntity<>(cryptoCurrency,httpHeaders,HttpStatus.NO_CONTENT);		
		return responseEntity;
	}

}
