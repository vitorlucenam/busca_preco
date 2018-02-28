package persistence;

import model.Product;

import java.io.*;
import java.util.ArrayList;

public class ProductDAO {
    private static ArrayList<Product> products = new ArrayList<>();
    public void insert(Product u) throws Exception{ //inserir
        products.add(u);
        save_data();
    }
    public void delete(String link) throws Exception{ //excluir
        Product aux = search_by_link(link);
        products.remove(aux);
        save_data();
    }
    public void change(Product u)throws Exception{ //alterar
        Product aux = search_by_link(u.getLink());
        aux.setName(u.getName());
        aux.setLink(u.getLink());
        aux.setUrl_image(u.getUrl_image());
        aux.setPrice(u.getPrice());
        save_data();
    }
    public Product search_by_link(String link){
        for(Product aux: products){
            if(aux.getLink()==link){
                return aux;
            }
        }
        return null;
    }
    public ArrayList<Product> search_by_name(String name){
        ArrayList<Product> temp = new ArrayList<>();
        for(Product aux: products){
            if(aux.getName().contains(name)){
                temp.add(aux);
            }
        }
        return temp;
    }
    public void save_data() throws Exception {
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
                bw.write(u.getName()+";"+u.getLink()+";"+u.getUrl_image()+";"+u.getPrice());
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

                Product u = new Product(dados[0], dados[1], dados[2], dados[3]);
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

