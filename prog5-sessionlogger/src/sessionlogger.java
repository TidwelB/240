package src;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
public class sessionlogger
{

void summarySession(int sessionNum) throws FileNotFoundException {
	String filePath = "./data/chat_sessions/chat_statistics.csv";//file path
	String line = "";
	int lineNum = 0;
	int chatNum = 0;
	int queryNum = 0;
	try {
		BufferedReader s = new BufferedReader(new FileReader(filePath));
		System.out.println("Reading File .csv");
		while((line = s.readLine()) != null) {
			//System.out.print(line);
			lineNum++;
			if (line.contains("Session lasted: ")) {
				System.out.print(line);
			}
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




void showSession(int sessionNum) throws FileNotFoundException {
	String filePath = "./data/chat_sessions/chat_statistics.csv";//file path
	String line = "";
	int lineNum = 0;
	int chatNum = 0;
	int queryNum = 0;
	int semaphore = 0;
	int sessionTime = 0;
	try {
		BufferedReader s = new BufferedReader(new FileReader(filePath));
		System.out.println("Reading File .csv");
		while((line = s.readLine()) != null) {
			lineNum++;
			if (line.equals("End of Session")) {
				chatNum++;
			}
			if((chatNum+1) == sessionNum && !line.equals("End of Session")) {
				System.out.print(line + "\n");
			if (line.contains("User Request:")) {
				queryNum++;
			}
			if (semaphore == 1) {
				//System.out.println("Semaphore checked... printing session time..." + sessionTime);
				// if (line.matches("[0-999]" + "\n")) {
					try{
						sessionTime += Integer.parseInt(line);
					}
					catch (NumberFormatException ex){
						ex.printStackTrace();
					}
					semaphore = 0;
				}
				if (line.equals("Session Logging Out")) {
					semaphore = 1;
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
	if (sessionNum > chatNum) {
		System.out.println("ERROR: there are only " + chatNum + " valid chat sessions. Please choose a valid number.");
	}
	else {
	System.out.println("Chat " + sessionNum + " has user asking " +queryNum + " times and system respond " +(queryNum + 1)+ " times. Total duration is "+sessionTime+" seconds.");
	}
}




	void allSessions() throws FileNotFoundException {
		ArrayList<String> sessions = new ArrayList<String>();
		String filePath = "./data/chat_sessions/chat_statistics.csv";//file path
		String line = "";
		int lineNum = 0;
		int chatNum = 0;
		int queryNum = 0;
		int sessionTime = 0;
		int semaphore = 0;
		try {
			BufferedReader s = new BufferedReader(new FileReader(filePath));
			System.out.println("Reading File .csv");
			while((line = s.readLine()) != null) {
				//System.out.print(line);
				lineNum++;
				if (semaphore == 1) {
				//System.out.println("Semaphore checked... printing session time..." + sessionTime);
				// if (line.matches("[0-999]" + "\n")) {
					try{
						sessionTime += Integer.parseInt(line);
					}
					catch (NumberFormatException ex){
						ex.printStackTrace();
					}
					semaphore = 0;
				}
				if (line.equals("End of Session")) {
					chatNum++;
				}
				if (line.contains("User Request:")) {
					queryNum++;
				}
				if (line.equals("Session Logging Out")) {
					semaphore = 1;
				}

			}
			System.out.println("There are " + chatNum + " chats to date with user asking " + queryNum + " times and system responding " + (queryNum+1) +" times. Total duration is " +sessionTime+" seconds");
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		//Reading until we run out of lines
	
		
	//System.out.println("Statistics: " + lineNum + " Chats: " + chatNum);
	//System.out.println("There are " + chatNum + " chats to date with user asking " + queryNum + " times and system responding " + (queryNum+1) +" times. Total duration is 456 seconds");
}
	
	
	
	static void appendToCSV(Path path, List<String> list)
			throws IOException {

        // Java 7?
        /*Files.write(path, list, StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);*/

        // Java 8, default utf_8
        Files.write(path, list,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);

    }
	
	
}