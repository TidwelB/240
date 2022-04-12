package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class format {
    ArrayList<String> outline = new ArrayList<String>();

    void getConnection(String requestDistrict) {
        
        //checks user intended district. Only 11 is available
        if (requestDistrict.contains("eleven") || requestDistrict.contains("11") || requestDistrict.equals("11")) {
            System.out.println("Collecting Data for District Eleven...\n");
        }
        else {
            System.out.println("User input does not dictate District Eleven.\n System Defaulting to District Eleven.\n");
            System.out.println("Collecting Data for District Eleven...\n");
        }
        }
    
   
    ArrayList<String> getformating () throws IOException {

        //establish connection
        URL url = new URL("https://www.scstatehouse.gov/member.php?code=0993465790");
        URLConnection con = url.openConnection();
        InputStream inStream = con.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));
        ArrayList<String> output = new ArrayList<String>();
        String line;
        while ((line = reader.readLine()) != null) {
            //formats all lines appropriately
    line = line.replaceAll("<[^>]*>", "");
    line = line.replaceAll("Senator Josh Kimbrell", "\t\t\tSenator Josh Kimbrell");
    line = line.replaceAll("Send message to Senator Kimbrell", "Send message to Senator Kimbrell Through 'https://www.scstatehouse.gov/email.php?T=M&C=993465790'");
    line = line.replaceAll("&gt;", ">");
    line = line.replaceAll("&quot;", "\"");
    line = line.replaceAll("&nbsp;", "\t");
    line = line.replaceAll("NoSearch Session:", "\n \t Search Session:");
    line = line.replaceAll("Aviation", "\tAviation");
    line = line.replaceAll("Agriculture", "\tAgriculture");
    line = line.replaceAll("SpringsBorn", "Springs\n\tBorn");
    line = line.replaceAll("SpartanburgSon", "Spartanburg\n\tSon");
    line = line.replaceAll("KimbrellGraduated", "Kimbrell\n\tGraduated");
    line = line.replaceAll("2007Garner", "2007\n\tGarner");
    line = line.replaceAll("BusinessDecember", "Business\n\tDecember");
    line = line.replaceAll("LucianChairman", "Lucian\n\tChairman");
    line = line.replaceAll("2019-", "2019-\n\t");
    line = line.replaceAll("2017-", "2017-\n\t");
    line = line.replaceAll("2017-18VC", "2017-18\n\tVC");
    line = line.replaceAll("Voting RecordSearch Session:", "Voting Record\n\tSearch Session:");
    line = line.replaceAll("Primary Sponsor:", "\t Primary Sponsor:");
    line = line.replaceAll("ForestryJudiciary", "Forestry\n\tJudiciary\n \n");
    line = line.replaceAll("ServicesFish", "Services\n\tFish");
    line = line.replaceAll("InsuranceFamily", "Insurance\n\tFamily");
    line = line.replaceAll("ResourcesBanking", "Resources\n\tBanking");
    line = line.replaceAll("CharterResiding", "Charter\n\tResiding");
    line = line.replaceAll("- Map", "");
    output.add(line);
        }
        return output;
    }
//only returns name
    ArrayList<String> getName(ArrayList<String> output, String userRequest) {
        outline.add("User Request: " + userRequest + "...\n");
        for(int i = 421; i < 425; i++){
            System.out.println(output.get(i) );
            outline.add(output.get(i));
            }
            return output;
    }
//only returns contact info
    ArrayList<String> getContactInformation(ArrayList<String> output, String userRequest) {
        outline.add("User Request: " + userRequest + "...\n");
        if(userRequest.contains("name")) {

            for(int i = 421; i < 425; i++){
        System.out.println(output.get(i) );
        outline.add(output.get(i));
        }
    
    }
    else {
        for(int i = 10; i < 11; i++){
            System.out.println(output.get(i) );
            outline.add(output.get(i));
        }
         for(int i = 421; i < 441; i++){
        System.out.println(output.get(i) );
        outline.add(output.get(i));
    }
    }
    return output;

    }
