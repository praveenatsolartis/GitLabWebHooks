package git.client.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GitLabStringHandler {

	public static void main(String[] args) throws IOException {
		String refURI = "refs/heads/devops";
		String[] refURIArray = refURI.split("/");
		System.out.println(refURIArray[refURIArray.length-1]);
		
		Runtime rt = Runtime.getRuntime();
		String cmdd = "cmd /c start D:\\Praveen\\GitLabHooks\\gitlabHA.bat BranchOne";
		Process proc = rt.exec(cmdd);

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		String s = null;
		while((s=bufferedReader.readLine())!= null){
			System.out.println(s);
		}
		bufferedReader.close();
		
	}

}
