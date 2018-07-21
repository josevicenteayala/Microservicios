package co.com.investment.cryptocurrency.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * ammount of cryptocurrency
 */
@ApiModel(description = "ammount of cryptocurrency")
@Validated

public class CurrencyInvestment   {
  @JsonProperty("ammountOfCryptoCurrency")
  private BigDecimal ammountOfCryptoCurrency = null;

  @JsonProperty("cryptoCurrency")
  private CryptoCurrency cryptoCurrency = null;

  public CurrencyInvestment ammountOfCryptoCurrency(BigDecimal ammountOfCryptoCurrency) {
    this.ammountOfCryptoCurrency = ammountOfCryptoCurrency;
    return this;
  }

  /**
 * @param ammountOfCryptoCurrency
 * @return CurrencytInvestment with the new value 
 */
public CurrencyInvestment additionOfCryptoCurrency(BigDecimal ammountOfCryptoCurrency) {
	this.ammountOfCryptoCurrency = this.ammountOfCryptoCurrency.add(ammountOfCryptoCurrency);
	  return this;
  }

  /**
 * @param ammountOfCryptoCurrency
 * @return CurrencyInvestment with the new value
 */
public CurrencyInvestment substractCryptoCurrency(BigDecimal ammountOfCryptoCurrency) {
	this.ammountOfCryptoCurrency = this.ammountOfCryptoCurrency.subtract(ammountOfCryptoCurrency);
	  return this;
  }  
  
  /**
   * ammount of specific cryptocurrency
   * @return ammountOfCryptoCurrency
  **/
  @ApiModelProperty(example = "2.8", value = "ammount of specific cryptocurrency")

  @Valid

  public BigDecimal getAmmountOfCryptoCurrency() {
    return ammountOfCryptoCurrency;
  }

  public void setAmmountOfCryptoCurrency(BigDecimal ammountOfCryptoCurrency) {
    this.ammountOfCryptoCurrency = ammountOfCryptoCurrency;
  }

  public CurrencyInvestment cryptoCurrency(CryptoCurrency cryptoCurrency) {
    this.cryptoCurrency = cryptoCurrency;
    return this;
  }

  /**
   * Get cryptoCurrency
   * @return cryptoCurrency
  **/
  @ApiModelProperty(value = "")

  @Valid

  public CryptoCurrency getCryptoCurrency() {
    return cryptoCurrency;
  }

  public void setCryptoCurrency(CryptoCurrency cryptoCurrency) {
    this.cryptoCurrency = cryptoCurrency;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CurrencyInvestment currencyInvestment = (CurrencyInvestment) o;
    return Objects.equals(this.ammountOfCryptoCurrency, currencyInvestment.ammountOfCryptoCurrency) &&
        Objects.equals(this.cryptoCurrency, currencyInvestment.cryptoCurrency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ammountOfCryptoCurrency, cryptoCurrency);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CurrencyInvestment {\n");
    
    sb.append("    ammountOfCryptoCurrency: ").append(toIndentedString(ammountOfCryptoCurrency)).append("\n");
    sb.append("    cryptoCurrency: ").append(toIndentedString(cryptoCurrency)).append("\n");
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

