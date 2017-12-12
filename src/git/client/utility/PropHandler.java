package git.client.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropHandler {

	@SuppressWarnings("null")
	public static void main(String[] args) throws IOException {
		InputStream is = null;
        Properties prop = null;
        	prop = new Properties();
        is = new FileInputStream(new File("D:\\Praveen\\GitLabHooks\\Property\\GitLabConfiguration.properties"));
		prop.load(is);
		is.close();
		
		System.out.println(prop.getProperty("TEAM_SIZE"));;
		
		
		
	}

}
