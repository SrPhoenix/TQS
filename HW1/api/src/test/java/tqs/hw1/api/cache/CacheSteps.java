package tqs.hw1.api.cache;

 
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tqs.hw1.api.service.CovidService;
import tqs.hw1.api.exception.APINotRespondingException;
import tqs.hw1.api.model.HitMiss;
import tqs.hw1.api.model.ModelRequest;

 

public class CacheSteps {
	private CovidService service = new CovidService();
	private ModelRequest data = new ModelRequest();
	HitMiss hitmiss;
 

    @When("I ask for the hitMiss statistics")
    public void hitmiss() {
        hitmiss= service.getHitMiss();
    }

	@And("I ask for the hitMiss statistics")
    public void hitmissAnd() {
        hitmiss= service.getHitMiss();
    }

	@When("I ask for covid data for the country with the iso code {string}")
    public void data(final String iso) throws IOException, URISyntaxException, APINotRespondingException {
        data.setCountry(iso);
		service.getData(data);
    }


 
	@Then("the total value is {int}, the hit  value is {int} and the miss value is {int}")
	public void the_user_must_get_that_information(final int total,final int hit,final int miss) throws Throwable {

		assertEquals(hitmiss.getTotal(), total);
		assertEquals(hitmiss.getHit(), hit);
		assertEquals(hitmiss.getMiss(), miss);
	}

}
