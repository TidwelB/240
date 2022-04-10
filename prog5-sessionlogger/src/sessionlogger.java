package src;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
public class sessionlogger
{
	// void read()
	// {
	// 	try
	// 	{
	// 		//List< List<String> > data = new ArrayList<>();//list of lists to store data
	// 		String filePath = "./data/chat_sessions/chat_statistics.csv";//file path
	// 		File file = new File(filePath);
	// 		Scanner s = new Scanner(file);			
	// 		//Reading until we run out of lines
    //         int chatNum = 0;
    //         System.out.println("Reading File .csv");
	// 		while(s.hasNextLine())
	// 		{
	// 			ArrayList<String> lineData = (ArrayList<String>) Arrays.asList(s.nextLine().split("End of Session"));//splitting lines
	// 			//data.add(lineData);
    //             chatNum++;
	// 		}			
	// 		//printing the fetched data
	// 		for(List<String> list : data)
	// 		{
	// 			for(String str : list)
	// 				System.out.print(str + " ");
	// 			System.out.println();
	// 		}
    //         System.out.println("Chat: " + chatNum);
	// 		s.close();
	// 	}
	// 	catch(Exception e)
	// 	{
	// 		System.out.print(e);
	// 	}
	// }


void summarySession(int sessionNum) throws FileNotFoundException {
	ArrayList<String> sessions = new ArrayList<String>();
	String filePath = "./data/chat_sessions/chat_statistics.csv";//file path
	String line = "";
	int lineNum = 0;
	int chatNum = 0;
	int queryNum = 0;
	try {
		BufferedReader s = new BufferedReader(new FileReader(filePath));
		System.out.println("Reading File .csv");
		while((line = s.readLine()) != null) {
			System.out.print(line);
			lineNum++;
			if (line.equals("End of Session")) {
				chatNum++;
			}
			if((chatNum+1) == sessionNum) {
			if (line.contains("User Request:")) {
				queryNum++;
			}
		}

		}
	}
	catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	catch (IOException e) {
		e.printStackTrace();
	}
	if (queryNum == 0) {
		System.out.println("Session " +sessionNum+ "Does not exist");
	}
	else {
	System.out.println("Chat " + sessionNum + " has user asking " +queryNum + " times and system respond " +(queryNum + 1)+ " times. Total duration is 4 seconds.");
	}
}




	void allSessions() throws FileNotFoundException {
		ArrayList<String> sessions = new ArrayList<String>();
		String filePath = "./data/chat_sessions/chat_statistics.csv";//file path
		String line = "";
		int lineNum = 0;
		int chatNum = 0;
		int queryNum = 0;
		try {
			BufferedReader s = new BufferedReader(new FileReader(filePath));
			System.out.println("Reading File .csv");
			while((line = s.readLine()) != null) {
				System.out.print(line);
				lineNum++;
				if (line.equals("End of Session")) {
					chatNum++;
				}
				if (line.contains("User Request:")) {
					queryNum++;
				}

			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		//Reading until we run out of lines
	
		
	//System.out.println("Statistics: " + lineNum + " Chats: " + chatNum);
	System.out.println("There are " + chatNum + " chats to date with user asking " + queryNum + " times and system responding " + (queryNum+1) +" times. Total duration is 456 seconds");
}
}