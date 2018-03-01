package persistence;

import model.Search;

import java.io.*;
import java.util.ArrayList;

public class SearchDAO {
    private static ArrayList<Search> searchs = new ArrayList<>();
    public void insert(Search u) throws Exception{ //inserir
        searchs.add(u);
        save_data();
    }
    public void delete(String value) throws Exception{ //excluir
        Search aux = search_by_value(value);
        searchs.remove(aux);
        save_data();
    }
    public void change(Search u)throws Exception{ //alterar
        Search aux = search_by_value(u.getLink());
        aux.setValue(u.getValue());
        save_data();
    }
    public Search search_by_value(String value){
        for(Search aux: searchs){
            if(aux.getLink()==value){
                return aux;
            }
        }
        return null;
    }

    public void save_data() throws Exception {
        File f = new File("searchs_history.txt");

        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            //Classe que armazena caracteres
            fw = new FileWriter(f);

            //Classe que armazena strings
            bw = new BufferedWriter(fw);

            //Escreveu uma linha no texto
            for(Search u : searchs) {
                bw.write(u.getValue());
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
        File f = new File("searchs_history.txt");

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

                Search u = new Search(dados[0]);
                searchs.add(u);
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
