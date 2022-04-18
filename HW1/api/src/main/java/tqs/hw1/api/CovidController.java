package tqs.hw1.api;

import java.util.concurrent.atomic.AtomicLong;

//import com.google.gson.JsonObject;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;

@Controller
public class CovidController {
    String[] countries = Locale.getISOCountries();
    HashMap<String, Response> cache = new HashMap<>();
    OkHttpClient client = new OkHttpClient();

    
	@GetMapping("/")
    public String index(Model model) {
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
    public String data(Model model) {
        
        return "data";
    }

    @PostMapping("/data")
    public String submitData(@ModelAttribute("data") CovidData data, Model model) throws IOException {
        System.out.println("Something");
        System.out.println(data.getDate());
        StringBuilder url = new StringBuilder("https://covid-19-statistics.p.rapidapi.com/reports?");
        if (!data.getDate().equals(""))
            url.append("date="+data.getDate());
        else if (!data.getRegion_name().equals(""))
            url.append("&region_name="+data.getRegion_name());
        else if (!data.getCountry().equals(""))
            url.append("&iso="+data.getCountry());
        else if (!data.getCity_name().equals(""))
            url.append("&city_name="+data.getCity_name());
        System.out.println(url);
        Request request = new Request.Builder()
            .url(url.toString())
            .get()
            .addHeader("X-RapidAPI-Host", "covid-19-statistics.p.rapidapi.com")
            .addHeader("X-RapidAPI-Key", "54a04285f3msh775e05c8199e3d1p10dee3jsn18132b791694")
            .build();

        Response response = client.newCall(request).execute();
        System.out.println(">.< " + response.isSuccessful());
        JSONObject covidData = new JSONObject(response.body().string());
        //return data.get("data").toString();
        model.addAttribute("data", covidData.toString());
        return "data";
    }

    
    

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
