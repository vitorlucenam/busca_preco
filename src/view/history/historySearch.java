package view.history;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.ToggleGroup;

public class historySearch {

    @FXML // fx:id="data"
    private TableColumn<?, ?> data; // Value injected by FXMLLoader

    @FXML // fx:id="produto"
    private TableColumn<?, ?> produto; // Value injected by FXMLLoader

    @FXML // fx:id="link"
    private TableColumn<?, ?> link; // Value injected by FXMLLoader

    @FXML // fx:id="busca"
    private TableColumn<?, ?> busca; // Value injected by FXMLLoader

    @FXML // fx:id="preco"
    private TableColumn<?, ?> preco; // Value injected by FXMLLoader

    @FXML // fx:id="alpha"
    private RadioButton alpha; // Value injected by FXMLLoader

    @FXML // fx:id="sortGroup"
    private ToggleGroup sortGroup; // Value injected by FXMLLoader

    @FXML // fx:id="big"
    private RadioButton big; // Value injected by FXMLLoader

    @FXML // fx:id="small"
    private RadioButton small; // Value injected by FXMLLoader

    @FXML // fx:id="searchButtton"
    private Button searchButtton; // Value injected by FXMLLoader

    @FXML // fx:id="buttonSort"
    private Button buttonSort; // Value injected by FXMLLoader

    @FXML // fx:id="buscaItem"
    private MenuItem buscaItem; // Value injected by FXMLLoader

    @FXML // fx:id="historyItem"
    private MenuItem historyItem; // Value injected by FXMLLoader

    @FXML // fx:id="exitItem"
    private MenuItem exitItem; // Value injected by FXMLLoader

    @FXML
    void activateSort(ActionEvent event) {

    }

    @FXML
    void alphaSort(ActionEvent event) {

    }

    @FXML
    void bigSort(ActionEvent event) {

    }

    @FXML
    void go_to_history(ActionEvent event) {
        view.MainJavaFX.changeScreen("search");

    }

    @FXML
    void go_to_login(ActionEvent event) {
        view.MainJavaFX.changeScreen("login");

    }

    @FXML
    void go_to_search(ActionEvent event) {
        view.MainJavaFX.changeScreen("busca");


    }

    @FXML
    void searchList(ActionEvent event) {

    }

    @FXML
    void smallSort(ActionEvent event) {

    }

}
