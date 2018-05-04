package persistence;

import model.Product;
import model.Search;

import java.io.*;
import java.util.ArrayList;

public class HistoryDAO {
    private static ArrayList<Product> products = new ArrayList<>();

    public static void setProducts(ArrayList<Product> products) {
        HistoryDAO.products = products;

    }

    public static ArrayList<Product> getProducts(){
        return products;
    }

    public static void insertProducts( ArrayList<Product> newProducts){
        products.addAll(newProducts);
    }

    public static void insert(Product u) throws Exception{ //inserir
        products.add(u);
        save_data();
    }
    public static void delete(String link) throws Exception{ //excluir
        Product aux = search_by_link(link);
        products.remove(aux);
        save_data();
    }
    public static void change(Product u)throws Exception{ //alterar
        Product aux = search_by_link(u.getLink());
        aux.setName(u.getName());
        aux.setLink(u.getLink());
        aux.setPrice(u.getPrice());
        aux.setSearch(u.getSearch());
        save_data();
    }
    public static Product search_by_link(String link){
        for(Product aux: products){
            if(aux.getLink()==link){
                return aux;
            }
        }
        return null;
    }
    public static ArrayList<Product> search_by_name(String name){
        ArrayList<Product> temp = new ArrayList<>();
        for(Product aux: products){
            if(aux.getName().contains(name)){
                temp.add(aux);
            }
        }
        return temp;
    }

    public static void clean_data() throws Exception{
        products.clear();
        save_data();
    }
    public static ArrayList<Product> preencherTabela(){
        File f = new File("products.txt");
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            String linha;

            products.clear();
            System.out.println("Aqui");
            while ((linha = br.readLine()) != null) {
                System.out.println("Lendo");
                String[] dados = linha.split(";");

                String name = (dados[0]);
                String link = dados[1];
                Double price = Double.parseDouble(dados[2]);
                String searchvalue = (dados[3]);
                String searchdate = (dados[4]);

                Product p = new Product(name, link, price, searchvalue, searchdate);
                products.add(p);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return products;
    }

    public static void save_data() throws Exception {
        File f = new File("products.txt");

        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            //Classe que armazena caracteres
            fw = new FileWriter(f);

            //Classe que armazena strings
            bw = new BufferedWriter(fw);

            //Escreveu uma linha no texto
            for(Product u : products) {
                bw.write(u.getName()+";"+u.getLink()+";"+u.getPrice()+";"+u.getSearch().getValue()+";"+u.getSearch().getDate());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    static {
        File f = new File("products.txt");

        FileReader fr = null;
        BufferedReader br = null;

        try {
            //Classe que armazena caracteres
            fr = new FileReader(f);

            //Classe que armazena strings
            br = new BufferedReader(fr);

            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                Search pesquisa = new Search(dados[3]);
                Product u = new Product(dados[0], dados[1], Double.parseDouble(dados[2]),pesquisa);
                products.add(u);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

