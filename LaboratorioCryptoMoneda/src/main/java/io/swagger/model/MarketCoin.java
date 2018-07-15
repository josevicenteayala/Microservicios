package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.CryptoCurrency;
import io.swagger.model.Wallet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * it is the company that let the investor to sell/buy cryptocurrencies and get his own wallet
 */
@ApiModel(description = "it is the company that let the investor to sell/buy cryptocurrencies and get his own wallet")
@Validated

public class MarketCoin   {
  @JsonProperty("idMarketCoin")
  private Integer idMarketCoin = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("cryptoCurrencyList")
  @Valid
  private List<CryptoCurrency> cryptoCurrencyList = new ArrayList<CryptoCurrency>();

  @JsonProperty("walletList")
  @Valid
  private List<Wallet> walletList = new ArrayList<Wallet>();

  public MarketCoin idMarketCoin(Integer idMarketCoin) {
    this.idMarketCoin = idMarketCoin;
    return this;
  }

  /**
   * unique id from the market
   * @return idMarketCoin
  **/
  @ApiModelProperty(example = "200", required = true, value = "unique id from the market")
  @NotNull


  public Integer getIdMarketCoin() {
    return idMarketCoin;
  }

  public void setIdMarketCoin(Integer idMarketCoin) {
    this.idMarketCoin = idMarketCoin;
  }

  public MarketCoin name(String name) {
    this.name = name;
    return this;
  }

  /**
   * name of the company
   * @return name
  **/
  @ApiModelProperty(example = "Digital Currency Investment", required = true, value = "name of the company")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public MarketCoin cryptoCurrencyList(List<CryptoCurrency> cryptoCurrencyList) {
    this.cryptoCurrencyList = cryptoCurrencyList;
    return this;
  }

  public MarketCoin addCryptoCurrencyListItem(CryptoCurrency cryptoCurrencyListItem) {
    this.cryptoCurrencyList.add(cryptoCurrencyListItem);
    return this;
  }

  /**
   * list of cryptocurrencies with ones it is possible to make transactions
   * @return cryptoCurrencyList
  **/
  @ApiModelProperty(required = true, value = "list of cryptocurrencies with ones it is possible to make transactions")
  @NotNull

  @Valid

  public List<CryptoCurrency> getCryptoCurrencyList() {
    return cryptoCurrencyList;
  }

  public void setCryptoCurrencyList(List<CryptoCurrency> cryptoCurrencyList) {
    this.cryptoCurrencyList = cryptoCurrencyList;
  }

  public MarketCoin walletList(List<Wallet> walletList) {
    this.walletList = walletList;
    return this;
  }

  public MarketCoin addWalletListItem(Wallet walletListItem) {
    this.walletList.add(walletListItem);
    return this;
  }

  /**
   * list of kind of wallets tha the market offer
   * @return walletList
  **/
  @ApiModelProperty(required = true, value = "list of kind of wallets tha the market offer")
  @NotNull

  @Valid

  public List<Wallet> getWalletList() {
    return walletList;
  }

  public void setWalletList(List<Wallet> walletList) {
    this.walletList = walletList;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MarketCoin marketCoin = (MarketCoin) o;
    return Objects.equals(this.idMarketCoin, marketCoin.idMarketCoin) &&
        Objects.equals(this.name, marketCoin.name) &&
        Objects.equals(this.cryptoCurrencyList, marketCoin.cryptoCurrencyList) &&
        Objects.equals(this.walletList, marketCoin.walletList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idMarketCoin, name, cryptoCurrencyList, walletList);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MarketCoin {\n");
    
    sb.append("    idMarketCoin: ").append(toIndentedString(idMarketCoin)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    cryptoCurrencyList: ").append(toIndentedString(cryptoCurrencyList)).append("\n");
    sb.append("    walletList: ").append(toIndentedString(walletList)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

