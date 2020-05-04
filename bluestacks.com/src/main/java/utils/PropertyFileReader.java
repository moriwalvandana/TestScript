package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileReader {
	
private Properties property=new Properties();
	
	public PropertyFileReader(String propertyFilePath) throws Exception {
	
		FileInputStream fis=new FileInputStream(propertyFilePath);
		property.load(fis);

	}

	public String getValue(String key) {
		String value=null;
		value=(String) property.get(key);
		return value;
		
	}

}
