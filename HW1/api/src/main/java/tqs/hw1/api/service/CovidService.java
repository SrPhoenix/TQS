package tqs.hw1.api.service;
import java.io.IOException;
import java.net.URISyntaxException;

import com.google.gson.Gson; 
import com.google.gson.GsonBuilder;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import tqs.hw1.api.exception.APINotRespondingException;
import tqs.hw1.api.model.HitMiss;
import tqs.hw1.api.model.ModelRequest;
import tqs.hw1.api.model.ResponseDataArray;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class CovidService {
    OkHttpClient client = new OkHttpClient();
    private static final Logger logger = LoggerFactory.getLogger(CovidService.class);
    
    @Autowired
    Cache cache;


    public HitMiss getHitMiss()  {
        int hit=cache.getHit();
        int miss= cache.getMiss();
        return new HitMiss(hit+miss,hit,miss);
    }

    public ResponseDataArray getData(ModelRequest data) throws IOException, URISyntaxException, APINotRespondingException{
        ResponseDataArray response = cache.get(data);
        if(response==null){
            logger.info("Get Data from Api");
            logger.info("Miss Request");
            cache.plusMiss();
            response = request(data.getDate(),data.getRegion_name(),data.getCountry(),data.getCity_name()); 
            cache.put(data,response);
            return response;
        }
        logger.info("Hit Request");
        cache.plusHit();
        return response;
        
    }

    private ResponseDataArray request(String date, String region, String country, String city) throws URISyntaxException, APINotRespondingException , IOException{
        StringBuilder url = new StringBuilder("https://covid-19-statistics.p.rapidapi.com/reports?");
        if (!date.equals(""))
            url.append("date="+date);
        if (!region.equals(""))
            url.append("&region_name="+region);
        if (!country.equals(""))
            url.append("&iso="+country);
        if (!city.equals(""))
            url.append("&city_name="+city);
        logger.info("url: ", url.toString());

        Request request = new Request.Builder()
            .url(url.toString())
            .get()
            .addHeader("X-RapidAPI-Host", "covid-19-statistics.p.rapidapi.com")
            .addHeader("X-RapidAPI-Key", "54a04285f3msh775e05c8199e3d1p10dee3jsn18132b791694")
            .build();
            Response response = null;
            try {
                response = client.newCall(request).execute();
            } catch (IOException e) {
                logger.error("context",e.getMessage());
            }
        logger.info("Response is Successful: " , response.isSuccessful());
        String responseStr = response.body().string();
        logger.info("Response body: ", responseStr);
        ResponseDataArray result = convertToResponseData(responseStr);
        
        return result; 
    
    }

    public ResponseDataArray convertToResponseData(String response) {
        logger.info("converting to POJO");
        logger.info("JSONObject: " , response);



        GsonBuilder builder = new GsonBuilder(); 
        builder.setPrettyPrinting();
        Gson gson = builder.create(); 

        return gson.fromJson(response, ResponseDataArray.class); 
        

        
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
