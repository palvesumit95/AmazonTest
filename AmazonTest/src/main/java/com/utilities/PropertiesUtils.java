package com.utilities;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {

	public static FileInputStream fis = null;
	public static Properties prop = null;

	public static String readProperty(String key) throws IOException {

		fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
		prop = new Properties();

		prop.load(fis);

		return prop.getProperty(key);







	}




}
