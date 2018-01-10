package git.client.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.mail.Address;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class PostDriverChecker {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		List<String> emailIt = getRecipientList();
		Iterator<String> emailIterator = emailIt.iterator();
		while (emailIterator.hasNext()) {
			System.out.println(emailIterator.next());
		}
	}

	public static List<Address> stubList() throws AddressException {
		List<Address> recipientsList = new ArrayList<Address>();
		recipientsList.add(new InternetAddress("praveenkumar_s@solartis.com"));
		recipientsList.add(new InternetAddress("priya_np@solartis.com"));
		recipientsList.add(new InternetAddress("devops@solartis.net"));
		recipientsList.add(new InternetAddress("arunraj_r@solartis.net"));
		return recipientsList;

	}

	public static List<String> getRecipientList() {

		List<String> emailList = null;
		try {

			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.84.250:5432/gitlabhq_production",
					"gitlab-psql", "welcome*1");
			System.out.println("DB connected");
			emailList = new ArrayList<String>();
			String query = "SELECT email FROM users WHERE ID IN (SELECT user_id FROM project_authorizations WHERE project_id=(SELECT ID FROM projects WHERE NAME='first_project'));";
			ResultSet resultSet = con.createStatement().executeQuery(query);
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1));
				emailList.add(resultSet.getString(1));
			}
			System.out.println("\n \n ########################## \n \n");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return emailList;
	}
}
