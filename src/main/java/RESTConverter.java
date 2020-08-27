import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * A Converter using the REST API for receiving daily exchange rates
 */
public class RESTConverter implements Converter {
    private String baseURL;

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    /**
     * Send a GET request to receive the data from the server
     * @param base currency to convert from
     * @return
     */
    public RatesResponse getRates(String base) {
        String rates = "";
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(baseURL+base);
            HttpResponse response = client.execute(request);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            rates = rd.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Gson().fromJson(rates, RatesResponse.class);
    }
}

