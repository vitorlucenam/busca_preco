/**
 * Sample Skeleton for 'login.fxml' Controller Class
 */

package view.Credencials;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import controller.checkBox;
import persistence.UserDAO;
import persistence.HistoryDAO;
import java.io.IOException;

public class Login {

    checkBox okLogin = new checkBox();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="user"
    private TextField user; // Value injected by FXMLLoader

    @FXML // fx:id="enterButton"
    private Button enterButton; // Value injected by FXMLLoader

    @FXML // fx:id="newUser"
    private Button newUser; // Value injected by FXMLLoader

    @FXML // fx:id="password"
    private PasswordField password; // Value injected by FXMLLoader

    @FXML
    void enterTheSystem(ActionEvent event) {

        UserDAO passBank = new UserDAO();


        if (okLogin.is_text_empty(user) || okLogin.is_pasword_empty(password)) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Você deixou um quadro em branco", ButtonType.OK);
            alert.showAndWait();
        } else {
           if (!passBank.search_by_name(user.getText()).isEmpty() || !passBank.search_by_password(password.getText()).isEmpty()) {
               view.MainJavaFX.changeScreen("busca");

            } else {
               Alert alert = new Alert(Alert.AlertType.ERROR, "Você errou algum parametro ou usuário não existe", ButtonType.OK);
                alert.showAndWait();

            }
        }
        //view.MainJavaFX.changeScreen("busca");

    }


    @FXML
    void newUserWindow(ActionEvent event) {
        view.MainJavaFX.changeScreen("cadastro");
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert user != null : "fx:id=\"user\" was not injected: check your FXML file 'login.fxml'.";
        assert enterButton != null : "fx:id=\"enterButton\" was not injected: check your FXML file 'login.fxml'.";
        assert newUser != null : "fx:id=\"newUser\" was not injected: check your FXML file 'login.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'login.fxml'.";

    }
}
