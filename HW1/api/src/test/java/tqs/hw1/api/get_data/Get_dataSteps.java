package tqs.hw1.api.get_data;

 
import static org.junit.jupiter.api.Assertions.assertNotEquals;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import tqs.hw1.api.service.CovidService;
import tqs.hw1.api.model.CovidData;
 
public class Get_dataSteps {
	private CovidService service = new CovidService();
	private CovidData data = new CovidData();

	@Given("a user that ask information about the country {String}")
	public void the_country(final String country) throws Throwable {
		data.setCountry(country);
	}

 
	@Then("the user must get that information")
	public void the_user_must_get_that_information() throws Throwable {
		assertNotEquals(service.getData(data).getJSONArray("data"),null);
	}
}
