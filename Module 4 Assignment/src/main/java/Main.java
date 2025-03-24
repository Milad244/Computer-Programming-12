import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ManageSleep manageSleep = new ManageSleep();
        manageSleep.parseSleepData("src/main/resources/Sleep Data.csv");
        ArrayList<SleepData> sleepData = manageSleep.getSleepData();
        System.out.println(sleepData);

        DatabaseHandler db = DatabaseHandler.getHandler();
        SleepData first = sleepData.getFirst();
        //db.insertSleepData(first.getDate(), first.getDay(), first.getSleepStart(), first.getSleepEnd(), first.getSleepTotal());
        //db.deleteSleepTable();
        db.showSleepData();
        //db.deleteSleepData(1);
        //db.showSleepData();
    }
}
