package tqs.hw1.api.get_data;

 
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tqs.hw1.api.service.CovidService;
import tqs.hw1.api.model.ModelRequest;
 
public class Get_dataSteps {
	@Autowired
	private CovidService service;
	private ModelRequest data = new ModelRequest();

	@When("I search for covid data from  the city {string}, country code {string}, date {string} and Region name {string}")
	public void the_country(final String city,final String country, final String date,final String region) throws Throwable {
		data.setCity_name(city);
		data.setCountry(country);
		data.setDate(date);
		data.setRegion_name(region);

	}

 
	@Then("data should appear, like for example, the province {string}")
	public void the_user_must_get_that_information(final String province) throws Throwable {
		System.out.println(data);
		assertEquals(service.getData(data).get(0).getRegion().getProvince() , province);
	}
}
