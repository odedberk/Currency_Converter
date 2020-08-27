/**
 * An interface used to receive the daily rates of all currencies.
 */
public interface Converter {
    /**
     * Get the daily updated rates from the API
     * @param base currency to convert from
     * @return a RatesResponse object containing all the data
     */
    RatesResponse getRates(String base);

    /**
     * @param baseURL - base address for the API
     */
    void setBaseURL(String baseURL);
}
