import sun.awt.image.ImageWatched;

import java.io.*;
import java.util.*;

public class Application {
    private static AppConfigurations configs = AppConfigurations.getInstance();

    public static void main(String[] args) {
        try {
            File file = new File(args[0]); //arg[0] - text file - {"base currency \n target currency \n amounts"}
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String base = reader.readLine();
            String target = reader.readLine();
            List<Double> amounts = new LinkedList<Double>();
            List<Double> results = new LinkedList<Double>();

            String st = "";
            while ((st=reader.readLine()) != null)
                amounts.add(Double.valueOf(st));

            Converter converter = configs.getConverter();
            RatesResponse response = converter.getRates(base);
            double rate = response.getRate(target);
            for (Double number : amounts)
                results.add(number*rate);

            for (Double result : results)
                System.out.println(String.format("%.2f",result));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
