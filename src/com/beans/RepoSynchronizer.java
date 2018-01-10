package com.beans;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import git.client.entity.Commit;
import git.client.hooks.PushHookV2;

public class RepoSynchronizer {

	public static void synchronize(PushHookV2 pushHook) throws IOException {
		List<Commit> CommitList = pushHook.getCommits();
		Iterator<Commit> commitListIterator = CommitList.iterator();

		while (commitListIterator.hasNext()) {
			Commit commit = (Commit) commitListIterator.next();
			List<String> filesAdded = commit.getAdded();
			Iterator<String> filesIterator = filesAdded.iterator();
			while (filesIterator.hasNext()) {
				System.out.println(filesIterator.next());
			}

		}

		String[] uriArray = pushHook.getRef().split("/");
		String branchName = uriArray[uriArray.length - 1];
		System.out.println("RepoSynchronizer :: BranchName :: " + branchName);
		Runtime rt = Runtime.getRuntime();
		String cmdd = "cmd /c start D:\\Praveen\\GitLabHooks\\gitlabHA.bat " + branchName;

		Process proc = rt.exec(cmdd);
		BufferedReader input = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		String temp = "";
		while ((temp = input.readLine()) != null) {
			System.out.println("true");
			System.out.println(temp);
		}
		input.close();
	}

	public static void main(String args[]) throws IOException {
		/*
		 * Runtime rt = Runtime.getRuntime(); String branchName = "BranchOne";
		 * String cmdd =
		 * "cmd /c start D:\\Praveen\\GitLabHooks\\gitlabHA.bat "+branchName;
		 * Process proc = rt.exec(cmdd); BufferedReader input = new
		 * BufferedReader(new InputStreamReader(proc.getInputStream())); String
		 * temp = ""; while ((temp = input.readLine()) != null)
		 * System.out.println(temp);
		 * 
		 * input.close();
		 */

		String gname = "01_Starr_BordereauImport";
		String[] groupName = gname.split("_");
		System.out.println(groupName[0]);

	}
}
