package tqs.hw1.api.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.google.gson.JsonObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import tqs.hw1.api.model.ModelRequest;
import tqs.hw1.api.service.CovidService;

import java.util.Arrays;
import java.util.Locale;

@Controller
public class CovidController {
    String[] countries = Locale.getISOCountries();
    private static final Logger logger = LoggerFactory.getLogger(CovidController.class);


	@GetMapping("/")
    public String index(Model model) {
        logger.debug("index");
        String[] countries_ = new String[countries.length + 1];
        int i = 1;
        countries_[0]= "";
        for (String c : countries) {
            countries_[i] = new Locale("en", c).getISO3Country();
            i++;
        }
        logger.debug("countries", Arrays.asList(countries_));
        model.addAttribute("countries", countries_);
        model.addAttribute("data", new ModelRequest());
        return "index";
    }


/*     @PostMapping("/data")
    public String submitData(@ModelAttribute("data") CovidData data, Model model) throws IOException {
        System.out.println("Post data");
        System.out.println(data.getDate());
        
        JSONObject response = service.request(data);
        
        model.addAttribute("data", response.toString());
        return "data";
    } */

    

    
    

}

/*

Connect : 
    OkHttpClient client = new OkHttpClient();

    Request request = new Request.Builder()
            .url("https://covid-19-statistics.p.rapidapi.com/reports?
            date=2020-04-16 & 
            q=US%20Alabama & 
            region_name=US & 
            iso=USA & 
            region_province=Alabama & 
            city_name=Autauga")
            .get()
            .addHeader("X-RapidAPI-Host", "covid-19-statistics.p.rapidapi.com")
            .addHeader("X-RapidAPI-Key", "54a04285f3msh775e05c8199e3d1p10dee3jsn18132b791694")
            .build();

    Response response = client.newCall(request).execute();


    Countries (for the request)
    Locale.IsoCountryCode[] countries = Locale.IsoCountryCode.values();
    Locale.getISOCountries(countries[0]);

*/
