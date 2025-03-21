import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class ManageSleep {
    private final ArrayList<SleepData> sleepData;

    public ManageSleep() {
        sleepData = new ArrayList<>();
    }

    public void parseSleepData(String fileName) {
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
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File not found");
        }
    }

    public ArrayList<SleepData> getSleepData() {
        return sleepData;
    }
}
