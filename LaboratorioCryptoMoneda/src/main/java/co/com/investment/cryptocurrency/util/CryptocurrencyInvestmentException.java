package co.com.investment.cryptocurrency.util;

public class CryptocurrencyInvestmentException extends RuntimeException {

	private static final String ERROR_IN_CRYPTO_CURRENCY_OPERATION = " Error in cryptoCurrency operation";

	private StringBuilder stringBuilder;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7361136778388392533L;

	public CryptocurrencyInvestmentException() {
		stringBuilder = new StringBuilder();
	}
	
	@Override
	public String getMessage() {
		stringBuilder.append(super.getMessage());
		stringBuilder.append(ERROR_IN_CRYPTO_CURRENCY_OPERATION);
		return stringBuilder.toString();
	}
}
