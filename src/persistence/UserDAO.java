package persistence;

import model.User;

import java.io.*;
import java.util.ArrayList;

public class UserDAO {
    private static ArrayList<User> users = new ArrayList<>();
    public void insert(User u) throws Exception{ //inserir
        users.add(u);
        save_data();
    }
    public void delete(int id) throws Exception{ //excluir
        User aux = search_by_id(id);
        users.remove(aux);
        save_data();
    }
    public void change(User u)throws Exception{ //alterar
        User aux = search_by_id(u.getId());
        aux.setName(u.getName());
        aux.setUser(u.getUser());
        aux.setPassword(u.getPassword());
        aux.setCep(u.getCep());
        save_data();
    }
    public User search_by_id(int id){
        for(User aux: users){
            if(aux.getId()==id){
                return aux;
            }
        }
        return null;
    }
    public ArrayList<User> search_by_name(String name){
        ArrayList<User> temp = new ArrayList<>();
        for(User aux: users){
            if(aux.getName().contains(name)){
                temp.add(aux);
            }
        }
        return temp;
    }
    public void save_data() throws Exception {
        File f = new File("users.txt");

        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            //Classe que armazena caracteres
            fw = new FileWriter(f);

            //Classe que armazena strings
            bw = new BufferedWriter(fw);

            //Escreveu uma linha no texto
            for(User u : users) {
                bw.write(u.getName()+";"+u.getUser()+";"+u.getPassword()+";"+u.getId());
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
        File f = new File("users.txt");

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

                User u = new User(dados[0], dados[1], dados[2], Integer.parseInt(dados[3]), Integer.parseInt(dados[4]));
                users.add(u);
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