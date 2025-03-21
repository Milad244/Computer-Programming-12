import java.sql.*;

public class DatabaseHandler {
    private static final String DB_url = "jdbc:derby:database/forum;create=true";
    private static Connection conn = null;
    private static Statement stmt = null;
    public static DatabaseHandler handler;

    public static DatabaseHandler getHandler(){
        if(handler == null){
            handler = new DatabaseHandler();
        }
        return handler;
    }

    public DatabaseHandler() {
        createConnection();
        //createTable();
    }

    private void createConnection() {
        try {
            conn = DriverManager.getConnection(DB_url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /** Old table
    private void createTable() {
        String TABLE_NAME = "MEMBER2";
        try {
            stmt = conn.createStatement();
            DatabaseMetaData dmn = conn.getMetaData();
            ResultSet tables = dmn.getTables(null, null, TABLE_NAME, null);
            if (tables.next()) {
                System.out.println("Table " + TABLE_NAME + " exists");
            } else {
                String statement = "CREATE TABLE " + TABLE_NAME + " ("
                        + "id varchar(200) primary key, \n"
                        + "name varchar(200), \n"
                        + "email varchar(200), \n"
                        + "nickname varchar(200))";
                System.out.println(statement);
                stmt.execute(statement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    private void createTable() {
        String TABLE_NAME = "TABLE1";
        try {
            stmt = conn.createStatement();
            DatabaseMetaData dmn = conn.getMetaData();
            ResultSet tables = dmn.getTables(null, null, TABLE_NAME, null);

            boolean tableExists = false;
            System.out.println(tables.next());
            while (tables.next()) {
                System.out.println("CHECKING");
                String currentTableName = tables.getString("TABLE_NAME");
                System.out.println(currentTableName);
                if (TABLE_NAME.equalsIgnoreCase(currentTableName)) {
                    tableExists = true;
                    break;
                }
            }

            if (tableExists) {
                System.out.println("Table " + TABLE_NAME + " exists");
            } else {
                String statement = "CREATE TABLE " + TABLE_NAME + " ("
                        + "id varchar(200) primary key, \n"
                        + "date varchar(200), \n"
                        + "day varchar(200), \n"
                        + "sleepStart varchar(200), \n"
                        + "sleepEnd varchar(200), \n"
                        + "sleepTotal varchar(200))";
                System.out.println(statement);
                stmt.execute(statement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertSleepData(int id, String date, String day, String sleepStart, String sleepEnd, String sleepTotal) {
        String insertQuery = String.format("INSERT INTO Table1 (id, date, day, sleepStart, sleepEnd, sleepTotal) "
                + "VALUES ('%d', '%s', '%s', '%s', '%s', '%s')", id, date, day, sleepStart, sleepEnd, sleepTotal);
        System.out.println(insertQuery);
        execAction(insertQuery);
    }

    /** Old data
    public void insertSampleData() {
        String insertQuery = "INSERT INTO MEMBER2 (id, name, email, nickname) "
                + "VALUES ('1', 'John Doe', 'john@example.com', 'Johnny')";
        execAction(insertQuery);
    }


    public void showMembers() {
        String query = "SELECT * FROM MEMBER2";
        try {
            ResultSet rs = execQuery(query);
            while (rs.next()) {
                System.out.println("ID: " + rs.getString("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Nickname: " + rs.getString("nickname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    public void showMembers() {
        String query = "SELECT * FROM Table1";
        try {
            ResultSet rs = execQuery(query);
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
