package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.buscar.Resultado;


public class MainJavaFX extends Application {

    private static Stage stage;

    private static Scene Busca;
    private static Scene resultado;
    private static Scene Cadastro;
    private static Scene Login;
    private static Scene HistoryResearch;
    private static Scene HistorySearch;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        primaryStage.setTitle("Login");

        Parent fxmlLogin = FXMLLoader.load(getClass().getResource("Credencials/login.fxml"));
        Login = new Scene(fxmlLogin, 640, 400);
        Parent fxmlBusca = FXMLLoader.load(getClass().getResource("buscar/busca.fxml"));
        Busca = new Scene(fxmlBusca, 640, 400);
        Parent fxmlResultado = FXMLLoader.load(getClass().getResource("buscar/resultado.fxml"));
        resultado = new Scene(fxmlResultado, 640, 400);
        Parent fxmlCadastro = FXMLLoader.load(getClass().getResource("Credencials/cadastro.fxml"));
        Cadastro = new Scene(fxmlCadastro, 640, 400);
        Parent fxmlHistorySearch = FXMLLoader.load(getClass().getResource("history/historySearch.fxml"));
        HistorySearch = new Scene(fxmlHistorySearch, 640, 400);


        primaryStage.setScene(Login);
        primaryStage.show();
    }
    public static void changeScreen(String scr){
        switch(scr){
            case"login":
                stage.setScene(Login);
                break;
            case"busca":
                stage.setScene(Busca);
                break;
            case "resultado":
                stage.setScene(resultado);
                Resultado.init();
                break;
            case "cadastro":
                stage.setScene(Cadastro);
                break;
            case "search":
                stage.setScene(HistorySearch);
                break;
        }
    }
    public static void main(String[] args) {
        launch(args);
    }



}