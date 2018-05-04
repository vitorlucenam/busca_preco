package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Search {
    private String value;
    private StringProperty date;

    public Search(String value) {
        this.value = value;
        setDate();
    }
    public Search(String value, String date){
        this.value = value;
        this.date = new SimpleStringProperty(date);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDate() {
        return date.get();
    }

    public void setDate() {
        String data = new SimpleDateFormat("yyyy/MM/dd_HH:mm:ss").format(Calendar.getInstance().getTime());
        StringProperty dataa = new SimpleStringProperty(data);
        this.date = dataa;
    }
    public StringProperty dateProperty(){
        return date;
    }

    @Override
    public String toString() {
        return "Search{" +
                "value='" + value + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
