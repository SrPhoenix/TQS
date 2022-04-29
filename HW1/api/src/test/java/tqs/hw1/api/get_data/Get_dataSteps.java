package tqs.hw1.api.get_data;

 
import static org.junit.jupiter.api.Assertions.assertNotEquals;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tqs.hw1.api.service.CovidService;
import tqs.hw1.api.model.ModelRequest;
 
public class Get_dataSteps {
	private CovidService service = new CovidService();
	private ModelRequest data = new ModelRequest();

	@When("When I search for covid data from  the city {String}, country code {String}, date {String} and Region name {String}")
	public void the_country(final String city,final String country, final String date,final String region) throws Throwable {
		data.setCity_name(city);
		data.setCountry(country);
		data.setDate(date);
		data.setRegion_name(region);

	}

 
	@Then("Then data should appear, like for example, the province {String}")
	public void the_user_must_get_that_information(final String province) throws Throwable {
		assertNotEquals(service.getData(data).get(0).getRegion().getProvince() , province);
	}
}
