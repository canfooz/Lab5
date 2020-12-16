/**
 * @autor Chekmarev Andrey
 * 3rd year, 7th group
 * @version 1.0
 * Injector class
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

public class Injector {
    /** Properties field */
    private Properties properties;

    /**
     * Constructor
     * Gets properties from files
     */
    public Injector() {
        this.properties = new Properties();
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream ("C:/Users/super/Desktop/RSP/Lab5/src/main/resources/properties.properties");
            properties.load(inputStream);
        } catch(IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * Inject method
     * @param object - some object
     * Finds all fields marked with the @AutoInjectable annotation
     * Places the object specified in the properties to the fields
     * @return object
     */
    public <T> T inject (T object) throws Exception {


        for (Field field : object.getClass().getDeclaredFields()
        ) {
            if (field.getAnnotation(AutoInjectable.class) != null) {
                field.setAccessible(true);
                field.set(object, Class.forName(properties.getProperty(field.toString().split(" ")[1])).getDeclaredConstructor().newInstance());
            }
        }
        return object;
    }

}
