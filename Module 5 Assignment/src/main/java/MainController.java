import javafx.application.Platform;
import javafx.event.ActionEvent;
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
        Platform.runLater(() -> exitBtn.requestFocus());
    }

    public void exit() {
        System.exit(1);
    }

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

    public void declineAccess() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Login Failed");
        alert.setContentText("Login Information Incorrect");
        alert.showAndWait();
    }

    private void grantAccess() {
        Stage stage = (Stage) mainBox.getScene().getWindow();
        stage.close();
        loadWindow("fxml/accessWindow.fxml", "Access");
    }

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
