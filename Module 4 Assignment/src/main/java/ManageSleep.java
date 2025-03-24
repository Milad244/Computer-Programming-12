import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;

public class ManageSleep {

    /**
     * parses a csv file of SleepData into an ArrayList of SleepData using apache commons
     * @param fileName path to the csv file as a string
     * @return ArrayList of SleepData from the given file
     */
    public static ArrayList<SleepData> parseSleepData(String fileName) {
        ArrayList<SleepData> sleepData = new ArrayList<>();
        try {
            Reader in = new FileReader(fileName);
            Iterable<CSVRecord> records = CSVFormat.RFC4180.builder()
                    .setHeader()
                    .setSkipHeaderRecord(true)
                    .build()
                    .parse(in);

            for (CSVRecord record : records) {
                String date = record.get("Date");
                String day = record.get("Day");
                String sleepStart = record.get("Sleep Start");
                String sleepEnd = record.get("Sleep End");
                String sleepTotal = record.get("Sleep Total");
                sleepData.add(new SleepData(date, day, sleepStart, sleepEnd, sleepTotal));
            }

            return sleepData;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File not found");
            return null;
        }
    }

    /**
     * Takes an ArrayList of SleepData and inserts each day of SleepData into the database table
     * @param sleepData ArrayList of SleepData
     */
    public static void insertSleepDataToDB(ArrayList<SleepData> sleepData) {
        DatabaseHandler db = DatabaseHandler.getHandler();
        for (SleepData s : sleepData) {
            db.insertSleepData(s);
        }
    }

    /**
     * Creates a csv file from a given fileName and SleepData ArrayList
     * @param fileName name of the csv file to be created as a string
     * @param sleepData ArrayList of SleepData
     */
    public static void createSleepDataFile(String fileName, ArrayList<SleepData> sleepData) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            CSVPrinter csvPrinter = new CSVPrinter(bw, CSVFormat.DEFAULT.builder()
                    .setHeader("Date", "Day", "Sleep Start", "Sleep End", "Sleep Total")
                    .build());

            for (SleepData s : sleepData) {
                csvPrinter.printRecord(
                        s.getDate(),
                        s.getDay(),
                        s.getSleepStart(),
                        s.getSleepEnd(),
                        s.getSleepTotal()
                );
            }

            System.out.println("Wrote " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Cannot write " + fileName);
        }
    }
}