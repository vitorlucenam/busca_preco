/**
 * Sample Skeleton for 'cadastro.fxml' Controller Class
 */

package view.Credencials;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import controller.checkBox;
import model.User;
import org.jasypt.util.password.StrongPasswordEncryptor;
import persistence.UserDAO;

public class Cadastro {

    checkBox ok = new checkBox();


    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="returnButton"
    private Button returnButton; // Value injected by FXMLLoader

    @FXML // fx:id="cadastrarButton"
    private Button cadastrarButton; // Value injected by FXMLLoader

    @FXML // fx:id="nameField"
    private TextField nameField; // Value injected by FXMLLoader

    @FXML // fx:id="passwordField"
    private PasswordField passwordField; // Value injected by FXMLLoader

    @FXML // fx:id="passwordFieldConfirm"
    private PasswordField passwordFieldConfirm; // Value injected by FXMLLoader

    @FXML
    void doCadastrar(ActionEvent event) throws Exception {
        if (ok.is_text_empty(nameField) || ok.is_pasword_empty(passwordField) || ok.is_pasword_empty(passwordFieldConfirm)) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Você deixou um quadro em branco", ButtonType.OK);
            alert.showAndWait();
        } else {
            if (!passwordField.getText().equals(passwordFieldConfirm.getText())) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Senhas diferentes", ButtonType.OK);
                alert.showAndWait();
            } else {

                UserDAO banco = new UserDAO();
                if (banco.search_by_name(nameField.getText()).isEmpty()) {
                    StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
                    String encryptedPassword = passwordEncryptor.encryptPassword(passwordField.getText());
                    User newUser = new User(nameField.getText(), encryptedPassword);
                    banco.insert(newUser);
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Cadastro realizado com sucesso", ButtonType.OK);
                    alert.showAndWait();

                    if (alert.getResult() == ButtonType.OK) {
                        view.MainJavaFX.changeScreen("login");
                    }

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Esse usuário já existe", ButtonType.OK);
                    alert.showAndWait();


                }

            }
        }
    }


               //banco.insert(novo);


    @FXML
    void nameText(ActionEvent event) {

    }

    @FXML
    void passwordText(ActionEvent event) {

    }

    @FXML
    void passwordTextConfirm(ActionEvent event) {

    }

    @FXML
    void returnToLastOne(ActionEvent event) {
        view.MainJavaFX.changeScreen("login");


    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert returnButton != null : "fx:id=\"returnButton\" was not injected: check your FXML file 'cadastro.fxml'.";
        assert cadastrarButton != null : "fx:id=\"cadastrarButton\" was not injected: check your FXML file 'cadastro.fxml'.";
        assert nameField != null : "fx:id=\"nameField\" was not injected: check your FXML file 'cadastro.fxml'.";
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file 'cadastro.fxml'.";
        assert passwordFieldConfirm != null : "fx:id=\"passwordFieldConfirm\" was not injected: check your FXML file 'cadastro.fxml'.";

    }
}
