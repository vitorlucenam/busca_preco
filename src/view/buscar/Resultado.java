package view.buscar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.Product;
import model.Search;
import persistence.HistoryDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;

public class Resultado implements Initializable {


    @FXML
    private TableView<Product> tabela;

    @FXML // fx:id="data"
    private TableColumn<Product, String> data; // Value injected by FXMLLoader

    @FXML // fx:id="nome"
    private TableColumn<Product, String> nome; // Value injected by FXMLLoader

    @FXML // fx:id="link"
    private TableColumn<Product, String> link; // Value injected by FXMLLoader

    @FXML // fx:id="preço"
    private TableColumn<Product, Double> preco; // Value injected by FXcLLoader

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

    private static ObservableList<Product> productsController = FXCollections.observableArrayList();
    //HistoryDAO dao = new HistoryDAO();

    public static void init(){
        productsController.clear();
        productsController.addAll(HistoryDAO.getProducts());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tabela.setItems(productsController);
        preencherTabela();

    }

    private void preencherTabela (){

        productsController.clear();

        data.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        nome.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        link.setCellValueFactory(cellData -> cellData.getValue().linkProperty());
        preco.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        System.out.println(HistoryDAO.getProducts().size());
        for(Product p : HistoryDAO.getProducts())
            productsController.add(p);


    }

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
    void go_to_search(ActionEvent event) throws Exception {
        view.MainJavaFX.changeScreen("busca");
        HistoryDAO.clean_data();


    }

    @FXML
    void searchList(ActionEvent event) {

    }

    @FXML
    void smallSort(ActionEvent event) {

    }

}