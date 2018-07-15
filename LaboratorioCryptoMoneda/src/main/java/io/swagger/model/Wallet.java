package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.CurrencyInvestment;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * This is the main object to manage all cryptocurrencies
 */
@ApiModel(description = "This is the main object to manage all cryptocurrencies")
@Validated

public class Wallet   {
  @JsonProperty("idWallet")
  private String idWallet = null;

  @JsonProperty("owner")
  private String owner = null;

  @JsonProperty("privateKey")
  private String privateKey = null;

  @JsonProperty("currencyInvestment")
  @Valid
  private List<CurrencyInvestment> currencyInvestment = new ArrayList<CurrencyInvestment>();

  public Wallet idWallet(String idWallet) {
    this.idWallet = idWallet;
    return this;
  }

  /**
   * nique identifier of the wallet
   * @return idWallet
  **/
  @ApiModelProperty(example = "we459893r66asd65srsd65sdrser65fdds", required = true, value = "nique identifier of the wallet")
  @NotNull


  public String getIdWallet() {
    return idWallet;
  }

  public void setIdWallet(String idWallet) {
    this.idWallet = idWallet;
  }

  public Wallet owner(String owner) {
    this.owner = owner;
    return this;
  }

  /**
   * persona that is owner of wallet
   * @return owner
  **/
  @ApiModelProperty(example = "Boundary Limit Investor", required = true, value = "persona that is owner of wallet")
  @NotNull


  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public Wallet privateKey(String privateKey) {
    this.privateKey = privateKey;
    return this;
  }

  /**
   * secret key to create the ledger
   * @return privateKey
  **/
  @ApiModelProperty(example = "12346W4646eqweeeeee3wqew7898665", value = "secret key to create the ledger")


  public String getPrivateKey() {
    return privateKey;
  }

  public void setPrivateKey(String privateKey) {
    this.privateKey = privateKey;
  }

  public Wallet currencyInvestment(List<CurrencyInvestment> currencyInvestment) {
    this.currencyInvestment = currencyInvestment;
    return this;
  }

  public Wallet addCurrencyInvestmentItem(CurrencyInvestment currencyInvestmentItem) {
    this.currencyInvestment.add(currencyInvestmentItem);
    return this;
  }

  /**
   * Get currencyInvestment
   * @return currencyInvestment
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public List<CurrencyInvestment> getCurrencyInvestment() {
    return currencyInvestment;
  }

  public void setCurrencyInvestment(List<CurrencyInvestment> currencyInvestment) {
    this.currencyInvestment = currencyInvestment;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Wallet wallet = (Wallet) o;
    return Objects.equals(this.idWallet, wallet.idWallet) &&
        Objects.equals(this.owner, wallet.owner) &&
        Objects.equals(this.privateKey, wallet.privateKey) &&
        Objects.equals(this.currencyInvestment, wallet.currencyInvestment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idWallet, owner, privateKey, currencyInvestment);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Wallet {\n");
    
    sb.append("    idWallet: ").append(toIndentedString(idWallet)).append("\n");
    sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
    sb.append("    privateKey: ").append(toIndentedString(privateKey)).append("\n");
    sb.append("    currencyInvestment: ").append(toIndentedString(currencyInvestment)).append("\n");
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

