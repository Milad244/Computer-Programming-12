import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    public TextField usernameField;
    public TextField passwordField;
    public Button exitBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> exitBtn.requestFocus());
    }

    public void exit() {
        System.exit(1);
    }

    public void login(ActionEvent actionEvent) {
        User login = new User(usernameField.getText(), passwordField.getText());
        usernameField.clear();
        passwordField.clear();
        ArrayList<User> users = DatabaseHandler.getHandler().getUsers();
        for (User u : users) {
            if (login.getUsername().equals(u.getUsername()) && login.getPassword().equals(u.getPassword())) {
                System.out.println("Login Success");
                DatabaseHandler.getHandler().printUsers();
            } else {
                System.out.println("Login Failed");
            }
        }
    }
}
