import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("happyorsad.txt");
        BufferedReader br = new BufferedReader(fr);

        String line = br.readLine(); // Reading the first line
        br.close();

        String happy = "happy";
        String sad = "sad";
        int happyCount = 0;
        int sadCount = 0;

        // Looping through each letter in the line
        for (int i = 0; i < line.length(); i++){
            // Removing case sensitivity with equalsIgnoreCase
            // Only checking substring if there is enough space for the substring

            // Checking if the substring of index + (index + word length) is equal to happy
            if (i <= line.length() - happy.length() && (line.substring(i, i+happy.length()).equalsIgnoreCase(happy))){
                happyCount ++;
            }
            // Checking if the substring of index + (index + word length) is equal to sad
            if (i <= line.length() - sad.length() && (line.substring(i, i+sad.length()).equalsIgnoreCase(sad))){
                sadCount ++;
            }
        }

        System.out.println("Happy count: " + happyCount);
        System.out.println("Sad count: " + sadCount);

        if (happyCount == 0 && sadCount == 0){
            System.out.println("None");
        } else if (happyCount == sadCount){
            System.out.println("Unsure");
        } else if (happyCount > sadCount){
            System.out.println("Happy");
        } else{
            System.out.println("Sad");
        }
    }
}