package controller;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class checkBox {

   public boolean  is_text_empty(TextField nameField){

        if(nameField.getText().trim().isEmpty()){
            return true;
        }else{
            return false;
        }

    }

    public boolean is_pasword_empty(PasswordField passwordField){
        if(passwordField.getText().trim().isEmpty()){
            return true;
        }else{
            return false;
        }
    }



}
