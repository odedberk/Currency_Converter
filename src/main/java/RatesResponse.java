import java.util.Map;

public class RatesResponse {
    private String base;
    private Map<String, Double> rates;
    private String date;

    public String getBase() {
        return base;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

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
