import java.util.Map;

/**
 * An object holding the currency rates data received from the API
 */
public class RatesResponse {
    private String base; //currency to convert from
    private Map<String, Double> rates; // <"USD", 3.5">
    private String date; //updated at..

    public String getBase() {
        return base;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    /**
     * Return a specific rate from the data
     * @param target currency to convert to
     * @return daily rate value
     */
    public Double getRate(String target){
        return rates.get(target);
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "RatesResponse{" +
                "base='" + base + '\'' +
                ", rates=" + rates +
                ", date='" + date + '\'' +
                '}';
    }
}
