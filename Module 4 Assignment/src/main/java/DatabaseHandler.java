import java.sql.*;
import java.util.ArrayList;

public class DatabaseHandler {
    private static final String DB_url = "jdbc:derby:database/forum;create=true";
    private static Connection conn = null;
    private static Statement stmt = null;
    public static DatabaseHandler handler;
    private static final String SLEEP_TABLE_NAME = "SLEEP_TABLE";

    /**
     * Returns database handler which is used to run my database's methods
     * @return returns a new handler if a database handler has not been initiated, else returns the one already initiated
     */
    public static DatabaseHandler getHandler(){
        if(handler == null){
            handler = new DatabaseHandler();
        }
        return handler;
    }

    /**
     * Runs methods that initiate this database
     */
    private DatabaseHandler() {
        createConnection();
        createSleepTable();
    }

    /**
     * Set connection to my database
     */
    private void createConnection() {
        try {
            conn = DriverManager.getConnection(DB_url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates a sleep table for Sleep Data if it does not already exist
     */
    private void createSleepTable() {
        try {
            stmt = conn.createStatement();
            DatabaseMetaData dmn = conn.getMetaData();
            ResultSet tables = dmn.getTables(null, null, SLEEP_TABLE_NAME, null);

            if (tables.next()) {
                System.out.println("Table " + SLEEP_TABLE_NAME + " already exists");
            } else {
                String qu = "CREATE TABLE " + SLEEP_TABLE_NAME + " ("
                        + "id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY, \n"
                        + "date VARCHAR(200), \n"
                        + "day VARCHAR(200), \n"
                        + "sleepStart VARCHAR(200), \n"
                        + "sleepEnd VARCHAR(200), \n"
                        + "sleepTotal VARCHAR(200))";
                System.out.println(qu);
                stmt.execute(qu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Did not create sleep table");
        }
    }

    /**
     * Inserts a row of SleepData into the database sleep table
     * @param sleepData SleepData
     */
    public void insertSleepData(SleepData sleepData) {
        String qu = String.format("INSERT INTO %s (date, day, sleepStart, sleepEnd, sleepTotal) "
                + "VALUES ('%s', '%s', '%s', '%s', '%s')", SLEEP_TABLE_NAME, sleepData.getDate(), sleepData.getDay(),
                sleepData.getSleepStart(), sleepData.getSleepEnd(), sleepData.getSleepTotal());

        System.out.println(qu);
        execAction(qu);
    }

    /**
     * Deletes a row of SleepData from the database sleep table
     * @param id id of the row of SleepData to be deleted
     */
    public void deleteSleepData(int id) {
        String qu = "SELECT * FROM " + SLEEP_TABLE_NAME;
        try {
            ResultSet rs = execQuery(qu);
            while (rs.next()) {
                int currentId = Integer.parseInt(rs.getString("id"));
                if (currentId == id) {
                    String delQu = "DELETE FROM " + SLEEP_TABLE_NAME + " WHERE id=" + currentId;
                    System.out.println(delQu);
                    execAction(delQu);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Did not delete sleep data");
        }
    }

    /**
     * Deletes the entire sleep table
     */
    public void deleteSleepTable() {
        String qu = "DROP TABLE " + SLEEP_TABLE_NAME;
        System.out.println(qu);
        execAction(qu);
    }

    /**
     * Prints the entire sleep table
     */
    public void showSleepData() {
        String qu = "SELECT * FROM " + SLEEP_TABLE_NAME;
        try {
            ResultSet rs = execQuery(qu);
            while (rs.next()) {
                System.out.println("ID: " + rs.getString("id"));
                System.out.println("Date: " + rs.getString("date"));
                System.out.println("Day: " + rs.getString("day"));
                System.out.println("Sleep Start: " + rs.getString("sleepStart"));
                System.out.println("Sleep End: " + rs.getString("sleepEnd"));
                System.out.println("Sleep Total: " + rs.getString("sleepTotal"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Did not show sleep data");
        }
    }

    /**
     * Creates an ArrayList of SleepData from the sleep table
     * @return ArrayList of SleepData
     */
    public ArrayList<SleepData> getSleepData() {
        ArrayList<SleepData> sleepData = new ArrayList<>();
        String qu = "SELECT * FROM " + SLEEP_TABLE_NAME;
        try {
            ResultSet rs = execQuery(qu);
            while (rs.next()) {
                String date = rs.getString("date");
                String day = rs.getString("day");
                String sleepStart = rs.getString("sleepStart");
                String sleepEnd = rs.getString("sleepEnd");
                String sleepTotal = rs.getString("sleepTotal");
                sleepData.add(new SleepData(date, day, sleepStart, sleepEnd, sleepTotal));
            }
            return sleepData;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Did not return sleep data");
            return null;
        }
    }

    /**
     * Executes the command given by the query, altering the database
     * @param qu query as an SQL formated string
     * @return true if query was successfully executed, false otherwise
     */
    private boolean execAction(String qu) {
        try {
            stmt = conn.createStatement();
            stmt.execute(qu);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Did not enter data");
        }
        return false;
    }

    /**
     * Executes the command given by the query, returning a resultSet from the database as instructed by the query
     * @param qu query as an SQL formated string
     * @return ResultSet as asked for by the query
     */
    private ResultSet execQuery(String qu){
        ResultSet resultSet;
        try{
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery(qu);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return resultSet;
    }
}
