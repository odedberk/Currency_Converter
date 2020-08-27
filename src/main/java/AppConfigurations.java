import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Singleton class.
 * Takes care of all of the configurations needed for the application to run.
 * Creates the correct instances for the dependency injections based on the configurations file.
 */
public class AppConfigurations {

    private static AppConfigurations instance;
    private Properties properties;

    private AppConfigurations() {
        Gson gson = new Gson();
        File f = new File("src/main/resources/properties.json");
        try {
            properties = gson.fromJson(new FileReader(f), Properties.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static AppConfigurations getInstance() {
        if (instance==null)
            instance=new AppConfigurations();
        return instance;
    }

    public Converter getConverter() {
        try {
            Converter converter = (Converter) Class.forName(properties.getConverterClass()).newInstance();
            converter.setBaseURL(properties.getApiAddress());
            return converter;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
