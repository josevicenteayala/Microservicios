package co.com.investment.cryptocurrency.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * it is the main subject to interchange between monetary transactions
 */
@ApiModel(description = "it is the main subject to interchange between monetary transactions")
@Validated

public class CryptoCurrency  extends ResourceSupport{
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("valueInDollar")
  private BigDecimal valueInDollar = null;

  public CryptoCurrency name(String name) {
    this.name = name;
    return this;
  }

  /**
   * cryptocurrency name
   * @return name
  **/
  @ApiModelProperty(example = "Bitcoin", required = true, value = "cryptocurrency name")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CryptoCurrency valueInDollar(BigDecimal valueInDollar) {
    this.valueInDollar = valueInDollar;
    return this;
  }

  /**
   * equivalent to dollar money
   * @return valueInDollar
  **/
  @ApiModelProperty(example = "25.0", required = true, value = "equivalent to dollar money")
  @NotNull

  @Valid

  public BigDecimal getValueInDollar() {
    return valueInDollar;
  }

  public void setValueInDollar(BigDecimal valueInDollar) {
    this.valueInDollar = valueInDollar;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CryptoCurrency cryptoCurrency = (CryptoCurrency) o;
    return Objects.equals(this.name, cryptoCurrency.name) &&
        Objects.equals(this.valueInDollar, cryptoCurrency.valueInDollar);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, valueInDollar);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CryptoCurrency {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    valueInDollar: ").append(toIndentedString(valueInDollar)).append("\n");
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

