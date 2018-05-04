package view.buscar;

import javafx.event.ActionEvent;
import controller.stores;
import javafx.scene.control.*;
import persistence.HistoryDAO;
/**
 * Sample Skeleton for 'busca.fxml' Controller Class
 */



import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import model.Search;

import java.io.IOException;

public class Busca {
    public stores loja = new stores();

    @FXML // fx:id="searchItem"
    private MenuItem searchItem; // Value injected by FXMLLoader

    @FXML // fx:id="historyItem"
    private MenuItem historyItem; // Value injected by FXMLLoader

    @FXML // fx:id="sairItem"
    private MenuItem sairItem; // Value injected by FXMLLoader

    @FXML // fx:id="string_search"
    private TextField string_search; // Value injected by FXMLLoader

    @FXML // fx:id="mercdoLivre_dot"
    private RadioButton mercdoLivre_dot; // Value injected by FXMLLoader

    @FXML // fx:id="americanasDot"
    private RadioButton americanasDot; // Value injected by FXMLLoader

    @FXML // fx:id="submarinoDot"
    private RadioButton submarinoDot; // Value injected by FXMLLoader

    @FXML // fx:id="gearbeast"
    private RadioButton gearbeast; // Value injected by FXMLLoader

    @FXML // fx:id="olxDot"
    private RadioButton olxDot; // Value injected by FXMLLoader

    @FXML // fx:id="search_button"
    private Button search_button; // Value injected by FXMLLoader

    @FXML
    void gearbeastStart(ActionEvent event) {

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
    void go_to_search_Page(ActionEvent event) {


    }

    @FXML
    void olxStart(ActionEvent event) {

    }

    @FXML
    void save_string(ActionEvent event) {

    }

    @FXML
    void show_result(MouseEvent event) throws Exception {
        Search pesquisa = new Search(string_search.getText());

        if(mercdoLivre_dot.isSelected()){

            HistoryDAO.insertProducts(loja.mercadoLivreProducts(pesquisa));
            System.out.println("ok");

        }
        if(olxDot.isSelected()){

            HistoryDAO.insertProducts(loja.olxProducts(pesquisa));
            System.out.println("ok");


        }
        if(gearbeast.isSelected()){

            HistoryDAO.insertProducts(loja.gearbestProducts(pesquisa));
            System.out.println("ok");


        }
        if(submarinoDot.isSelected()){

            HistoryDAO.insertProducts(loja.submarinoProducts(pesquisa));
            System.out.println("ok");


        }
        if(americanasDot.isSelected()){

            HistoryDAO.insertProducts(loja.americanaProducts(pesquisa));
            System.out.println("ok");
        }
        System.out.println(HistoryDAO.getProducts().size());

        System.out.println("end");
        //HistoryDAO.save_data();
        view.MainJavaFX.changeScreen("resultado");


    }

    @FXML
    void startAmaericanas(ActionEvent event) {

    }

    @FXML
    void startSubmarino(ActionEvent event) {

    }

    @FXML
    void start_mercadoLivre(ActionEvent event) {

    }

}
