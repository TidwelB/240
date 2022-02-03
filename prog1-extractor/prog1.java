/*Created by Ben Tidwell*/


import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;


public class prog1 {
    

    public static void main(String[] args) throws IOException {

        System.out.println("What District Would You Like To Export Data From? *This chatbot is specific to District 11 at this time*");
        String input;
        Scanner sc = new Scanner(System.in);
        input = sc.next();

        if (input.equalsIgnoreCase("Eleven") || input.equalsIgnoreCase("11")) {
            System.out.println("Printing Data for District Eleven...\n");
        }
        else
        System.out.println("User input does not dictate District Eleven.\n System Defaulting to District Eleven. \nPrinting Data for District Eleven...\n");

        URL url = new URL("https://www.scstatehouse.gov/member.php?code=0993465790");

        URLConnection con = url.openConnection();
        InputStream inStream =con.getInputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));

        String line = null;
        ArrayList<String> output = new ArrayList<String>();
        int linecount = 0;

        while ((line = reader.readLine()) != null) {
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
            output.add(line);
            
        }
        for(int i = 9; i < 10; i++){
            System.out.println(output.get(i) );
        }
        for(int i = 421; i < output.size(); i++){
        System.out.println(output.get(i) );
        }
        PrintStream out = new PrintStream(new File("output.txt"));
        System.setOut(out);
        for(int i = 9; i < 10; i++){
            System.out.println(output.get(i) );
            linecount++;
        }
        for(int i = 421; i < output.size(); i++){
        System.out.println(output.get(i) );
        linecount++;
        }
        System.out.println("Number of Lines Exported: " + linecount);
   
}
}

