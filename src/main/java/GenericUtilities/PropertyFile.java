package GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {
	public String AmazonUrlFetch(String PropertyKey) throws IOException {
		FileInputStream fis = new FileInputStream(
				"E:\\Selenium\\Eclipsse\\Inputs\\Properties Input\\19-04\\AmazonInput.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String URL = prop.getProperty(PropertyKey);
		return URL;
	}

}
