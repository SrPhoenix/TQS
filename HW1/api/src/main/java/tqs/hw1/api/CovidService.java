package tqs.hw1.api;
import java.io.IOException;
import org.json.JSONObject;



public interface CovidService {
    public JSONObject getData(CovidData data) throws IOException;
}
