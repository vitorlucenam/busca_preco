package controller;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import model.Product;
import model.Search;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class stores {

    public Document get_wesite(String url){

        Document document = null;
        try{
            document = Jsoup.connect(url).ignoreHttpErrors(true).get();

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Sem conexão com a internet", ButtonType.OK);
            alert.showAndWait();
        }

        return document;
    }

    public ArrayList<Product> gearbestProducts(Search busca) throws IOException {

        ArrayList<Product> gearbest = new ArrayList<Product>();

        String url = "https://br.gearbest.com/" + busca.getValue() + "-_gear/";

       final Document document = get_wesite(url);


        for (Element row : document.select(".c_cate")) {

            final String title = row.select(".logsss_event_cl").text();

            final String price = row.select(".my_shop_price").text();

            final String justNumberPrice = price.replaceAll("[^0-9]", "");

            Float price_final = Float.parseFloat(justNumberPrice);

            final String link = row.select(".logsss_event_cl").attr("href");

            Product produto = new Product(title,link,price_final,busca);

            gearbest.add(produto);

        }

        return(gearbest);
    }

    public ArrayList<Product> americanaProducts(Search busca) throws IOException {
        ArrayList<Product> americana = new ArrayList<Product>();

        String url = "https://www.americanas.com.br/busca/" + busca.getValue();

        final Document document = get_wesite(url);

        for (Element row : document.select(".card-product")) {

            final String title = row.select(".card-product-name").text();
            final String price = row.select(".value").text();
            final String justNumberPrice = price.replaceAll("[^0-9,]", "");
            final String numberDots = justNumberPrice.replaceAll("[^0-9]",".");
            Float price_final = Float.parseFloat(numberDots);


            final String link = row.select(".card-product-url").attr("href");

            final String link_final = "https://www.americanas.com.br" + link ;

            Product produto = new Product(title,link_final,price_final,busca);

            americana.add(produto);

        }

        return(americana);
    }

    public ArrayList<Product>  mercadoLivreProducts(Search busca) throws IOException {
        ArrayList<Product> mercadoLivre = new ArrayList<Product>();


        String url;
        url = "https://lista.mercadolivre.com.br/" + busca.getValue() + "#D[A:" + busca.getValue() + "]";

        final Document document =  get_wesite(url);


        for (Element row : document.select(".results-item")) {
            final String title = row.select(".item__title").text();
            final String price_a = row.select(".price__fraction").text();
            final String string_price_a = price_a.replaceAll("[^0-9]", "");

            final String price_b = row.select(".price__decimals").text();

            final String final_price = string_price_a + ((price_b.isEmpty()) ? "." + "00" : "." + price_b);

            Float price_ff = Float.parseFloat(final_price);

            final String link = row.select(".item__js-link").attr("href");

            Product produto = new Product(title,link,price_ff,busca);

            mercadoLivre.add(produto);

        }
        return(mercadoLivre);
    }

    public ArrayList<Product>  olxProducts (Search busca) throws IOException {
        ArrayList<Product> olx = new ArrayList<Product>();

        String url = "http://www.olx.com.br/brasil?q=" + busca.getValue();

        final Document document =  get_wesite(url);

        for (Element row : document.select("li.item")) {

            final String title = row.select(".OLXad-list-line-1 .OLXad-list-title").text();
            final String price = row.select("p.OLXad-list-price").text();


            final String link = row.select(".OLXad-list-link").attr("href");

            if (!price.isEmpty()){
                final String justNumberPrice = price.replaceAll("[^0-9]", "");

                Float price_final = Float.parseFloat(justNumberPrice);
                Product produto = new Product(title,link,price_final,busca);

                olx.add(produto);
            }

        }
        return(olx);
    }

    public ArrayList<Product>  submarinoProducts(Search busca) throws IOException {

        ArrayList<Product> submarino = new ArrayList<Product>();

        String url = "https://www.submarino.com.br/busca/" + busca.getValue();

        final Document document =  get_wesite(url);

        for (Element row : document.select(".card-product")) {

            final String title = row.select(".card-product-name").text();
            final String price = row.select(".value").text();

            final String justNumberPrice = price.replaceAll("[^0-9,]", "");
            final String numberDot = justNumberPrice.replaceAll("[^0-9]", ".");

            Float price_final = Float.parseFloat(numberDot);

            final String link = row.select(".card-product-url").attr("href");
            final String link_final = "https://www.submarino.com.br" + link;

            if (!price.isEmpty()){
                Product produto = new Product(title,link_final,price_final,busca);

                submarino.add(produto);
            }



        }

        return(submarino);
    }




}
