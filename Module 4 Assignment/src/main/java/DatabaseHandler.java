import java.sql.*;

public class DatabaseHandler {
    private static final String DB_url = "jdbc:derby:database/forum;create=true";
    private static Connection conn = null;
    private static Statement stmt = null;
    public static DatabaseHandler handler;
    private static final String SLEEP_TABLE_NAME = "SLEEP_TABLE";

    public static DatabaseHandler getHandler(){
        if(handler == null){
            handler = new DatabaseHandler();
        }
        return handler;
    }

    public DatabaseHandler() {
        createConnection();
        createSleepTable();
    }

    private void createConnection() {
        try {
            conn = DriverManager.getConnection(DB_url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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

    public void insertSleepData(String date, String day, String sleepStart, String sleepEnd, String sleepTotal) {
        String qu = String.format("INSERT INTO %s (date, day, sleepStart, sleepEnd, sleepTotal) "
                + "VALUES ('%s', '%s', '%s', '%s', '%s')", SLEEP_TABLE_NAME, date, day, sleepStart, sleepEnd, sleepTotal);
        System.out.println(qu);
        execAction(qu);
    }

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

    public void deleteSleepTable() {
        execAction("DROP TABLE " + SLEEP_TABLE_NAME);
    }

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
    
    public boolean execAction(String qu) {
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
    public ResultSet execQuery(String query){
        ResultSet resultSet;
        try{
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return resultSet;
    }
}
