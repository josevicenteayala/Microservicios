package co.com.investment.cryptocurrency.util;

import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import org.apache.commons.rng.sampling.CollectionSampler;
import org.apache.commons.rng.simple.RandomSource;
import org.springframework.stereotype.Service;

import co.com.investment.cryptocurrency.model.CryptoCurrency;
import co.com.investment.cryptocurrency.model.CurrencyInvestment;
import co.com.investment.cryptocurrency.model.MarketCoin;
import co.com.investment.cryptocurrency.model.Wallet;

enum CRYPTOCURRENCY{
	BITCOIN("BitCoin",	new BigDecimal(6395)),
	ETHERIUM("Etherium",	new BigDecimal(453)),
	XRP("XRP",	new BigDecimal(0.44)),
	EOS("EOS",	new BigDecimal(730.06)),
	LITECOIN("LiteCoin",	new BigDecimal(7.69)),
	STELLAR("Stellar",	new BigDecimal(79.66)),
	CARDANO("Cardano",	new BigDecimal(0.22)),
	IOTA("IOTA",	new BigDecimal(0.14));
	
	String name = null;
	BigDecimal value = null;
	CRYPTOCURRENCY(String name, BigDecimal valueInDollar){
		this.name = name;
		this.value = valueInDollar;
	}
	public String getName() {
		return name;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
};

@Service
public class DataBaseSimulator {
	
	private static final boolean CRYPTO_CURRENCY_EXIST = true;
	private static DataBaseSimulator  dataBaseSimulator;
	private List<CryptoCurrency> cryptoCurrencyList;
	private List<MarketCoin> marketCoinList;
	private List<Wallet> walletList;
	
	private DataBaseSimulator() {
		cryptoCurrencyList = new ArrayList<CryptoCurrency>();
		marketCoinList = new ArrayList<MarketCoin>();
		walletList = new ArrayList<>();
	}
	
	public static DataBaseSimulator getInstance() {
		if(Objects.isNull(dataBaseSimulator)) {
			dataBaseSimulator = new DataBaseSimulator();
		}
		return dataBaseSimulator;
	}
	
	/**
	 * Get all crypto currencies
	 */
	public List<CryptoCurrency> getCryptoCurrencyList() {
		if(cryptoCurrencyList.isEmpty()) {
			for(int counter = 0; counter < 8;counter++) {
		        CryptoCurrency cryptoCurrency = getCryptoCurrency(counter);
				cryptoCurrencyList.add(cryptoCurrency);
			}			
		}
		
		return cryptoCurrencyList;
	}	
	
	/**
	 * @return the market coin list
	 */
	public List<MarketCoin> getMarketCoinList() {
		if(marketCoinList.isEmpty()) {
			for(int count = 1;count<6;count++) {
				MarketCoin marketCoin = new MarketCoin();
				marketCoin.setCryptoCurrencyList(getCryptoCurrencyList());
				marketCoin.setIdMarketCoin(count*1000);
				marketCoin.setName(randomMarketCoinNames());
				marketCoin.setWalletList(getWalletList());
				marketCoinList.add(marketCoin);	
			}			
		}
		
		return marketCoinList;
	}
	
	/**
	 * @return MarketCoin
	 */
	public MarketCoin getMarketCoin(String idMarketCoin) {
		if(Objects.nonNull(idMarketCoin)) {
			List<MarketCoin> marketCoinList = getMarketCoinList();
			Iterator<MarketCoin> iterator = marketCoinList.iterator();
			while(iterator.hasNext()) {
				MarketCoin marketCoin = iterator.next();
				if(marketCoin.getIdMarketCoin().toString().equals(idMarketCoin)) {
					return marketCoin;
				}
			}
		}
		return null;
	}
	
	/**
	 * @return a list with all cryptocurrencies than belong an specific marketcoin
	 */
	public List<CryptoCurrency> getCryptoCurrenciesFormMarketCoin(String idMarketCoin) {
		MarketCoin marketCoin = getMarketCoin(idMarketCoin);		
		return marketCoin.getCryptoCurrencyList();
	}

	/**
	 * @param name
	 * @return one CryptoCurrency
	 */
	public CryptoCurrency getCryptoCurrency(String name) {
		List<CryptoCurrency> cryptoCurrencyList2 = getCryptoCurrencyList();
		Iterator<CryptoCurrency> iterator = cryptoCurrencyList2.iterator();
		while(iterator.hasNext()) {
			CryptoCurrency cryptoCurrency = iterator.next();
			if(cryptoCurrency.getName().equals(name)) {
				return cryptoCurrency;
			}
		}
		return null;
	}
	
