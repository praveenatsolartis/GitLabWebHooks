package com.beans;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class PropertyReaderSingleton {

	private Properties properties = new Properties();

	@PostConstruct
	public void loadProperties() {

		FileInputStream fileInputStream = null;
		try {
			try {
				fileInputStream = new FileInputStream(
						"D:\\Praveen\\GitLabHooks\\Property\\GitLabConfiguration.properties");
			} catch (FileNotFoundException fileNotFoundException) {
				System.out.println(fileNotFoundException.getMessage());
			}
			if (fileInputStream != null) {
				this.properties.load(fileInputStream);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (fileInputStream != null) {
					fileInputStream.close();
				}
			} catch (Exception exception) {
				System.out.println(exception.getMessage());
			}
		}
	}

	public String getValue(String key) {
		String value = "";
		try {
			value = this.properties.getProperty(key);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return value;
	}

	public void reloadProperty() {
		loadProperties();
	}
}
