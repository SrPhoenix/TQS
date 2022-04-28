package tqs.hw1.api.service;
import java.io.IOException;
import java.net.URISyntaxException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import tqs.hw1.api.exception.APINotRespondingException;
import tqs.hw1.api.model.CovidData;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


@Service
public class CovidService {
    OkHttpClient client = new OkHttpClient();
    private static Logger logger = LogManager.getLogger(CovidService.class);
    
    @Autowired
    Cache cache;

    public JSONObject getData(CovidData data) throws IOException, URISyntaxException, APINotRespondingException{
        logger.debug("getData");
        JSONObject response = cache.get(data);
        if(response==null){
            logger.debug("Get Data from Api");
            response = request(data.getDate(),data.getRegion_name(),data.getCountry(),data.getCity_name()); 
            cache.put(data,response);
            return response;
        }
        
        return response;
        
    }

    private JSONObject request(String date, String region, String country, String city) throws URISyntaxException, APINotRespondingException , IOException{
        logger.debug("Request Function");        
        StringBuilder url = new StringBuilder("https://covid-19-statistics.p.rapidapi.com/reports?");
        if (!date.equals(""))
            url.append("date="+date);
        else if (!region.equals(""))
            url.append("&region_name="+region);
        else if (!country.equals(""))
            url.append("&iso="+country);
        else if (!city.equals(""))
            url.append("&city_name="+city);
        logger.debug("url: ",url);

        Request request = new Request.Builder()
            .url(url.toString())
            .get()
            .addHeader("X-RapidAPI-Host", "covid-19-statistics.p.rapidapi.com")
            .addHeader("X-RapidAPI-Key", "54a04285f3msh775e05c8199e3d1p10dee3jsn18132b791694")
            .build();

        Response response = client.newCall(request).execute();
        logger.debug("Response is Successful: ", response.isSuccessful());
        JSONObject result = new JSONObject(response.body().string());
        if (result.getJSONArray("data").length() > 0)
            cache.plusHit();
        else    
            cache.plusMiss();
        return result;
    }

    public int getHit(){
        return cache.getHit();
    }

    public int getMiss(){
        return cache.getMiss();
    }
    public int getCountOfRequest(){
        return cache.getCountOfRequest();
    }
}
