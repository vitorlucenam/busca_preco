package model;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Search;

public class Product {
    private StringProperty name;
    private StringProperty link;
    private DoubleProperty price;
    private Search search;

    public Product(String name, String link, double price, Search search) {
        this.name = new SimpleStringProperty(name);
        this.link = new SimpleStringProperty(link);
        this.price = new SimpleDoubleProperty(price);
        this.search = search;
    }
    public Product(String name, String link, Double price, String searchValue, String searchDate){
        this.name = new SimpleStringProperty(name);
        this.link = new SimpleStringProperty(link);
        this.price = new SimpleDoubleProperty(price);
        this.search = new Search(searchValue, searchDate);
    }
    public StringProperty dateProperty(){
        return this.search.dateProperty();
    }
    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getLink() {
        return link.get();
    }

    public void setLink(String link) {
        this.link.set(link);
    }

    public StringProperty linkProperty() {
        return link;
    }

    public Double getPrice() {
        return price.get();
    }

    public void setPrice(double price) {
        this.price.set(price);
    }
    public DoubleProperty priceProperty(){
        return price;
    }

    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", price=" + price +
                ", search=" + search.toString() +
                '}';
    }
}
