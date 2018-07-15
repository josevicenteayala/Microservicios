package co.com.investment.cryptocurrency.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import co.com.investment.cryptocurrency.model.CryptoCurrency;

public class DataBaseSimulator {

	public DataBaseSimulator() {
		
	}
	
	/**
	 * Get all crypto currencies
	 */
	public List<CryptoCurrency> getCryptoCurrencyList() {
		List<CryptoCurrency> cryptoCurrencyList = new ArrayList<CryptoCurrency>();
        CryptoCurrency cryptoCurrency = new CryptoCurrency();
        cryptoCurrency.setName("Git Commit Message");
        BigDecimal valueInDollar = new  BigDecimal(25000);
		cryptoCurrency.setValueInDollar(valueInDollar);
		cryptoCurrencyList.add(cryptoCurrency);
		return cryptoCurrencyList;
	}	

}
