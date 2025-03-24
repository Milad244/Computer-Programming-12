import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // RUN RESET ON ITS OWN
        //reset();
        //setup();
        //usage();
        show();
    }

    private static void reset() {
        DatabaseHandler db = DatabaseHandler.getHandler();
        db.deleteSleepTable();
    }

    private static void setup() {
        ArrayList<SleepData> sleepData = ManageSleep.parseSleepData("src/main/resources/Sleep Data.csv");
        System.out.println(sleepData);

        DatabaseHandler db = DatabaseHandler.getHandler();
        assert sleepData != null;
        ManageSleep.insertSleepDataToDB(sleepData);
        db.showSleepData();
    }

    private static void usage() {
        DatabaseHandler db = DatabaseHandler.getHandler();
        db.deleteSleepData(1);
        db.insertSleepData(new SleepData("2025-03-22", "Saturday", "3:30 AM", "10:30 AM", "7:00:00"));
        db.showSleepData();
        ManageSleep.createSleepDataFile("DB Sleep Data.csv", db.getSleepData());
    }

    private static void show() {
        DatabaseHandler db = DatabaseHandler.getHandler();
        db.showSleepData();
    }
}
