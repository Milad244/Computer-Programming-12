import java.sql.*;
import java.util.ArrayList;

public class DatabaseHandler {
    private static final String DB_url = "jdbc:derby:database/forum;create=true";
    private static Connection conn = null;
    private static Statement stmt = null;
    public static DatabaseHandler handler;
    private static final String USER_TABLE_NAME = "USER_TABLE";
    private static final User defaultUser = new User("Admin", "Password"); //gets added when table is created

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
        createUserTable();
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
     * Creates a user table for Users if it does not already exist
     */
    private void createUserTable() {
        try {
            stmt = conn.createStatement();
            DatabaseMetaData dmn = conn.getMetaData();
            ResultSet tables = dmn.getTables(null, null, USER_TABLE_NAME, null);

            if (tables.next()) {
                System.out.println("Table " + USER_TABLE_NAME + " already exists");
            } else {
                String qu = "CREATE TABLE " + USER_TABLE_NAME + " ("
                        + "id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY, \n"
                        + "username VARCHAR(200), \n"
                        + "password VARCHAR(200))";
                System.out.println(qu);
                stmt.execute(qu);
                insertUser(defaultUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Did not create user table");
        }
    }

    /**
     * Inserts a row of User into the user table
     * @param user user
     */
    public void insertUser(User user) {
        String qu = String.format("INSERT INTO %s (username, password) "
                        + "VALUES ('%s', '%s')", USER_TABLE_NAME, user.getUsername(), user.getPassword());

        System.out.println(qu);
        execAction(qu);
    }

    /**
     * Deletes a row of user from the user table
     * @param id id of the row of user to be deleted
     */
    public void deleteUser(int id) {
        String qu = "SELECT * FROM " + USER_TABLE_NAME;
        try {
            ResultSet rs = execQuery(qu);
            while (rs.next()) {
                int currentId = Integer.parseInt(rs.getString("id"));
                if (currentId == id) {
                    String delQu = "DELETE FROM " + USER_TABLE_NAME + " WHERE id=" + currentId;
                    System.out.println(delQu);
                    execAction(delQu);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Did not delete user");
        }
    }

    /**
     * Deletes the entire user table
     */
    public void deleteUserTable() {
        String qu = "DROP TABLE " + USER_TABLE_NAME;
        System.out.println(qu);
        execAction(qu);
    }

    /**
     * Prints the entire user table
     */
    public void printUsers() {
        String qu = "SELECT * FROM " + USER_TABLE_NAME;
        try {
            ResultSet rs = execQuery(qu);
            while (rs.next()) {
                System.out.println("ID: " + rs.getString("id"));
                System.out.println("Username: " + rs.getString("username"));
                System.out.println("Password: " + rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Did not show user table");
        }
    }

    /**
     * Creates an ArrayList of SleepData from the sleep table
     * @return ArrayList of SleepData
     */
    public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        String qu = "SELECT * FROM " + USER_TABLE_NAME;
        try {
            ResultSet rs = execQuery(qu);
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                users.add(new User(username, password));
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Did not return users");
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