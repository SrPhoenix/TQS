package tqs.hw1.api;
import java.io.IOException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


@Service
public class CovidServiceImp implements CovidService{
    OkHttpClient client = new OkHttpClient();
    
    @Autowired
    Cache cache;

    public JSONObject getData(CovidData data) throws IOException{
        JSONObject response = cache.get(data);
        if(response==null){
            response = request(data.getDate(),data.getRegion_name(),data.getCountry(),data.getCity_name()); 
            cache.put(data,response);
            return response;
        }
        else
            return response;
        
    }

    public JSONObject request(String date, String region, String country, String city) throws IOException{
        StringBuilder url = new StringBuilder("https://covid-19-statistics.p.rapidapi.com/reports?");
        if (!date.equals(""))
            url.append("date="+date);
        else if (!region.equals(""))
            url.append("&region_name="+region);
        else if (!country.equals(""))
            url.append("&iso="+country);
        else if (!city.equals(""))
            url.append("&city_name="+city);
        System.out.println(url);
        Request request = new Request.Builder()
            .url(url.toString())
            .get()
            .addHeader("X-RapidAPI-Host", "covid-19-statistics.p.rapidapi.com")
            .addHeader("X-RapidAPI-Key", "54a04285f3msh775e05c8199e3d1p10dee3jsn18132b791694")
            .build();

        Response response = client.newCall(request).execute();
        System.out.println(">.< " + response.isSuccessful());
        return new JSONObject(response.body().string());
    }
}
