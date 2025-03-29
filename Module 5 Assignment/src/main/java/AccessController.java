import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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

    private User selectedUser;

    public void exit() {
        System.exit(1);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        displayUsers();
    }

    private void showUserBox(boolean b) {
            selectedUserHBox.setVisible(b);
    }

    // Error: can select empty lists
    private void displayUsers() {
        showUserBox(false);
        userList.getItems().clear();

        ArrayList<User> users = DatabaseHandler.getHandler().getUsers();
        for (User u : users) {
            userList.getItems().add(u.getUsername());
        }

        userList.setOnMouseClicked(event -> {
            String selectedUsername = (String) userList.getSelectionModel().getSelectedItem();
            for (User u : users) {
                if (selectedUsername.equals(u.getUsername())) {
                    selectUser(u);
                    break;
                }
            }
        });
    }

    private void selectUser(User user) {
        selectedUser = user;
        showUserBox(true);
        selectedUserLbl.setText("Username: " + selectedUser.getUsername() + "\tPassword: " + selectedUser.getPassword());
    }

    public void deleteUser() {
        ArrayList<User> users = DatabaseHandler.getHandler().getUsers();
        if (users.size() > 1) {
            DatabaseHandler.getHandler().deleteUser(selectedUser.getUsername());
            displayUsers();
        } else {
            giveUserError("Delete User", "Must have at least one user");
        }
    }

    public void addUser() {
        String newUsername = newUsernameField.getText();
        String newPassword = newPasswordField.getText();
        newUsernameField.clear();
        newPasswordField.clear();

        if (newUsername.isEmpty() || newPassword.isEmpty()) {
            giveUserError("Add User", "Username and password must not be empty");
            return;
        } else if (newUsername.length() >= 20 || newPassword.length() >= 20) {
            giveUserError("Add User", "Username and password must each be under 20 characters");
            return;
        }

        ArrayList<User> users = DatabaseHandler.getHandler().getUsers();
        for (User u : users) {
            if (newUsername.equals(u.getUsername())) {
                giveUserError("Add User", "Users must have unique usernames");
                return;
            }
        }

        DatabaseHandler.getHandler().insertUser(new User(newUsername, newPassword));
        displayUsers();
    }

    private void giveUserError(String action, String error) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(action + " Failed");
        alert.setContentText(error);
        alert.showAndWait();
    }
}
