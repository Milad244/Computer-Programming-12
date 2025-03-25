public class SleepData {
    private String date;
    private String day;
    private String sleepStart;
    private String sleepEnd;
    private String sleepTotal;

    /**
     * Data from a given day of sleeping
     * @param date date slept (from the night before) as a string
     * @param day day of the week as a string
     * @param sleepStart time when sleep started as a string
     * @param sleepEnd time when sleep ended as a string
     * @param sleepTotal total time spent sleeping as a string
     */
    public SleepData(String date, String day, String sleepStart, String sleepEnd, String sleepTotal) {
        this.date = date;
        this.day = day;
        this.sleepStart = sleepStart;
        this.sleepEnd = sleepEnd;
        this.sleepTotal = sleepTotal;
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
