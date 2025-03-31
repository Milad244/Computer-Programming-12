import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    public TextField usernameField;
    public TextField passwordField;
    public Button exitBtn;
    public HBox mainBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> exitBtn.requestFocus()); // Starts focus on exit button so the username placeholder text is visible
    }

    /**
     * Exits the program
     */
    public void exit() {
        System.exit(1);
    }

    /**
     * Gets the login information and either accepts or declines access based on if the user login exists
     */
    public void login() {
        User login = new User(usernameField.getText(), passwordField.getText());
        usernameField.clear();
        passwordField.clear();
        ArrayList<User> users = DatabaseHandler.getHandler().getUsers();
        for (User u : users) {
            if (login.getUsername().equals(u.getUsername()) && login.getPassword().equals(u.getPassword())) {
                grantAccess();
                return;
            }
        }
        declineAccess();
    }

    /**
     * Alerts user that login failed
     */
    public void declineAccess() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Login Failed");
        alert.setContentText("Login Information Incorrect");
        alert.showAndWait();
    }

    /**
     * Closes the login window (mainWindow) and loads the accessWindow
     */
    private void grantAccess() {
        Stage stage = (Stage) mainBox.getScene().getWindow();
        stage.close();
        loadWindow("fxml/accessWindow.fxml", "Access");
    }

    /**
     * Loads a javafx window
     * @param location the fxml file location for the window as a string
     * @param title the title for the window as a string
     */
    private void loadWindow(String location, String title) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(location));
            Stage stage = new Stage(StageStyle.UNDECORATED);
            stage.setTitle(title);
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Could not load window");
        }
    }
}
