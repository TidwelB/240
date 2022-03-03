package src;

/*Created by Ben Tidwell*/

import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;


public class prog3 {
    

    public static void main(String[] args) throws IOException {

        System.out.println("What District Would You Like To Export Data From? *This chatbot is specific to 'District Eleven' at this time*");
        String input;
        Scanner sc = new Scanner(System.in);
        input = sc.next();
        
//instance of the format class
        format f = new format();

//establishes connection and downloads webpage
        f.getConnection(input);
        ArrayList<String> output = f.getformating();
        ArrayList<String> outline = new ArrayList<String>();

        //while user intends to request
        int loop = 1;
            while (loop == 1) {
                
                String userRequest = sc.nextLine();
                outline.add("User Request..." + userRequest + "\n");
                userRequest = userRequest.toLowerCase();

                //conditions for results
                if ((userRequest.equalsIgnoreCase("Quit")) || userRequest.equalsIgnoreCase("q")) {
                    loop = 0;

                }
                else if ((userRequest.contains("party")) || (userRequest.contains("political"))) {
                    f.getParty(output, userRequest);
                    System.out.println("Enter another key search for your senator or type 'Quit' or 'q' to end");
                }
                else if ((userRequest.contains("name")) || (userRequest.contains("who"))) {
                    f.getName(output, userRequest);
                    System.out.println("Enter another key search for your senator or type 'Quit' or 'q' to end");
                        } 
                else if ((userRequest.contains("contact information")) || (userRequest.contains("contact")) || userRequest.contains("phone") || userRequest.contains("address")) {
                   f.getContactInformation(output, userRequest); 
                   System.out.println("Enter another key search for your senator or type 'Quit' or 'q' to end");     
            }
            else if ((userRequest.contains("personal information")) ||  userRequest.contains("about") || userRequest.contains("personal") || userRequest.contains("age") || userRequest.contains("old") || userRequest.contains("how long") || userRequest.contains("live")) {
                f.getPersonalInformation(output, userRequest);  
                System.out.println("Enter another key search for your senator or type 'Quit' or 'q' to end"); 
            }
            else if ((userRequest.contains("committee assignments")) || userRequest.contains("assignments") || userRequest.contains("committee")) {
                f.getCommitteeAssignments(output, userRequest);
                System.out.println("Enter another key search for your senator or type 'Quit' or 'q' to end");
            }
            else if ((userRequest.contains("sponsored bills")) || userRequest.contains("bills")) {
               f.getSponsoredBills(output, userRequest);
               System.out.println("Enter another key search for your senator or type 'Quit' or 'q' to end");
            }
            else if ((userRequest.contains("voting record")) || userRequest.contains("voting")) {
                f.getVotingRecord(output, userRequest);
                System.out.println("Enter another key search for your senator or type 'Quit' or 'q' to end");
            }
            else if ((userRequest.contains("service in public office")) || userRequest.contains("service")) {
                f.getServiceRecord(output, userRequest);
                System.out.println("Enter another key search for your senator or type 'Quit' or 'q' to end");
            }
            else if ((userRequest.contains("all")) || userRequest.contains("everything")) {
                f.getAll(output, userRequest);
                System.out.println("Enter another key search for your senator or type 'Quit' or 'q' to end");
            }
            else if ((userRequest.contains("key search")) || userRequest.contains("options") || userRequest.contains("what")) {
                f.getOptions(output, userRequest);
                System.out.println("Enter another key search for your senator or type 'Quit' or 'q' to end");
            }
            else if (loop == 1) {
                f.Greeting(userRequest);
            }
         
}
//program end and print data
System.out.println("Goodbye");
f.Print();

//doc/output was only used for testing. data file has intended output
        PrintStream docout = new PrintStream(new File("doc/output.txt"));
        System.setOut(docout);
    for(int i = 0; i < outline.size(); i++){
        System.out.println(outline.get(i));
    }
    
}
    }

