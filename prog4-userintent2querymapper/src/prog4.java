package src;

/*Created by Ben Tidwell*/

import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;


public class prog4 {
    

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

        String[] options = {"no entry","party", "political", "name", "who", "contact information", "contact", "phone", "address", "about", "personal", "how long", "age", "live", "committee assignments", "committee", "assignments", "sponsored bills", "bills", "voting record", "service", "options", "information", "quit", "q", "hi", "hello", "how are you", "old"};
        //while user intends to request
        int loop = 1;
        String userRequest = "no entry";
        String unEdited = "no entry";
        //String temp = "no entry";
        if (loop == 1) {
            loop = 0;
            System.out.println ("Welcome to the District 11 Data search terminal\nEnter a search about your senator");
            userRequest = sc.nextLine();
            unEdited = userRequest;
            loop = 1;
        }

            while (loop == 1) {
                
                userRequest = sc.nextLine();
                unEdited = userRequest;
                outline.add("User Request..." + userRequest + "\n");
                userRequest = userRequest.toLowerCase();
                userRequest = userRequest.trim();
                userRequest = userRequest.replaceAll("\\p{Punct}", "");

                double value = 0.0;
                int match = 0;

                String keyWord = " ";
                
                String[] search = userRequest.split(" ");

            for(int i = 0; i < options.length ; i++) {

                for(int j = 0; j < search.length; j++) {

                if (compare.similarity(search[j], options[i]) > value) {
                    value = compare.similarity(search[j], options[i]);
                    match = i;
                    keyWord = search[j];
                }
            }
                
                
            }
            if (value < .70) {
                System.out.println("HIGHEST MATCH AT: " + value + " FOR " + keyWord + " TO " + options[match]);
                System.out.println("Your search wasn't close to any key words. Please rephrase or type 'options' for some ideas");
                f.addLine("Your search wasn't close to any key words. Please rephrase or type 'options' for some ideas");
                userRequest = unEdited;
            }
            else if ( value <= 1.0 && value >= .70) {
                f.addLine("HIGHEST MATCH AT: " + value + " FOR " + keyWord + " TO " + options[match]);
                System.out.println("HIGHEST MATCH AT: " + value + " FOR " + keyWord + " TO " + options[match]);
                userRequest = options[match];
            }
            
            
                

                //conditions for results
                if ((userRequest.equalsIgnoreCase("Quit")) || userRequest.equalsIgnoreCase("q")) {
                    loop = 0;

                }
                else if ((userRequest.contains("party")) || (userRequest.contains("political"))) {
                    f.getParty(output, unEdited);
                    System.out.println("Enter another key search for your senator or type 'Quit' or 'q' to end");
                }
                else if ((userRequest.contains("name")) || (userRequest.contains("who"))) {
                    f.getName(output, unEdited);
                    System.out.println("Enter another key search for your senator or type 'Quit' or 'q' to end");
                        } 
                else if ((userRequest.contains("contact information")) || (userRequest.contains("contact")) || userRequest.contains("phone") || userRequest.contains("address") || userRequest.contains("information")) {
                   f.getContactInformation(output, unEdited); 
                   System.out.println("Enter another key search for your senator or type 'Quit' or 'q' to end");     
            }
            else if ((userRequest.contains("personal information")) ||  userRequest.contains("about") || userRequest.contains("personal") || userRequest.contains("age") || userRequest.contains("old") || userRequest.contains("how long") || userRequest.contains("live") || userRequest.contains("information")) {
                f.getPersonalInformation(output, unEdited);  
                System.out.println("Enter another key search for your senator or type 'Quit' or 'q' to end"); 
            }
            else if ((userRequest.contains("committee assignments")) || userRequest.contains("assignments") || userRequest.contains("committee")) {
                f.getCommitteeAssignments(output, unEdited);
                System.out.println("Enter another key search for your senator or type 'Quit' or 'q' to end");
            }
            else if ((userRequest.contains("sponsored bills")) || userRequest.contains("bills")) {
               f.getSponsoredBills(output, unEdited);
               System.out.println("Enter another key search for your senator or type 'Quit' or 'q' to end");
            }
            else if ((userRequest.contains("voting record")) || userRequest.contains("voting")) {
                f.getVotingRecord(output, unEdited);
                System.out.println("Enter another key search for your senator or type 'Quit' or 'q' to end");
            }
            else if ((userRequest.contains("service in public office")) || userRequest.contains("service")) {
                f.getServiceRecord(output, unEdited);
                System.out.println("Enter another key search for your senator or type 'Quit' or 'q' to end");
            }
            else if ((userRequest.contains("all")) || userRequest.contains("everything")) {
                f.getAll(output, unEdited);
                System.out.println("Enter another key search for your senator or type 'Quit' or 'q' to end");
            }
            else if ((userRequest.contains("key search")) || userRequest.contains("options") || userRequest.contains("what")) {
                f.getOptions(output, unEdited);
                System.out.println("Enter another key search for your senator or type 'Quit' or 'q' to end");
            }
            else if (loop == 1) {
                f.Greeting(unEdited);
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

