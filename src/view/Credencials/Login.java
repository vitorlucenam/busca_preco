package view.Credencials;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import persistence.HistoryDAO;
import sun.applet.Main;


import java.io.IOException;

public class Login {

    public void initialize(){
        try {
            HistoryDAO.clean_data();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public Button enterButton;

    @FXML
    public Button newUser;

    @FXML
    void enterTheSystem(ActionEvent event) throws IOException {
        view.MainJavaFX.changeScreen("busca");


    }

    @FXML
    void fcfafa(ActionEvent event) {

    }

    @FXML
    void newUserWindow(ActionEvent event) throws IOException{
        view.MainJavaFX.changeScreen("cadastro");
    }

}

