package co.com.investment.cryptocurrency.model;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "it is the main subject to buy crypto currencies")
@Validated
public class Investment extends ResourceSupport {

	@JsonProperty("idMarketCoinSeller")
	private String idMarketCoinSeller;
	@JsonProperty("idMarketCoinBuyer")
	private String idMarketCoinBuyer;
	@JsonProperty("walletSellerOwner")
	private String walletSellerOwner;
	@JsonProperty("walletBuyerOwner")
	private String walletBuyerOwner;
	@JsonProperty("cryptoCurrencyName")
	private String cryptoCurrencyName;
	@JsonProperty("ammountToBuy")
	private String ammountToBuy;
	
	public String getIdMarketCoinSeller() {
		return idMarketCoinSeller;
	}
	public void setIdMarketCoinSeller(String idMarketCoinSeller) {
		this.idMarketCoinSeller = idMarketCoinSeller;
	}
	public String getIdMarketCoinBuyer() {
		return idMarketCoinBuyer;
	}
	public void setIdMarketCoinBuyer(String idMarketCoinBuyer) {
		this.idMarketCoinBuyer = idMarketCoinBuyer;
	}
	public String getWalletSellerOwner() {
		return walletSellerOwner;
	}
	public void setWalletSellerOwner(String walletSellerOwner) {
		this.walletSellerOwner = walletSellerOwner;
	}
	public String getWalletBuyerOwner() {
		return walletBuyerOwner;
	}
	public void setWalletBuyerOwner(String walletBuyerOwner) {
		this.walletBuyerOwner = walletBuyerOwner;
	}
	public String getCryptoCurrencyName() {
		return cryptoCurrencyName;
	}
	public void setCryptoCurrencyName(String cryptoCurrencyName) {
		this.cryptoCurrencyName = cryptoCurrencyName;
	}
	public String getAmmountToBuy() {
		return ammountToBuy;
	}
	public void setAmmountToBuy(String ammountToBuy) {
		this.ammountToBuy = ammountToBuy;
	}
	
}