	/**
	 * @param idMarketCoin
	 * @param cryptoCurrency
	 * @return a boolean if the operation was successfully
	 */
	public boolean addCryptoCurrencyToMarketCoin(String idMarketCoin, CryptoCurrency cryptoCurrency) {
		MarketCoin marketCoin = getMarketCoin(idMarketCoin);
		List<CryptoCurrency> cryptoCurrencyList = marketCoin.getCryptoCurrencyList();
		Iterator<CryptoCurrency> iterator = cryptoCurrencyList.iterator();
		while(iterator.hasNext()) {
			CryptoCurrency actualCryptoCurrency = iterator.next();
			if(actualCryptoCurrency.getName().equals(cryptoCurrency.getName())) {
				return CRYPTO_CURRENCY_EXIST;
			}
		}
		return marketCoin.getCryptoCurrencyList().add(cryptoCurrency);
	}
	
	/**
	 * @param idMarketCoin
	 * @param marketCoin
	 * @return MarketCoin ceated or finded
	 */
	public MarketCoin addMarketCoin (String idMarketCoin, MarketCoin marketCoin) {
		MarketCoin marketCoinFinded = getMarketCoin(idMarketCoin);
		if(Objects.isNull(marketCoinFinded)) {
			marketCoinList.add(marketCoin);
		}
		return marketCoin;
	}
	
	/**
	 * @return the wallet list
	 */
	private List<Wallet> getWalletList() {
		if(walletList.isEmpty()) {
			for(int idWallet = 0; idWallet < 10;idWallet++) {
				Wallet wallet = new Wallet();
				List<CurrencyInvestment> currencyInvestment = getInvestmentCurrencyList();
				wallet.setCurrencyInvestment(currencyInvestment );
				wallet.setIdWallet(String.valueOf(idWallet));
				wallet.setOwner(randomPeopleNames());
				wallet.setPrivateKey(generatingRandomString());
				walletList.add(wallet);	
			}			
		}
		return walletList;
	}

	/**
	 * @return the list of currencies that have a wallet
	 */
	private List<CurrencyInvestment> getInvestmentCurrencyList() {
		List<CurrencyInvestment> investmentCurrencyList = new ArrayList<>();
		Random random = new Random();
		for(int count = 0;count <8;count++) {
			CurrencyInvestment currencyInvestment = new CurrencyInvestment();
			BigDecimal ammountOfCryptoCurrency = new BigDecimal(random.nextDouble());
			currencyInvestment.setAmmountOfCryptoCurrency(ammountOfCryptoCurrency);
			currencyInvestment.setCryptoCurrency(getCryptoCurrency(count));
			investmentCurrencyList.add(currencyInvestment);
		}
		return investmentCurrencyList;
	}
	/**
	 * @param counter
	 * @return a CryptoCurrency object
	 */
	private CryptoCurrency getCryptoCurrency(int counter) {
		CryptoCurrency cryptoCurrency = new CryptoCurrency();
		cryptoCurrency.setName(CRYPTOCURRENCY.values()[counter].getName());
		BigDecimal valueInDollar = new  BigDecimal(new Random().nextDouble());
		cryptoCurrency.setValueInDollar(valueInDollar);
		return cryptoCurrency;
	}
	/**
	 * @return an string of 20 characters
	 */
	private String generatingRandomString() {
	    byte[] array = new byte[20];
	    new Random().nextBytes(array);
	    String generatedString = new String(array, Charset.forName("UTF-8"));
	    return generatedString;
	}	
	
	/**
	 * @return a name from the list
	 */
	private String randomPeopleNames() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Jose Vicente");
		list.add("Miguel Zuleta");
		list.add("Marcela Ocampo");
		list.add("Stefanny Gomez");
		list.add("George Bush");
		list.add("Michael Ortega");
		list.add("Mario Parra");
		list.add("Alexis Perez");
		list.add("Maria del Potro");
		list.add("Oscar Valdez");
		list.add("Mijito Lindo");
		list.add("Natalia Madrid");
		list.add("Robert Jose");
		list.add("Bernarda Maria");
		list.add("Juan Delgado");
		list.add("Pedro Judeo");
		list.add("Marco Black");

		CollectionSampler<String> sampler = new CollectionSampler<String>(RandomSource.create(RandomSource.MWC_256),list);
		String word = sampler.sample();	
		return word;
	}
	
	/**
	 * @return a name of MarketCOin from the list
	 */
	private String randomMarketCoinNames() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Coin Market CAP");
		list.add("Currency Market");
		list.add("Crypto Paisa");
		list.add("Online Coin");
		list.add("Virtual Coin");
		list.add("Get Rich from House");
		list.add("Be free.com");
		list.add("Nex Coin");
		list.add("Virtual Market");
		list.add("Do OK");
		list.add("Donald Coin");
		list.add("Buy Currency Online");
		list.add("Trust us");
		list.add("Bank Currency");
		list.add("Currency Crypto Coin");
		list.add("Bitcoin market");
		list.add("Rich 2020");

		CollectionSampler<String> sampler = new CollectionSampler<String>(RandomSource.create(RandomSource.MWC_256),list);
		String word = sampler.sample();	
		return word;
	}	
}
