import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AccessController implements Initializable {

    public ListView userList;
    public TextField newUsernameField;
    public TextField newPasswordField;
    public HBox selectedUserHBox;
    public Label selectedUserLbl;

    public void exit() {
        System.exit(1);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        displayUsers();
        showUserBox(false);
    }

    private void showUserBox(boolean b) {
            selectedUserHBox.setVisible(b);
    }

    private void displayUsers() {
        userList.getItems().clear();

        ArrayList<User> users = DatabaseHandler.getHandler().getUsers();
        for (User u : users) {
            userList.getItems().add(u.getUsername());
        }
    }
}
