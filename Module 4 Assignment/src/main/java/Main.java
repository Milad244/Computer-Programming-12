import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ManageSleep manageSleep = new ManageSleep();
        manageSleep.parseSleepData("src/main/resources/Sleep Data.csv");
        ArrayList<SleepData> sleepData = manageSleep.getSleepData();
        System.out.println(sleepData);
        //SleepData first = sleepData.getFirst();
        //DatabaseHandler.getHandler().insertSleepData(0, first.getDate(), first.getDay(), first.getSleepStart(), first.getSleepEnd(), first.getSleepTotal());
        DatabaseHandler.getHandler().showMembers();
    }
}
