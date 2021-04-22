package main.java.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ReadProperties {
    private static FileInputStream fileInputStream;
    private static Properties properties;
        static {
            try {
                fileInputStream = new FileInputStream("src\\main\\resources\\test.properties");
                properties = new Properties();
                properties.load(fileInputStream);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if( fileInputStream != null )
                    try {
                        fileInputStream.close();
                    } catch ( IOException e ) {
                        e.printStackTrace();
                    }
            }
        }
        public static String getProperty(String key) {
            return properties.getProperty(key);
        }
}

