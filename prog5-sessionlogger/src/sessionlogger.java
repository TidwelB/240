package src;


import java.io.File;
import java.io.FileNotFoundException;
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




	void allSessions() throws FileNotFoundException {
		ArrayList<String> sessions = new ArrayList<String>();
		String filePath = "./data/chat_sessions/chat_statistics.csv";//file path
		File file = new File(filePath);
		Scanner s = new Scanner(file);			
		//Reading until we run out of lines
		int lineNum = 0;
		int chatNum = 0;
		int check = 0;
	
		System.out.println("Reading File .csv");
		while(s.hasNext())
		{
			sessions.add(s.next());
			System.out.println(s.next());
			lineNum++;
			//if(s.next().equalsIgnoreCase("of Session")) {
			//	check = 3;
			//	chatNum++;
			//}

	}
	System.out.println("Statistics: " + lineNum + " Chats: " + chatNum + check);
}
}