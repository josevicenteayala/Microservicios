package investmentCurrrencyAPI;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.function.Consumer;

import org.junit.Before;
import org.junit.Test;

import co.com.investment.cryptocurrency.model.CryptoCurrency;
import co.com.investment.cryptocurrency.util.DataBaseSimulator;

public class DataBaseSimulatorTest {

	private DataBaseSimulator dataBaseSimulator;
	
	@Before
	public void setUp() throws Exception {
		dataBaseSimulator = DataBaseSimulator.getInstance();
	}

	@Test
	public void testGetCryptoCurrencyList() {
		List<CryptoCurrency> cryptoCurrencyList = dataBaseSimulator.getCryptoCurrencyList();
		assertNotNull(cryptoCurrencyList);
		Consumer<? super CryptoCurrency> action = (cryptoCurrency)->System.out.println(cryptoCurrency.getName());;
		cryptoCurrencyList.stream().forEach(action);
	}

}
