package tqs.hw1.api.get_data;

import io.cucumber.spring.CucumberContextConfiguration;
import tqs.hw1.api.ApiApplication;

import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = ApiApplication.class,
  webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CucumberDataConfiguration {
  
}