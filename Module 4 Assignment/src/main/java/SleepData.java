public class SleepData {
    private String date;
    private String day;
    private String sleepStart;
    private String sleepEnd;
    private String sleepTotal;

    public SleepData(String date, String day, String sleepStart, String sleepEnd, String sleepTotal) {
        this.date = date;
        this.day = day;
        this.sleepStart = sleepStart;
        this.sleepEnd = sleepEnd;
        this.sleepTotal = sleepTotal;
    }

    public void addSleepData(){
        DatabaseHandler handler = new DatabaseHandler();
        // Change MEMBER
        String qu = "INSERT INTO MEMBER VALUES (" +
                "'" + date + "'," +
                "'" + day + "'," +
                "'" + sleepStart + "'," +
                "'" + sleepEnd + "'," +
                "'" + sleepTotal + "')";
        handler.execAction(qu);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getSleepStart() {
        return sleepStart;
    }

    public void setSleepStart(String sleepStart) {
        this.sleepStart = sleepStart;
    }

    public String getSleepEnd() {
        return sleepEnd;
    }

    public void setSleepEnd(String sleepEnd) {
        this.sleepEnd = sleepEnd;
    }

    public String getSleepTotal() {
        return sleepTotal;
    }

    public void setSleepTotal(String sleepTotal) {
        this.sleepTotal = sleepTotal;
    }

    @Override
    public String toString() {
        return "SleepData{" +
                "date='" + date + '\'' +
                ", day='" + day + '\'' +
                ", sleepStart='" + sleepStart + '\'' +
                ", sleepEnd='" + sleepEnd + '\'' +
                ", sleepTotal='" + sleepTotal + '\'' +
                '}';
    }
}
