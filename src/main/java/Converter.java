public interface Converter {
    RatesResponse getRates(String base);
    void setBaseURL(String baseURL);
}