//returns personal information
    ArrayList<String> getPersonalInformation(ArrayList<String> output, String userRequest) {
        outline.add("User Request: " + userRequest + "...\n");
        for(int i = 447; i < 451; i++){
            System.out.println(output.get(i) );
            outline.add(output.get(i));
            }
            return output;
    }
//returns committee assignments
    ArrayList<String>getCommitteeAssignments(ArrayList<String> output, String userRequest) {
        outline.add("User Request: " + userRequest + "...\n");
        for(int i = 451; i < 454; i++){
            System.out.println(output.get(i) );
            outline.add(output.get(i));
            }
            return output;
    }
//returns sponsored bills
    ArrayList<String>getSponsoredBills(ArrayList<String> output, String userRequest) {
        outline.add("User Request: " + userRequest + "...\n");
        System.out.println('\n');
        for(int i = 454; i < 456; i++){
            System.out.println(output.get(i) );
            outline.add(output.get(i));
            }
            System.out.println('\n');
            outline.add("\n");
            return output;
    }
//returns voting records
    ArrayList<String>getVotingRecord(ArrayList<String> output, String userRequest) {
        System.out.println('\n');
        outline.add("User Request: " + userRequest + "...\n");
        for(int i = 456; i < 458; i++){
            System.out.println(output.get(i) );
            outline.add(output.get(i));
            }
            return output;
    }
//returns service records
    ArrayList<String>getServiceRecord(ArrayList<String> output, String userRequest) {
        outline.add("User Request: " + userRequest + "...\n");
        System.out.println("None Listed");
        outline.add("None Listed");
            return output;
    }
//returns all data on the page
    ArrayList<String>getAll(ArrayList<String> output, String userRequest) {
        outline.add("User Request: " + userRequest + "...\n");
        for(int i = 9; i < 10; i++){
            System.out.println(output.get(i) );
            outline.add(output.get(i));
        }
        for(int i = 421; i < output.size(); i++){
        System.out.println(output.get(i) );
        outline.add(output.get(i));
        }
        return outline;
        
    }

    ArrayList<String>getParty(ArrayList<String> output, String userRequest) {
        outline.add("User Request: " + userRequest + "...\n");
        for(int i = 424; i < 428; i++){
        System.out.println(output.get(i) );
        outline.add(output.get(i));
        }
        return outline;
    }

    ArrayList<String>getDistrict(ArrayList<String> output, String userRequest) {
        outline.add("User Request: " + userRequest + "...\n");
        for(int i = 428; i < 429; i++){
        System.out.println(output.get(i) );
        outline.add(output.get(i));
        }
        return outline;
    }

    ArrayList<String>getOptions(ArrayList<String> output, String userRequest) {
        outline.add("User Request: " + userRequest + "...\n");
        System.out.println("Key terms: Contact Information, Personal Information, Committee Assignments, Sponsored Bills, Voting Records, Service Record, All\n");
        outline.add("Key terms: Contact Information, Personal Information, Committee Assignments, Sponsored Bills, Voting Records, Service Record, All\n");
        
        return outline;
    }
//responses to pleseantries
    void Greeting(String userRequest) {
        outline.add("User Request: " + userRequest + "...\n");
        if (userRequest.contains("hello") || userRequest.equals("hi") || userRequest.contains("hi there")){
            outline.add("Hello there, feel free to inquire about your senator.\n");
            System.out.println("Hello there, feel free to inquire about your senator. \n");
        }
        else if (userRequest.contains("how are you")) {
            outline.add("I'm well, please enter a search about the senator.\n");
            System.out.println("I'm well, please enter a search about the senator.\n");
        } 
        else System.out.println("Enter a key search for your senator or type 'Quit' or 'q' to end");
    }

    void addLine(String string) {
        outline.add(string);
    }

    

    void Print() throws FileNotFoundException {
        PrintStream dataout = new PrintStream(new File("data/output.txt"));
        System.setOut(dataout);
        outline.add("Quit... \n");
        outline.add("End of Session\n");
        outline.add("Goodbye");
    for(int i = 0; i < outline.size(); i++){
        System.out.println(outline.get(i));

    }
    System.out.println("End of Session\n");
    dataout.close();
    }

    ArrayList<String> getOutline() {

        return outline;
    }
}
