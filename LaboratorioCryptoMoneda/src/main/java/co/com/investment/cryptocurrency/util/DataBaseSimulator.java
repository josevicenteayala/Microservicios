package co.com.investment.cryptocurrency.util;

import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.ArrayList;
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
	public MarketCoin getMarketCoin(String idMarketCoin) throws CryptocurrencyInvestmentException{
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
		throw new CryptocurrencyInvestmentException();
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
		boolean createMarketCoin = true;
		try {
			getMarketCoin(idMarketCoin);
			createMarketCoin = false;
		}catch(CryptocurrencyInvestmentException cuie){
		}
		if(createMarketCoin) {
			marketCoinList.add(marketCoin);
		}
		return marketCoin;
	}
	
	/**
	 * Buy crypto currency from another wallet.
	 *
	 * @param idMarketCoinSeller the id market coin
	 * @param walletSellerOwner the wallet owner
	 * @param cryptoCurrencyName the crypto currency name
	 * @param ammountToBuy the ammount to buy
	 */
	public Wallet buyCryptoCurrency(String idMarketCoinSeller, String idMarketCoinBuyer, String walletSellerOwner,String walletBuyerOwner, String cryptoCurrencyName, BigDecimal ammountToBuy) throws CryptocurrencyInvestmentException {
		MarketCoin marketCoinSeller = getMarketCoin(idMarketCoinSeller);
		MarketCoin marketCoinBuyer = getMarketCoin(idMarketCoinBuyer);
		
		Wallet sellerWallet = getWalletFromMarketCoin(walletSellerOwner, cryptoCurrencyName, marketCoinSeller);
		CurrencyInvestment sellerCurrencyInvestment = getCurrencyInvestment(cryptoCurrencyName, sellerWallet);
		
		Wallet buyerWallet = getWalletFromMarketCoin(walletBuyerOwner, cryptoCurrencyName, marketCoinBuyer);
		CurrencyInvestment buyerCurrencyInvestment = getCurrencyInvestment(cryptoCurrencyName,buyerWallet);
		
		sellerCurrencyInvestment.substractCryptoCurrency(ammountToBuy);
		buyerCurrencyInvestment.additionOfCryptoCurrency(ammountToBuy);
		
		return buyerWallet;
	}

	/**
	 * @param walletSellerOwner
	 * @param cryptoCurrencyName
	 * @param marketCoin
	 * @return a Wallet from a MarketCoin
	 */
	public Wallet getWalletFromMarketCoin(String walletSellerOwner, String cryptoCurrencyName,
			MarketCoin marketCoin) {
		List<Wallet> walletListFromMarketCoin = marketCoin.getWalletList();
		Iterator<Wallet> iterator = walletListFromMarketCoin.iterator();
		while(iterator.hasNext()) {
			Wallet wallet = iterator.next();
			if(wallet.getOwner().equals(walletSellerOwner)) {
				return wallet;
			}
		}
		throw new CryptocurrencyInvestmentException();
	}

	/**
	 * @param cryptoCurrencyName
	 * @param wallet
	 * @return a CurrencyInvestment with a new investment
	 */
	public CurrencyInvestment getCurrencyInvestment(String cryptoCurrencyName, Wallet wallet) {
		List<CurrencyInvestment> currencyInvestmentList = wallet.getCurrencyInvestment();
		Iterator<CurrencyInvestment> iteratorCurrencyInvestment = currencyInvestmentList.iterator();
		while(iteratorCurrencyInvestment.hasNext()) {
			CurrencyInvestment currencyInvestment = iteratorCurrencyInvestment.next();
			if(currencyInvestment.getCryptoCurrency().getName().equals(cryptoCurrencyName)) {
				return currencyInvestment;
			}
		}
		throw new CryptocurrencyInvestmentException();
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
		list.add("Jose_Vicente");
		list.add("Miguel_Zuleta");
		list.add("Marcela_Ocampo");
		list.add("Stefanny_Gomez");
		list.add("George_Bush");
		list.add("Michael_Ortega");
		list.add("Mario_Parra");
		list.add("Alexis_Perez");
		list.add("Maria_del_Potro");
		list.add("Oscar_Valdez");
		list.add("Mijito_Lindo");
		list.add("Natalia_Madrid");
		list.add("Robert_Jose");
		list.add("Bernarda_Maria");
		list.add("Juan_Delgado");
		list.add("Pedro_Judeo");
		list.add("Marco_Black");

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
