package tqs.hw1.api;


import org.json.JSONObject;

//import com.google.gson.JsonObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Locale;

@Controller
public class CovidController {
    String[] countries = Locale.getISOCountries();
    private final CovidService service;


    public CovidController(CovidService service) {
        this.service=service;
    }

    
	@GetMapping("/")
    public String index(Model model) {
        System.out.println("index");
        String[] countries_ = new String[countries.length + 1];
        int i = 1;
        countries_[0]= "";
        for (String c : countries) {
            countries_[i] = new Locale("en", c).getISO3Country();
            i++;
        }
        model.addAttribute("countries", countries_);
        model.addAttribute("data", new CovidData());
        return "index";
    }

    @GetMapping("/data")
    public @ResponseBody String data(@ModelAttribute("data") @RequestBody CovidData data, Model model) throws IOException {
        System.out.println("Post data");
        //System.out.println(data.getDate());
        
        JSONObject response = service.getData(data);
        System.out.println(response);
        return response.getJSONArray("data").getJSONObject(0).getJSONObject("region").toString();
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
