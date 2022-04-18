package tqs.hw1.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.json.JSONObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@SpringBootTest
class ApiTest {
	@Test
    void apiTest( ) throws Exception {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
            .url("https://coronavirus-smartable.p.rapidapi.com/stats/v1/US/")
            .get()
            .addHeader("X-RapidAPI-Host", "coronavirus-smartable.p.rapidapi.com")
            .addHeader("X-RapidAPI-Key", "54a04285f3msh775e05c8199e3d1p10dee3jsn18132b791694")
            .build();

        Response response = client.newCall(request).execute();

        JSONObject data = new JSONObject(response);
        System.out.println(">.< " + data.toString());
        //assertTrue(data.getBoolean("successful"));
    }

}
